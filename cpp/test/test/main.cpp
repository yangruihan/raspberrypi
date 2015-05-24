//
//  main.cpp
//  test
//
//  Created by 杨睿涵 on 15/5/24.
//  Copyright (c) 2015年 杨睿涵. All rights reserved.
//

#include<iostream>
#include<cstring>
using namespace std;

class Person
{
private:
    char *forename;
    char *surname;
    int money;
public:
    Person(char *f, char *s, int m);
    Person(Person &p);
    ~Person();//析构函数，需要释放空间
    void display();
    
};

Person::Person(char *f, char *s, int m)//构造函数，分别为forename和surname申请新的空间来存储参数f和s指针指向的内容，并输出信息"Constructor id called!"
{
    forename=new char[strlen(f)];
    surname =new char[strlen(s)];
    strcpy(forename,f);
    strcpy(surname,s);
    cout<<"Constructor id called!"<<endl;
}

Person::Person(Person &p)//复制构造函数，并输出信息"Copy Constructor id called!"
{
    forename=new char[strlen(p.forename)];
    surname =new char[strlen(p.surname)];
    strcpy(forename,p.forename);
    strcpy(surname,p.surname);
    cout<<"Copy Constructor id called!"<<endl;
}

Person::~Person()//析构函数，需要释放空间
{
    cout<<"调用析构函数开始"<<endl;
    delete [] forename;
    delete [] surname;
    cout<<"调用析构函数成功"<<endl;
}

void Person::display()//输出信息"Person::display id called!"，并以“forename surname has money.”的形式输出Person的内容
{
    cout<<"Person::display id called!"<<endl;
    cout<<forename<<" "<<surname<<" has "<<money<<endl;
}

//（2）设计自由函数fun，函数的原型声明如下：
void fun(Person p)   //输出信息"fun function id called!"，并调用成员函数display显示形参对象p的信息
{
    cout<<"fun function id called!"<<endl;
    p.display();
}

int main()
{
//    char f[1000],s[1000];
//    double m;
//    int k=0;
//    while(cin>>f>>s>>m)
//    {
//        k++;
//        cout<<"Case #"<<k<<":"<<endl;
//        Person p(f,s,m);
//        fun(p);
//    }
    char *n;
    cin>>n;
    cout<<n;
    return 0;
}
//George Bush 12000
//乔治 华盛顿 200