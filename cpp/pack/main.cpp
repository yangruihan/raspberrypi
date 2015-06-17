#include <iostream>
#include <cstdlib>
#include <string>
#include <windows.h>

const int MAX_STACK = 3;
SYSTEMTIME sys;

using namespace std;

typedef struct Time
{
    int hh;
    int mm;
}Time;

typedef struct CarNode
{
    int num;
    Time reach;
    Time leave;
}CarNode;

typedef struct SeqStackCar
{
    CarNode car;
    CarNode elem[MAX_STACK+1];
    int top;
    int base;
    int stacksize;
}SeqStackCar, TemStackCar;

/**
typedef struct TemStackCar
{
    CarNode car;
    CarNode elem[MAX_STACK];
    int top;
    int base;
    int stacksize;
}TemStackCar;
**/

typedef struct QueueNode
{
    CarNode data;
    QueueNode *next;
}QueueNode;

typedef struct LinkQueueCar
{
    QueueNode *head;
    QueueNode *rear;
}LinkQueueCar;

void Arrival(SeqStackCar &S,LinkQueueCar &Q,int carNum);
void Leave(SeqStackCar &S,TemStackCar &T,LinkQueueCar &Q);
void List(SeqStackCar&S,LinkQueueCar &Q);
void Push(SeqStackCar &S,CarNode &C);
void Pop(SeqStackCar &S,CarNode &C);
void InitStack(SeqStackCar &S);
void PopTem(TemStackCar &T,CarNode &C);
void PushTem(TemStackCar &T,CarNode &C);
bool isStackFull(SeqStackCar &S);
void InitLinkQueue(LinkQueueCar &Q);
void EnLinkedQueue(LinkQueueCar &Q,CarNode &C);
bool DlLinkedQueue(LinkQueueCar &Q,CarNode &C,QueueNode *q);
int LengthQueue(LinkQueueCar &Q);


int main ()
{
    SeqStackCar Enter;
    LinkQueueCar Wait;
    TemStackCar Tem;
    int ch;

    InitStack(Enter);//��ʼ����վ
    InitStack(Tem); // ��ʼ����ʱվ
    InitLinkQueue(Wait); //��ʼ��ͨ��

    int flag = 1;

    while(flag)
    {
        int carNum;
        cout << "\n 1.the car arrive\n 2.the car leave \n 3.List the information \n 4.Quit\n";
        cin >>ch;

        switch(ch)
        {
        case 1://��������
            cout<<"\n Please input the number of the car:";
            cin >> carNum;
            Arrival(Enter,Wait,carNum);
            break;

        case 2://�����뿪
            Leave(Enter,Tem,Wait);
            break;

        case 3://��ӡ��Ϣ
            List(Enter,Wait);
            break;

        case 4://�˳�
            exit(0);

        default:
            cout<<"error!"<<endl;
            break;
        }
    }
}

void Arrival(SeqStackCar &S,LinkQueueCar &Q,int carNum)
{
    CarNode car;
    car.num = carNum;
    if(!isStackFull(S))//����δ��
    {
        GetLocalTime(&sys);
        car.reach.hh = sys.wHour;
        car.reach.mm = sys.wMinute;
        Push(S,car);
        cout << "���ѽ��복��" <<endl;
        cout << "��ǰ��������" << S.top << "����" <<endl;
    }
    else//��������
    {
        cout<<"\n�ó�����ͨ���ȴ���";
        EnLinkedQueue(Q,car);
    }
}

void Leave(SeqStackCar &S,TemStackCar &T,LinkQueueCar &Q)
{
    CarNode car;
    int i ;
    cout <<"\n�ڼ����뿪��";
    cin >> i;
    if(i > S.top || i == 0) // �����ǰ�����ֵ����ջ�ڸ���
       cout <<"û����ô�೵" <<endl;
    else
    {
        int j = S.top;

        while(S.top != j-i+1 )
        {
            Pop(S,car);
            PushTem(T,car);
        }

        Pop(S, car);
        GetLocalTime(&sys);
        car.leave.hh = sys.wHour;
        car.leave.mm = sys.wMinute;

        cout <<"ͣ��ʱ�乲��"<<car.leave.hh-car.reach.hh<<"Сʱ"<<car.leave.mm-car.reach.mm<<"����"<<endl;

        while(T.top > 0)
        {
            PopTem(T,car);
            Push(S,car);
        }

        QueueNode *q;
        if (DlLinkedQueue(Q,car,q))
        {
            GetLocalTime(&sys);
            car.reach.hh = sys.wHour;
            car.reach.mm = sys.wMinute;
            Push(S,car);
            free(q);
        }
        cout<<"�����뿪�ɹ�"<<endl;
    }
}

void List(SeqStackCar&S,LinkQueueCar &Q)
{
      CarNode car;
      cout << "�����й���"<<S.top<<"����"<<endl;
      int i = S.top - 1;
      int j = S.top;
      while(i>=0)
      {
          car = S.elem[i];
          cout<<"��"<<j-i<<"����:"<<endl;
          cout<<"���ƺ�Ϊ��"<<car.num;
          cout<<"���ʱ��Ϊ��"<<car.reach.hh<<":"<<car.reach.mm<<endl;
          i--;
      }
      cout << "ͨ���Ϲ���" << LengthQueue(Q) << "����"<<endl;
}

void InitStack(SeqStackCar &S)
{
    S.base = 0;
    S.top = S.base;
    S.stacksize = MAX_STACK+1;
}

void Push(SeqStackCar &S,CarNode &C)
{
    S.elem[S.top] = C;
    S.top++;
}

void PopTem(TemStackCar &T,CarNode &C)
{
    T.top--;
    C = T.elem[T.top];
}

void PushTem(TemStackCar &T,CarNode &C)
{
    T.elem[T.top] = C;
    T.top++;
}

void Pop(SeqStackCar &S,CarNode &C)
{
    S.top -- ;
    C = S.elem[S.top];
}

bool isStackFull(SeqStackCar &S)
{
    if(S.top - S.base >= S.stacksize) return 1;
    else return 0;
}

void InitLinkQueue(LinkQueueCar &Q)
{
    QueueNode *qn = (QueueNode*)malloc(sizeof(QueueNode));
    Q.head = qn;
    Q.head ->next = NULL;
    Q.rear = Q.head;
}

void EnLinkedQueue(LinkQueueCar &Q,CarNode &C)
{
    QueueNode *p = (QueueNode*)malloc(sizeof(QueueNode));
    p->data = C;
    p->next = NULL;
    Q.rear->next = p;
    Q.rear = p;
}

bool DlLinkedQueue(LinkQueueCar &Q,CarNode &C,QueueNode *p)
{
    if (Q.head->next == NULL) {
        return 0;
    }
    p = Q.head ->next;
    C = p ->data;
    Q.head->next = p->next;
    //if(Q.head == p)Q.rear == Q.head;
    return 1;
}

int LengthQueue(LinkQueueCar &Q)
{
    QueueNode *p;
    p = Q.head->next;
    int i = 1;
    while(p)
    {
        p=p->next;
        ++i;
    }
    return i-1;
}

