    use newsdb;  
      
    /*==============================================================*/  
    /* 初始化新闻类别信息                                           */  
    /*==============================================================*/  
    insert into t_newsType(name) values('国际新闻');  
    insert into t_newsType(name) values('国内新闻');  
    insert into t_newsType(name) values('娱乐新闻');  
    insert into t_newsType(name) values('体育新闻');  
    insert into t_newsType(name) values('财经频道');  
    insert into t_newsType(name) values('汽车频道');  
    insert into t_newsType(name) values('电子频道');  
      
    /*==============================================================*/  
    /* 初始用户信息                                                 */  
    /*==============================================================*/  
      
    insert into t_user(name,password,role) values('admin','admin',1);  
    insert into t_user(name,password,role) values('ruanko','ruanko',0);  