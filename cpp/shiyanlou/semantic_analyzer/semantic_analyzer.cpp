#include <iostream>
#include <string>
#include <fstream>
#include <cstdlib>
#include <stack>
#include <iomanip>
#include <stdio.h>
#define HANG_NUM 121
#define AC_LIE 38
#define GO_LIE 16
#define MAX_NUM 1000
#define KEY_NUM 11

using namespace std;

struct Expression{  //表达式
    string left;
    int left_num;
    string right[15];
    int num;
    Expression(){
        num = 0;
    }
};
struct Word_code {  //读入单词
    string value;
    int num;
    bool ts;
};
Expression exp[100];
int exp_num = 0;  //表达式数目

struct Sym_tab{    //符号表
    string id;
    int type;       //0char 1int 2double
    int width;
    int offset;
    bool isarray;
    string inside;
    Sym_tab(){
        inside = "";
    }
};
Sym_tab stable[100];
Sym_tab Typ;   //临时符号表
int off_num = 0;   //当前偏移量
int stnum = 0;   //符号表数量
string gra_word[30];   //临时单词

int temp_num = 0;    //临时标量数目
int str_num = 0;    //字符串常量数目
int fag_num = 0;    //跳转标号数目

struct Four_ex{   //四元式
    string op;
    string arg1;
    string arg2;
    string result;
    string fag;
    Four_ex(){
        fag = "";
    }
};
Four_ex fex[500];
int fex_num = 0;    //四元式数目

struct NUM{
    string addr;
    int type;
    string off;
};
NUM tnumber;   //临时数字
NUM NA[50];
int na_num=0;
NUM cc;
NUM T[50];
int T_n = 0;
NUM F[50];
int F_n = 0;
NUM E[50];
int E_n = 0;
NUM AR;

string ROP = "";
int Bfalse[50];
int Btrue[50];
int Bnum = -1;
int Slist[50];

struct Judge{  //布尔表达式
    string E1;
    string ROP;
    string E2;
};
Judge B;

int action[HANG_NUM][AC_LIE];
int go_to[HANG_NUM][GO_LIE];
stack<int> state_stack;
stack<Word_code> word_stack;

string acode[500];
string adata[50];
int cnum = 0;
int dnum = 0;

void exp_in();  //表达式读入
void table_in();  //分析表读入
void grammar_analyze();  //语法分析

int find_id (string name){
    for (int i = 0;i < stnum;i++)
        if (name == stable[i].id) return i;
    return -1;
}
string new_temp(){
    char temp[3];
    //itoa(temp_num,temp,10);
	sprintf(temp,"%d",temp_num);
    string s(temp);
    string ss = "#" + s;
    temp_num++;
    return ss;
}
string new_string(){
    char temp[3];
    //itoa(str_num,temp,10);
	sprintf(temp,"%d",str_num);
    string s(temp);
    string ss = "string" + s;
    str_num++;
    return ss;
}

void exp_in(){  //读入文法
    ifstream input;
    input.open("grammar.txt");
    string str;
    int num;
    while (input >> num >> str){
        exp[exp_num].left_num = num;
        exp[exp_num].left = str;
        string left = str;
        while (input >> str){
            if (str == "->") continue;
            if (str == "|"){
                exp_num++;
                exp[exp_num].left = left;
                exp[exp_num].left_num = num;
                continue;
            }
            if (str == "@"){
                exp_num++;
                break;
            }
            exp[exp_num].right[exp[exp_num].num++] = str;
        }
    }
    input.close();
}

void table_in(){  //分析表读入 action表 goto表
    ifstream input;
    input.open("action.txt");
    for (int i = 0;i < HANG_NUM;i ++)
        for (int j = 0;j < AC_LIE;j ++)
            input >> action[i][j];
    input.close();
    input.open("goto.txt");
    for (int i = 0;i < HANG_NUM;i ++)
        for (int j = 0;j < GO_LIE;j ++)
            input >> go_to[i][j];
    input.close();
}

void grammar_analyze(){
    state_stack.push(0);
    ifstream in;
    ofstream out;
    in.open("lexical_analyze_result.txt");
    out.open("grammar_analyze_result.txt");
    int num;
    string word;
    in >> num;  //把in读到的内容存入num，遇到空格回车等结束
    if (num == 12){  //12 字符串
        char cstr[100];
        in.get();
        in.getline(cstr,99,'\n');  //读一整行
        word = string(cstr);
    }
    else in >> word;
    while (true){
        if (word == "else"){
            Slist[Bnum] = fex_num;
            fex[fex_num].op = "j";
            fex[fex_num].arg1 = "";
            fex[fex_num].arg2 = "";
            fex_num++;
        }
        Word_code w1;
        int top_s = state_stack.top();
        int next = action[top_s][num];
        if (next == MAX_NUM){
            cout << top_s << " " << num << endl;
            cout << "ac_fail!" << endl;
            break;
        }
        else if (next == 0){
            //cout << "grammar analyze success!" << endl;
            break;
        }
        else if (next > 0){
            w1.num = num;
            w1.ts = true;
            w1.value = word;
            state_stack.push(next);
            word_stack.push(w1);
            in >> num;
            if (num == 12){
                char cstr[100];
                in.get();
                in.getline(cstr,99,'\n');
                word = string(cstr);
            }
            else in >> word;
        }
        else{
            next = -next;
            string left = exp[next].left;
            int left_num = exp[next].left_num;
            out << left << " -> ";
            string tmp = " ";
            for(int i = 0;i < exp[next].num;i++){
                Word_code w2;
                w2 = word_stack.top();
                tmp = w2.value + " " + tmp;
                gra_word[exp[next].num-1-i] = w2.value;
                word_stack.pop();
                state_stack.pop();
            }
            out << tmp << endl;
            int index;
            string tt;
            string s;
            char temp[3];
            int cht;
            switch (next){
                case 3:   //TN -> char
                    Typ.type = 0;
                    Typ.width = 1;
                    break;
                case 4:     //TN -> int
                    Typ.type = 1;
                    Typ.width = 2;
                    break;
                case 5:     //TN -> double
                    Typ.type = 2;
                    Typ.width = 8;
                    break;
                case 6:     //array -> id [ inum ]
                    index = find_id(gra_word[0]);
                    if (index == -1 ){
                        cout << "error:";
                        cout << gra_word[0] << "    not defined!" << endl;
                    }
                    else if (!stable[index].isarray){
                        cout << "error:";
                        cout << gra_word[0] << "    not array id!" << endl;
                    }
                    else{
                        tt = new_temp();
                        string ty[3]={"1","2","8"};
                        fex[fex_num].op = "*";
                        fex[fex_num].arg1 = gra_word[2];;
                        fex[fex_num].arg2 = ty[stable[index].type];
                        fex[fex_num].result = tt;
                        fex_num++;
                        AR.addr = gra_word[0];
                        AR.off = tt;
                        AR.type = stable[index].type;
                    }
                    break;
                case 7:     //array -> id [ id ]
                    index = find_id(gra_word[2]);
                    if (index == -1 ){
                        cout << "error:";
                        cout << gra_word[2] << "    not defined!" << endl;
                    }
                    else{
                        index = find_id(gra_word[0]);
                        if (index == -1 ){
                            cout << "error:";
                            cout << gra_word[0] << "    not defined!" << endl;
                        }
                        else if (!stable[index].isarray){
                            cout << "error:";
                            cout << gra_word[0] << "    not array id!" << endl;
                        }
                        else{
                            tt = new_temp();
                            string ty[3]={"1","2","8"};
                            fex[fex_num].op = "*";
                            fex[fex_num].arg1 = gra_word[2];;
                            fex[fex_num].arg2 = ty[stable[index].type];
                            fex[fex_num].result = tt;
                            fex_num++;
                            AR.addr = gra_word[0];
                            AR.off = tt;
                            AR.type = stable[index].type;
                        }
                    }
                    break;
                case 8:     //num -> inum
                    tnumber.addr = gra_word[0];
                    tnumber.type = 1;
                    break;
                case 9:     //num -> dnum
                    tnumber.addr = gra_word[0];
                    tnumber.type = 2;
                    break;
                case 10:       //NA -> id
                    NA[na_num].addr = gra_word[0];
                    NA[na_num].off = "";
                    index = find_id(NA[na_num].addr);
                    if (index == -1){
                        cout << "error:";
                        cout << NA[na_num].addr << "    not defined!" << endl;
                    }
                    else{
                        NA[na_num].type = stable[index].type;
                    }
                    na_num++;
                    break;
                case 11:        //NA -> array
                    NA[na_num] = AR;
                    na_num++;
                    break;
                case 15:         //P -> TN id ;
                    Typ.offset = off_num ;
                    off_num +=  Typ.width;
                    Typ.id = gra_word[1];
                    Typ.isarray = false;
                    if (find_id(Typ.id) == -1)stable[stnum++] = Typ;
                    else {
                        cout << "error:";
                        cout << Typ.id << " multi-defined!" << endl;
                    }
                    break;
                case 16:        //P -> TN id [ num ] ;
                    if (tnumber.type == 2){
                        cout << "error:";
                        cout << gra_word[1] << "    array define error!" << endl;
                    }
                    else{
                        cht = atoi(tnumber.addr.c_str());
                        Typ.isarray = true;
                        Typ.offset = off_num ;
                        Typ.width = cht*Typ.width;
                        off_num += Typ.width;
                        Typ.id = gra_word[1];
                        if (find_id(Typ.id) == -1){
                            stable[stnum++] = Typ;
                        }
                        else {
                            cout << "error:";
                            cout << Typ.id << " multi-defined!" << endl;
                        }
                    }
                    break;
                case 17:    //TN id = ' c ' ;
                    Typ.offset = off_num ;
                    off_num +=  Typ.width;
                    Typ.id = gra_word[1];
                    Typ.isarray = false;
                    if (find_id(Typ.id) == -1){
                        stable[stnum++] = Typ;
                        fex[fex_num].op = "=";
                        fex[fex_num].arg1 = Typ.id;
                        fex[fex_num].arg2 = "";
                        cht =  gra_word[4][0];
                        //itoa(cht,temp,10);
                        sprintf(temp,"%d",cht);
						s = string (temp);
                        fex[fex_num].result = s;
                        fex_num++;
                    }
                    else {
                        cout << "error:";
                        cout << Typ.id << " multi-defined!" << endl;
                    }
                    break;
                case 18:    //TN id = E ;
                    E_n--;
                    Typ.offset = off_num ;
                    off_num += Typ.width;
                    Typ.id = gra_word[1];
                    Typ.isarray = false;
                    if (find_id(Typ.id) == -1){
                        stable[stnum++] = Typ;
                        fex[fex_num].op = "=";
                        fex[fex_num].arg1 = E[E_n].addr;
                        fex[fex_num].arg2 = "";
                        fex[fex_num].result = Typ.id;
                        fex_num++;
                    }
                    else {
                        cout << "error:";
                        cout << Typ.id << " multi-defined!" << endl;
                    }
                    break;
                case 19:    //P -> NA = E ;
                    E_n--;
                    na_num--;
                    temp_num = 0;
                    if (NA[na_num].type < E[E_n].type){
                        cout << "error:";
                        cout << NA[na_num].addr << "    type error!" << endl;
                    }
                    else {
                        if (NA[na_num].off != ""){
                            fex[fex_num].op = "[]=";
                            fex[fex_num].arg1 = NA[na_num].addr;
                            fex[fex_num].arg2 = NA[na_num].off;
                            fex[fex_num].result = E[E_n].addr;
                            fex_num++;
                        }
                        else{
                            fex[fex_num].op = "=";
                            fex[fex_num].arg1 = E[E_n].addr;
                            fex[fex_num].arg2 = "";
                            fex[fex_num].result = NA[na_num].addr;
                            fex_num++;
                        }
                    }
                    break;
                case 20:        //P -> NA = ' c ' ;
                    na_num--;
                    cc.addr = gra_word[3];
                    cc.type = 0;
                    index = find_id(NA[na_num].addr);
                    if (NA[na_num].type != cc.type){
                        cout << "error:";
                        cout << NA[na_num].addr << "    type error!" << endl;
                    }
                    else {
                         if (NA[na_num].off != ""){
                            fex[fex_num].op = "[]=";
                            cht = cc.addr[0];
                            //itoa(cht,temp,10);
                            sprintf(temp,"%d",cht);
							s = string (temp);
                            fex[fex_num].arg1 = NA[na_num].addr;
                            fex[fex_num].arg2 = NA[na_num].off;
                            fex[fex_num].result = s;
                            fex_num++;
                        }
                        else{
                            fex[fex_num].op = "=";
                            cht = cc.addr[0];
                            //itoa(cht,temp,10);
                            sprintf(temp,"%d",cht);
							s = string (temp);
                            fex[fex_num].arg1 = s;
                            fex[fex_num].arg2 = "";
                            fex[fex_num].result = NA[na_num].addr;
                            fex_num++;
                        }
                    }
                    break;
                case 21:     //P -> while ( B ) { S }
                    fex[fex_num].op = "j";
                    fex[fex_num].arg1 = "";
                    fex[fex_num].arg2 = "";
                    //itoa(Btrue[Bnum],temp,10);
					sprintf(temp,"%d",Btrue[Bnum]);
                    s = string (temp);
                    fex[fex_num].result = s;
                    fex_num++;

                    //itoa(fex_num,temp,10);
                    sprintf(temp,"%d",fex_num);
					s = string (temp);
                    fex[Bfalse[Bnum]].result = s;

                    Bnum--;
                    break;
                case 22:    //P -> read NA ;
                    na_num--;
                    fex[fex_num].op = "r";
                    fex[fex_num].arg1 = NA[na_num].addr;
                    if (NA[na_num].off == "-1"){
                        fex[fex_num].arg2 = "";
                    }
                    else fex[fex_num].arg2 = NA[na_num].off;
                    fex[fex_num].result = "";
                    fex_num++;
                    temp_num = 0;
                    break;
                case 23:    //P -> write NA ;
                    na_num--;
                    fex[fex_num].op = "w";
                    fex[fex_num].arg1 = NA[na_num].addr;
                    if (NA[na_num].off == "-1"){
                        fex[fex_num].arg2 = "";
                    }
                    else fex[fex_num].arg2 = NA[na_num].off;
                    fex[fex_num].result = "";
                    fex_num++;
                    temp_num = 0;
                    break;
                case 24:    //P -> write " str " ;
                    stable[stnum].id = new_string();
                    stable[stnum].inside = gra_word[2];
                    stable[stnum].type = 0;
                    stable[stnum].isarray = 1;
                    stable[stnum].offset = off_num;
                    stable[stnum].width = gra_word[2].size();
                    off_num += stable[stnum].width;
                    stnum++;

                    fex[fex_num].op = "w";
                    fex[fex_num].arg1 = stable[stnum-1].id;
                    fex[fex_num].arg2 = "str";
                    fex[fex_num].result = "";
                    fex_num++;
                    break;
                case 25:    //P -> write endl ;
                    fex[fex_num].op = "w";
                    fex[fex_num].arg1 = "endl";
                    fex[fex_num].arg2 = "";
                    fex[fex_num].result = "";
                    fex_num++;
                    break;
                case 26:     //P -> if ( B ) { S }
                    //itoa(fex_num,temp,10);
                    sprintf(temp,"%d",fex_num);
					s = string (temp);
                    fex[Bfalse[Bnum]].result = s;
                    Bnum--;
                    break;
                case 27:     //P -> if ( B ) { S } else { S }
                    //itoa(fex_num,temp,10);
                    sprintf(temp,"%d",fex_num);
					s = string (temp);
                    fex[Slist[Bnum]].result = s;

                    //itoa(Slist[Bnum]+1,temp,10);
                    sprintf(temp,"%d",Slist[Bnum]+1);
					s = string (temp);
                    fex[Bfalse[Bnum]].result = s;
                    Bnum--;
                    break;
                case 28:    //E -> E + T
                    T_n--;
                    E_n--;
                    if (E[E_n].addr[0] == '#') tt = E[E_n].addr;
                    else if (T[T_n].addr[0] == '#') tt = T[T_n].addr;
                    else tt = new_temp();
                    index = (E[E_n].type > T[T_n].type) ? E[E_n].type : T[T_n].type;
                    fex[fex_num].op = "+";
                    fex[fex_num].arg1 = E[E_n].addr;
                    fex[fex_num].arg2 = T[T_n].addr;
                    fex[fex_num].result = tt;
                    fex_num++;
                    E[E_n].addr = tt;
                    E[E_n].type = index;
                    E_n++;
                    break;
                case 29:    //E -> E - T
                    T_n--;
                    E_n--;
                    if (E[E_n].addr[0] == '#') tt = E[E_n].addr;
                    else if (T[T_n].addr[0] == '#') tt = T[T_n].addr;
                    else tt = new_temp();
                    index = (E[E_n].type > T[T_n].type) ? E[E_n].type : T[T_n].type;
                    fex[fex_num].op = "-";
                    fex[fex_num].arg1 = E[E_n].addr;
                    fex[fex_num].arg2 = T[T_n].addr;
                    fex[fex_num].result = tt;
                    fex_num++;
                    E[E_n].addr = tt;
                    E[E_n].type = index;
                    E_n++;
                    break;
                case 30:    //E -> T
                    T_n--;
                    E[E_n].addr = T[T_n].addr;
                    E[E_n].type = T[T_n].type;
                    E_n++;
                    break;
                case 31:    //T -> T * F
                    F_n--;
                    T_n--;
                    if (T[T_n].addr[0] == '#' && F[F_n].addr[0] == '#'){
                        tt = (T[T_n].addr[1] < F[F_n].addr[1]) ? T[T_n].addr : F[F_n].addr;
                    }
                    else if (T[T_n].addr[0] == '#') tt = T[T_n].addr;
                    else if (F[F_n].addr[0] == '#') tt = F[F_n].addr;
                    else tt = new_temp();
                    index = (F[F_n].type > T[T_n].type) ? F[F_n].type : T[T_n].type;
                    fex[fex_num].op = "*";
                    fex[fex_num].arg1 = T[T_n].addr;
                    fex[fex_num].arg2 = F[F_n].addr;
                    fex[fex_num].result = tt;
                    fex_num++;
                    T[T_n].addr = tt;
                    T[T_n].type = index;
                    T_n++;
                    break;
                case 32:    //T -> T / F
                    F_n--;
                    T_n--;
                    if (T[T_n].addr[0] == '#' && F[F_n].addr[0] == '#'){
                        tt = (T[T_n].addr[1] < F[F_n].addr[1]) ? T[T_n].addr : F[F_n].addr;
                    }
                    else if (T[T_n].addr[0] == '#') tt = T[T_n].addr;
                    else if (F[F_n].addr[0] == '#') tt = F[F_n].addr;
                    else tt = new_temp();
                    index = (F[F_n].type > T[T_n].type) ? F[F_n].type : T[T_n].type;
                    fex[fex_num].op = "/";
                    fex[fex_num].arg1 = T[T_n].addr;
                    fex[fex_num].arg2 = F[F_n].addr;
                    fex[fex_num].result = tt;
                    fex_num++;
                    T[T_n].addr = tt;
                    T[T_n].type = index;
                    T_n++;
                    break;
                case 33:    //T -> F
                    F_n--;
                    T[T_n].addr = F[F_n].addr;
                    T[T_n].type = F[F_n].type;
                    T_n++;
                    break;
                case 34:    //F -> ( E )
                    E_n--;
                    F[F_n].addr = E[E_n].addr;
                    F[F_n].type = E[E_n].type;
                    F_n++;
                    break;
                case 35:    //F -> NA
                    na_num--;
                    if (NA[na_num].off != ""){
                        fex[fex_num].op = "=[]";
                        fex[fex_num].arg1 = NA[na_num].addr;
                        fex[fex_num].arg2 = NA[na_num].off;
                        tt = new_temp();
                        fex[fex_num].result = tt;
                        NA[na_num].addr = tt;
                        NA[na_num].off = "";
                        fex_num++;
                    }
                    F[F_n].addr = NA[na_num].addr;
                    F[F_n].type = NA[na_num].type;
                    F_n++;
                    break;
                case 36:    //F -> num
                    F[F_n].addr = tnumber.addr;
                    F[F_n].type = tnumber.type;
                    F_n++;
                    break;
                case 37:     //B -> E ROP E
                    E_n--;
                    B.E2 = E[E_n].addr;
                    B.ROP = ROP;
                    ROP = "";
                    Bnum++;
                    Btrue[Bnum] = fex_num;
                    Bfalse[Bnum] = fex_num+1;
                    fex[fex_num].op = "j" + B.ROP;
                    fex[fex_num].arg1 = B.E1;
                    fex[fex_num].arg2 = B.E2;
                    //itoa(fex_num+2,temp,10);
                    sprintf(temp,"%d",fex_num+2);
					s = string (temp);
                    fex[fex_num].result = s;
                    fex_num++;
                    fex[fex_num].op = "j";
                    fex[fex_num].arg1 = "";
                    fex[fex_num].arg2 = "";
                    fex_num++;
                    E_n++;
                    temp_num = 0;
                    break;
                case 38:     //ROP -> >
                    B.E1 = E[E_n-1].addr;
                    ROP = gra_word[0];
                    break;
                case 39:     //ROP -> <
                    B.E1 = E[E_n-1].addr;
                    ROP = gra_word[0];
                    break;
                case 40:     //ROP -> >=
                    B.E1 = E[E_n-1].addr;
                    ROP = gra_word[0];
                    break;
                case 41:     //ROP -> <=
                    B.E1 = E[E_n-1].addr;
                    ROP = gra_word[0];
                    break;
                case 42:     //ROP -> ==
                    B.E1 = E[E_n-1].addr;
                    ROP = gra_word[0];
                    break;
                case 43:     //ROP -> !=
                    B.E1 = E[E_n-1].addr;
                    ROP = gra_word[0];
                    break;
            }
            w1.num = left_num;
            w1.value = left;
            w1.ts = false;
            word_stack.push(w1);
            top_s = state_stack.top();
            next = go_to[top_s][left_num];
            if (next == MAX_NUM){
                cout << top_s << " " << left_num << endl;
                cout << "go_fail!" << endl;
                break;
            }
            else{
                state_stack.push(next);
            }
        }
    }
    in.close();
    out.close();
}

void semantic_out(){
    ofstream out;
    out.open("semantic_result.txt");  //输出语义分析结果
    for (int i = 0;i<fex_num;i++){
        out << i << " ( ";
        out << fex[i].op << " , ";
        out << fex[i].arg1 << " , ";
        out << fex[i].arg2 << " , ";
        out << fex[i].result << " )";
        out << endl;
    }
    out.close();

    out.open("sybol_table.txt");  //输出符号表
    for (int i = 0;i < stnum;i++){
        out << stable[i].id << " ";
        out << stable[i].type << " ";
        out << stable[i].width << " ";
        out << stable[i].offset << " ";
        out << stable[i].isarray << endl;
    }
    out.close();

    cout << "semantic analyze success!" << endl;
}

int main()
{
    exp_in();     //表达式读入
    table_in();   //分析表读入
    grammar_analyze();  //语法分析+语义分析
	semantic_out();  //输出语义分析结果
 
    return 0;
}