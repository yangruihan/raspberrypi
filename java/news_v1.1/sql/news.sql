    drop database if exists newsdb;  
      
    /*==============================================================*/  
    /* Database: newsdb       ����ϵͳ���ݿ�                        */  
    /*==============================================================*/  
    create database newsdb;  
      
    use newsdb;  
      
    /*==============================================================*/  
    /* Table: t_user        �û���                                  */  
    /*==============================================================*/  
    create table t_user  
    (  
       id                   int not null primary key auto_increment, -- '�ؼ��֣������ֶ�'  
       name                 varchar(50) not null,-- '�û�����'  
       password             varchar(50) not null,-- '����'  
       role                 int not null default 0,-- '��ɫ��0����ͨ�༭��1������Ա��'  
       del                  int not null default 0 -- 'ɾ��״̬��0��δɾ����1����ɾ����'  
    );  
      
    /*==============================================================*/  
    /* Table: t_newsType       ��������                           */  
    /*==============================================================*/  
    create table t_newsType  
    (  
       id                   int not null primary key auto_increment, -- '�ؼ��֣������ֶ�'  
       name                 varchar(50) not null,-- '�������'  
       description          varchar(100),-- '����'  
       createTime           timestamp,-- '����ʱ��'  
       orders               int,-- '��������Ĭ��0�����򣬱����ֶ�'  
       del                  int not null default 0 -- 'ɾ��״̬��0��δɾ����1����ɾ����'  
    );  
      
    /*==============================================================*/  
    /* Table: t_news      ���ű�                                    */  
    /*==============================================================*/  
    create table t_news  
    (  
       id                   int not null primary key auto_increment, -- '�ؼ��֣������ֶ�'  
       user_id              int not null,-- '¼���ߣ��û�id�����������t_user(id)'  
       newsType_id          int not null,-- '�������id�����������t_newsType(id)'  
       title                varchar(50) not null,-- '���ű���'  
       author               varchar(20) not null,-- '����'  
       keywords             varchar(20),-- '�ؼ���'  
       source               varchar(100),-- '������Դ'  
       content              text,-- '��������'  
       createTime           timestamp,-- '����ʱ��'  
       click                int default 0,-- '�������'  
       state                int not null default 0, -- '����״̬��0��δɾ����1���ѷ�����2���ѷ�����'  
       del                  int not null default 0, -- 'ɾ��״̬��0��δɾ����1����ɾ����'  
       constraint FK_newstype_news foreign key (newsType_id)  
          references t_newsType (id) ,  
       constraint FK_user_news foreign key (user_id)  
          references t_user (id)  
    );  
      
    /*==============================================================*/  
    /* Table: t_attachment    ������                                */  
    /*==============================================================*/  
    create table t_attachment  
    (  
       id                   int not null primary key auto_increment, -- '�ؼ��֣������ֶ�'  
       news_id              int not null,-- '����id�����������t_news(id)'  
       fileName             varchar(40) not null, -- '�ļ�����'  
       path                 varchar(100) not null,-- '·��'  
       type                 varchar(10) not null,-- '����'  
       uploadTime           timestamp not null default CURRENT_TIMESTAMP,-- '�ϴ�ʱ��'  
       del                  int not null default 0, -- 'ɾ��״̬��0��δɾ����1����ɾ����'  
       constraint FK_news_attachment foreign key (news_id)  
          references t_news (id)  
    );  