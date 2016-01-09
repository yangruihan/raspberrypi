#-*- coding:utf-8 -*-

author = 'yrh'

import random
import string

TYPE_PAS = 1000
TYPE_DRI = 1001

user_name_set = set()
name_set = set()
phone_num_set = set()

user_name_first_name = ['Zhao', 'zhao', 'Qian', 'qian', 'Sun', 'sun', 'Li', 'li', 'Zhou', 'zhou', 'Wu', 'wu', 'Zhen', 'zhen', 'Wang','wang', 'Feng', 'feng', 'Chen', 'chen', 'Zhu', 'zhu', 'Wei', 'wei', 'Jiang', 'jiang', 'Shen', 'shen', 'Han', 'han', 'Yang', 'yang', 'Zhu', 'zhu', 'Qin', 'qin', 'You', 'you', 'Xu', 'xu', 'He', 'he', 'Lv', 'lv', 'Shi', 'shi', 'Zhang', 'zhang', 'Ma', 'ma']
user_name_last_name = ['yuqi', 'yaoyang', 'yunchuan', 'zhizhong', 'zuolin', 'daming', 'kaiming', 'gongqing', 'ting', 'aijia', 'enzhao', 'hongliang', 'huichun', 'yunning', 'wentian', 'tielin', 'junning', 'youhe', 'haifeng', 'ye', 'dashan', 'hanyu', 'jingchu', 'jingxuan', 'manyu', 'dingfa', 'keyi', 'xingzhe', 'yongzhen', 'shangkun', 'zhijiong', 'chuantang', 'tongshu', 'zaibao', 'hongji', 'jian', 'side', 'ji', 'guoping', 'laier', 'shouzhi', 'yinshen', 'chengling', 'yuting', 'jiaren', 'siqi']
pass_word_pre = ['111111', '000000', '111111111', '123456789', '000000000', 'a111111', 'abcdefg']
pass_word_las = ['123', '111', '0', '11', '000', '15', '16', '13', '14']
phone_pre = ['139', '138', '137', '136', '135', '134', '159', '158', '157', '150', '151', '152', '188', '130', '131', '132', '156', '155', '133', '153', '189']

def gen(num, type):
    result = []
    for i in range(num + 1):
        # 生成用户名
        user_num = random.randint(9, 16) # 用户名一共的长度
        user_name = random.choice(user_name_first_name) + random.choice(user_name_last_name)
        name = user_name
        if (len(user_name) < user_num):
            for i in range(user_num - len(user_name)):
                user_name += str(random.randint(0, 9))
        while user_name.lower() in name_set or len(user_name) > 20:
            user_num = random.randint(9, 16) # 用户名一共的长度
            user_name = random.choice(user_name_first_name) + random.choice(user_name_last_name)
            name = user_name
            if (len(user_name) < user_num):
                for i in range(user_num - len(user_name)):
                    user_name += str(random.randint(0, 9))
        name_set.add(user_name.lower())

        # 生成密码
        pass_r = random.randint(1, 6)
        if pass_r == 1:
            pass_word = random.choice(pass_word_pre)
        elif pass_r == 2:
            pass_word = user_name
        elif pass_r == 3:
            pass_word = user_name + random.choice(pass_word_las)
        else:
            pass_word = str(random.randint(1950, 2015)) + str(random.randint(1, 12)) + str(random.randint(1,31))
        while len(pass_word) > 20 or len(pass_word) < 6:
            pass_r = random.randint(1, 6)
            if pass_r == 1:
                pass_word = random.choice(pass_word_pre)
            elif pass_r == 2:
                pass_word = user_name
            elif pass_r == 3:
                pass_word = user_name + random.choice(pass_word_las)
            else:
                pass_word = str(random.randint(1800, 2015)) + str(random.randint(1, 12)) + str(random.randint(1,31))

        # 生成手机号码
        phone_num = random.choice(phone_pre) + str(random.randint(00000000, 99999999))
        while phone_num in phone_num_set:
            phone_num = random.choice(phone_pre) + str(random.randint(00000000, 99999999))
        phone_num_set.add(phone_num)

        # 如果是司机的话，加上一个驾驶年限
        if type == TYPE_DRI:
            driving_years = str(random.randint(3, 20))
            result.append('INSERT INTO driver (username,password,drivingYears,name,phoneNum) VALUES(' + "'" + user_name + "'" + ',' + "'" +  pass_word + "'" +  ',' + driving_years + ',' + "'" +  name.lower() + "'" + ',' + "'" + phone_num + "'" + ');')
        else:
            result.append('INSERT INTO passenger (username,password,name,phoneNum) VALUES(' + "'" + user_name + "'" + ',' + "'" +  pass_word + "'" + ',' + "'" +  name.lower() + "'" + ',' + "'" +  phone_num  + "'" + ');')

    return result

def main():
    with open('driver_res.txt', 'w') as driver_file:
        driver_res = gen(10000, TYPE_DRI)
        for d in driver_res:
            driver_file.write(d + '\n')

    with open('pas_res.txt', 'w') as driver_file:
        driver_res = gen(10000, TYPE_PAS)
        for d in driver_res:
            driver_file.write(d + '\n')

    print 'Generate Successfully!'

if __name__ == '__main__':
    main()