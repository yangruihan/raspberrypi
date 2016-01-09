#-*- coding:utf-8 -*-

import random

pas_leave_msg_good_list = ['还不错,继续加油', '服务态度不错', '服务很好', '点赞','司机很健谈', '司机态度很好', '很有礼貌' ,'服务很周到', '点赞', '这趟不亏', '值得信赖的司机','人品不错','司机很大方','车子不错','路上没有耽误时间,可以！','好评！','价格不贵','价格很合理']
pas_leave_msg_bad_list = ['什么服务态度', '车技不行','车太破了,我都担心生命安全了','司机是水货','不遵守交通规则,差评！','坐地涨价,我要投诉！','价格不合理','差评', '到处耽误时间','人太凶了','一般般','影响心情','技术不错,就是人长太丑了','驾驶技术不行,建议重新学学吧','开车太不文明','车里面味道大']

dri_leave_msg_good_list = ['乘客很有礼貌', '态度不错', '很健谈', '很合得来希望下次还有机会一起', '还帮我买水喝,好评！', '很有礼貌', '不吵不闹,态度好']
dri_leave_msg_bad_list = ['不爱惜我的车', '在我车上乱扔垃圾,什么素质', '很吵', '完全闭不住嘴', '态度恶劣', '讨价还价', '恶意差评', '坐个车都不老实', '临时要求改目的地']

def gen():
    driver_id = random.randint(459, 10459)
    pas_id = random.randint(612, 10612)
    time = '2015-' + str(random.randint(1, 12)) + '-' + str(random.randint(1, 28)) + ' ' + str(random.randint(8, 22)) + ':' + str(random.randint(0, 59)) + ':' + str(random.randint(0, 59))
    # 乘客对司机的评价
    score1 = random.randint(55, 98)
    # 司机对乘客的评价
    score2 = random.randint(55, 98)

    pas_leave_msg = ''
    if random.randint(1, 30) == 25:
        if score1 >= 75:
            pas_leave_msg = random.choice(pas_leave_msg_good_list)
        else:
            pas_leave_msg = random.choice(pas_leave_msg_bad_list)

    dri_leave_msg = ''
    if random.randint(1, 30) == 25:
        if score2 >= 75:
            dri_leave_msg = random.choice(dri_leave_msg_good_list)
        else:
            dri_leave_msg = random.choice(dri_leave_msg_bad_list)

    # print 'PAS-----'
    # print pas_id, driver_id, time, score1, pas_leave_msg

    # print 'DRI-----'
    # print pas_id, driver_id, time, score1, dri_leave_msg

    with open('PasEvaluation.txt', 'a') as f:
        s = "INSERT INTO pasevaluation (pasID, driverID, time, score, leaveMsg) VALUES(" + str(pas_id) + ',' + str(driver_id) + ",'" + time + "'," + str(score1) + ",'" + pas_leave_msg + "');"
        f.write(s + '\n')

    with open('DriEvaluation.txt', 'a') as f:
        s = "INSERT INTO drievaluation (pasID, driverID, time, score, leaveMsg) VALUES(" + str(pas_id) + ',' + str(driver_id) + ",'" + time + "'," + str(score2) + ",'" + dri_leave_msg + "');"
        f.write(s + '\n')


def main():
    for i in range(1, 100001):
        print '开始生成第' + str(i) + '个数据...'
        gen()
        print '第' + str(i) + '个数据生成完成！'

if __name__ == '__main__':
    main()