#include <iostream>
#include <string>
#include <fstream>
#include <cstdlib>
#include <stack>
#include <iomanip>
#include <stdio.h>

#define KEY_NUM 11

using namespace std;

string keyword[KEY_NUM] = {"main", "char", "int", "double", "if", "else", "while", "read", "write", "func", "endl"};

int keyjudge (string word){  //判断关键字或标识符
    for (int i = 0;i < KEY_NUM;i++)
        if (keyword[i] == word) return i;
    return KEY_NUM +2;
}

void lexical_analyze(){
    fstream readin;
    ofstream output;
    output.open("lexical_analyze_result.txt"); //输出词法分析结果
    string word;
    bool eof = false;
    bool ready = true;
    bool dot = false;
    int pos,kcn;
    char ch;
    char tword[50];
    readin.open ("test.c",ios::in); //读源码文件
    while (!readin.eof()){
        if (ready)readin.get(ch);
        else ready = true;
		
        if (ch == 32 || ch == 10 || ch == 13 || ch ==9) continue;  //ASCII值：空格、换行、回车、Tab
		
        if ((ch >= 'a' && ch <= 'z')|| (ch >= 'A' && ch <= 'Z')) {  //读到一个字母
            pos = 0;
            tword[pos++] = ch;
            while (readin.get(ch)){  //继续读，直到这个单词结束
                if ((ch >= 'a' && ch <= 'z')|| (ch >= 'X' && ch <= 'Z') || (ch >= '0' && ch <= '9')){
                    if (pos < 49) tword[pos++] = ch;  //将读取的单词保存在tword
                    if (readin.eof()) eof = true;
                }
                else break;
            }
            tword[pos] = 0;
            word = string(tword);
            kcn = keyjudge(word);  //判断单词符号的类别
            output << setw(10) << kcn << " " << setw(10) << word << endl;  //输出这个单词和类别
            if (eof == true) break;
            ready = false;
        }
		
        else if (ch >= '0' && ch <= '9'){  //读取数字
            dot = false;
            pos = 0;
            tword[pos++] = ch;
            while (readin.get(ch)){
                if (ch >= '0' && ch <= '9'){
                    if (pos < 49) tword[pos++] = ch;
                    if (readin.eof()) eof = true;
                }
                else if (ch == '.'){
                    if (!dot) {
                        if (pos < 49) tword[pos++] = ch;
                        if (readin.eof()) eof = true;
                        dot = true;
                    }
                    else break;
                }
                else break;
            }
            tword[pos] = 0;
            word = string(tword);
            kcn = KEY_NUM +3;
            if (dot) kcn = KEY_NUM +4;
            output << setw(10) << kcn << " " << setw(10) << word << endl;
            if (eof == true) break;
            ready = false;
        }
		
        else if (ch == '\''){
            kcn = KEY_NUM +23;
            output << setw(10) << kcn << " " << setw(10) << ch << endl;
            readin.get(ch);
            if (ch != '\'' && ch != '\"'){
                kcn = KEY_NUM +0;
                output << setw(10) << kcn << " " << setw(10) << ch << endl;
                readin.get(ch);
                if (ch == '\'') {
                    kcn = KEY_NUM +23;
                    output << setw(10) << kcn << " " << setw(10) << ch << endl;
                }
                else {
                    kcn = -1;
                    output << setw(10) << kcn << " " << setw(10) << ch << endl;
                }
            }
            else if (ch == '\''){
                kcn = KEY_NUM +23;
                output << setw(10) << kcn << " " << setw(10) << ch << endl;
            }
            else{
                kcn = -1;
                output << setw(10) << kcn << " " << setw(10) << ch << endl;
            }
        }
		
        else if (ch == '\"'){  //读到一个双引号
            pos = 0;
            kcn = KEY_NUM +24;
            output << setw(10) << kcn << " " << setw(10) << ch << endl;
            while (readin.get(ch)){  //读取双引号括起来的内容
                if (ch != '\'' && ch != '\"'){  //如果没有遇到下一个引号，继续读取
                    if (pos < 49) tword[pos++] = ch;
                }
                else break;
            }
            tword[pos] = 0;
            word = string(tword);
            kcn = KEY_NUM +1;  //如果没有遇到下一个引号，继续读取
            output << setw(10) << kcn << " " << setw(10) << word << endl;  //输出该字符串
			
            if (ch == '\"'){  //读取到配对的双引号
                kcn = KEY_NUM +24;
                output << setw(10) << kcn << " " << setw(10) << ch << endl;
            }
            else {
                kcn = -1;
                output << setw(10) << kcn << " " << setw(10) << ch << endl;
            }
        }
		
        else{
            switch (ch){
                case '+':
                    kcn = KEY_NUM +11;
                    output << setw(10) << kcn << " " << setw(10) << ch << endl;
                    break;
                case '-':
                    kcn = KEY_NUM +12;
                    output << setw(10) << kcn << " " << setw(10) << ch << endl;
                    break;
                case '*':
                    kcn = KEY_NUM +14;
                    output << setw(10) << kcn << " " << setw(10) << ch << endl;
                    break;
                case '/':
                    if (readin.eof()){
                        kcn = KEY_NUM +13;  //判断为除法符号
                        output << setw(10) << kcn << " " << setw(10) << ch << endl;
                        eof = true;
                        break;
                    }
                    readin.get(ch);
                    if (ch == '*'){  //读取到配对的双引号
                        while (!readin.eof()){
                            readin.get(ch);
                            if (ch == '*'){  //直到配对的注释符号出现，其中的内容都被忽略了
                                readin.get(ch);
                                if (ch == '/') break;
                            }
                        }
                    }
                    else{
                        kcn = KEY_NUM +13;
                        output << setw(10) <<  kcn << setw(10) << "/ " << endl;
                        ready = false;
                    }
                    break;
                case '=':
                    if (readin.eof()){
                        kcn = KEY_NUM +15;
                        output << setw(10) << kcn << " " << setw(10) << ch << endl;
                        eof = true;
                        break;
                    }
                    readin.get(ch);
                    if (ch == '='){
                        kcn = KEY_NUM +16;
                        output << setw(10) << kcn << setw(10) << "== " << endl;
                    }
                    else {
                      kcn = KEY_NUM +15;
                      output << setw(10) << kcn << " " << setw(10) << '=' << endl;
                      ready = false;
                    }
                    break;
                case ';':
                    kcn = KEY_NUM +25;
                    output << setw(10) << kcn << " " << setw(10) << ch << endl;
                    break;
                case '>':
                    if (readin.eof()){
                        kcn = KEY_NUM +18;
                        output << setw(10) << kcn << " " << setw(10) << ch << endl;
                        eof = true;
                        break;
                    }
                    readin.get(ch);
                    if (ch == '=') {
                        kcn = KEY_NUM +20;
                        output << setw(10) << kcn << setw(10) << ">= " << endl;
                    }
                    else {
                        kcn = KEY_NUM +18;
                        output << setw(10) << kcn << " " << setw(10) << '>' << endl;
                        ready = false;
                    }
                    break;
                case '<':
                    if (readin.eof()){
                        kcn = KEY_NUM +19;
                        output << setw(10) << kcn << " " << setw(10) << ch << endl;
                        eof = true;
                        break;
                    }
                    readin.get(ch);
                    if (ch == '=') {
                        kcn = KEY_NUM +21;
                        output << setw(10) << kcn << setw(10) << "<= " << endl;
                    }
                    else {
                        kcn = KEY_NUM +19;
                        output << setw(10) << kcn << " " << setw(10) << '<' << endl;
                        ready = false;
                    }
                    break;
                case '!':
                    if (readin.eof()){
                        kcn = -1;
                        output << setw(10) << kcn << " " << setw(10) << ch << endl;
                        eof = true;
                        break;
                    }
                    readin.get(ch);
                    if (ch == '=') {
                        kcn = KEY_NUM +17;
                        output << setw(10) << kcn << setw(10) << "<= " << endl;
                    }
                    else {
                        kcn = -1;
                        output << setw(10) << kcn << " " << setw(10) << '!' << ch << endl;
                        ready = false;
                    }
                    break;
                case '(':
                    kcn = KEY_NUM +9;
                    output << setw(10) << kcn << " " << setw(10) << ch << endl;
                    break;
                case ')':
                    kcn = KEY_NUM +10;
                    output << setw(10) << kcn << " " << setw(10) << ch << endl;
                    break;
                case '[':
                    kcn = KEY_NUM +7;
                    output << setw(10) << kcn << " " << setw(10) << ch << endl;
                    break;
                case ']':
                    kcn = KEY_NUM +8;
                    output << setw(10) << kcn << " " << setw(10) << ch << endl;
                    break;
                case '{':
                    kcn = KEY_NUM +5;
                    output << setw(10) << kcn << " " << setw(10) << ch << endl;
                    break;
                case '}':
                    kcn = KEY_NUM +6;
                    output << setw(10) << kcn << " " << setw(10) << ch << endl;
                    break;
                case ',':
                    kcn = KEY_NUM +22;
                    output << setw(10) << kcn << " " << setw(10) << ch << endl;
                    break;
                default:
                    kcn = -1;
                    output << setw(10) << kcn << " " << setw(10) << ch << endl;

            }
        if (eof == true) break;
        }
    }
	
    kcn = KEY_NUM +26;
    output << setw(10) << kcn << setw(10) << "# " << endl;  //词法分析结果以“#”结束
	
    cout << "lexical analyze success!" << endl;
    readin.close();
    output.close();
}
int main()
{
    lexical_analyze();
 
    return 0;
}