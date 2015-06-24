    drop database if exists newsdb;  
      
    /*==============================================================*/  
    /* Database: newsdb       新闻系统数据库                        */  
    /*==============================================================*/  
    create database newsdb;  
      
    use newsdb;  
      
    /*==============================================================*/  
    /* Table: t_user        用户表                                  */  
    /*==============================================================*/  
    create table t_user  
    (  
       id                   int not null primary key auto_increment, -- '关键字，自增字段'  
       name                 varchar(50) not null,-- '用户名称'  
       password             varchar(50) not null,-- '密码'  
       role                 int not null default 0,-- '角色（0、普通编辑，1、管理员）'  
       del                  int not null default 0 -- '删除状态（0、未删除，1、已删除）'  
    );  
      
    /*==============================================================*/  
    /* Table: t_newsType       新闻类别表                           */  
    /*==============================================================*/  
    create table t_newsType  
    (  
       id                   int not null primary key auto_increment, -- '关键字，自增字段'  
       name                 varchar(50) not null,-- '类别名称'  
       description          varchar(100),-- '描述'  
       createTime           timestamp,-- '创建时间'  
       orders               int,-- '用于排序，默认0不排序，备用字段'  
       del                  int not null default 0 -- '删除状态（0、未删除，1、已删除）'  
    );  
      
    /*==============================================================*/  
    /* Table: t_news      新闻表                                    */  
    /*==============================================================*/  
    create table t_news  
    (  
       id                   int not null primary key auto_increment, -- '关键字，自增字段'  
       user_id              int not null,-- '录入者，用户id，外键，引用t_user(id)'  
       newsType_id          int not null,-- '新闻类别id，外键，引用t_newsType(id)'  
       title                varchar(50) not null,-- '新闻标题'  
       author               varchar(20) not null,-- '作者'  
       keywords             varchar(20),-- '关键字'  
       source               varchar(100),-- '新闻来源'  
       content              text,-- '新闻内容'  
       createTime           timestamp,-- '创建时间'  
       click                int default 0,-- '点击次数'  
       state                int not null default 0, -- '新闻状态（0、未删除，1、已发布，2、已废弃）'  
       del                  int not null default 0, -- '删除状态（0、未删除，1、已删除）'  
       constraint FK_newstype_news foreign key (newsType_id)  
          references t_newsType (id) ,  
       constraint FK_user_news foreign key (user_id)  
          references t_user (id)  
    );  
      
    /*==============================================================*/  
    /* Table: t_attachment    附件表                                */  
    /*==============================================================*/  
    create table t_attachment  
    (  
       id                   int not null primary key auto_increment, -- '关键字，自增字段'  
       news_id              int not null,-- '新闻id，外键，引用t_news(id)'  
       fileName             varchar(40) not null, -- '文件名称'  
       path                 varchar(100) not null,-- '路径'  
       type                 varchar(10) not null,-- '类型'  
       uploadTime           timestamp not null default CURRENT_TIMESTAMP,-- '上传时间'  
       del                  int not null default 0, -- '删除状态（0、未删除，1、已删除）'  
       constraint FK_news_attachment foreign key (news_id)  
          references t_news (id)  
    );  