#Raspberry Pi 基本设置

##改变更新源
~~~sh
sudo vi /etc/apt/sources.list 
~~~

将默认的更新源用#号屏蔽，并改为
- deb http://mirrors.ustc.edu.cn/raspbian/raspbian/ wheezy main contrib non-free rpi
- 或 deb http://mirror.nus.edu.sg/raspbian/raspbian/ wheezy main contrib non-free rpi
也可以为下面的地址：
- 中山大学
\- Raspbian http://mirror.sysu.edu.cn/raspbian/raspbian/

- 中国科学技术大学
\- Raspbian http://mirrors.ustc.edu.cn/raspbian/raspbian/

- 清华大学
\- Raspbian http://mirrors.tuna.tsinghua.edu.cn/raspbian/raspbian/

- 华中科技大学
\- Raspbian http://mirrors.hustunique.com/raspbian/raspbian/
\- Arch Linux ARM http://mirrors.hustunique.com/archlinuxarm/

- 大连东软信息学院
\- Raspbian http://mirrors.neusoft.edu.cn/raspbian/raspbian/
