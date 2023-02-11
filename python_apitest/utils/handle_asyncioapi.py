# -*- coding: utf-8 -*-
# @Time    : 2023/2/11 19:34
# @Author  : alvin
# @File    : handle_asyncioapi.py
# @Software: PyCharm
import threading
import time

import requests

HOST="http://127.0.0.1:9999"
def qatest_createorder(data):
    url=f'{HOST}/api/order/create/'
    payload = data
    resp = requests.post(url,json=payload)
    return resp.json()

"""
查询接口异步返回，30秒超时，5秒请求一次
1、使用id去查询-是createorder返回的
2、次数和频率 -- 频率interal 是5秒
3、超时机制 timeout
"""
def get_order_result(order_id,interal=5 ,timeout=30):
    start_time=time.time()
    #请求超时时间-停止
    end_time = time.time() + timeout
    url=f'{HOST}/api/order/get_result1/'
    payload={"order_id": order_id }
    cnt=0 #查询次数，初始值0
    while time.time() < end_time:
        resp=requests.get(url,params=payload)# {HOST}/api/order/get_result1/?order_id=666666
        cnt +=1
        #如果有响应数据 直接结束循环x
        if resp.text:
            print("第{}次查询，有返结果内容:{},退出查询！".format(cnt,resp.text))
            break
        else:
            print("第{}次查询，没结果，请继续等待！".format(cnt) )
        time.sleep(interal)#间隔5秒频率
    return resp.text

if __name__ == '__main__':
    start_time=time.time()
    data={
        "user_id": "sq123456",
        "goods_id": "20200815",
        "num":1,
        "amount":200.6
    }
    res=qatest_createorder(data)
    print(res)
    order_id=res["order_id"]
    # resp=get_order_result(order_id)
    # print(resp)
    """
    多线程操作，解决等待，创建子线程
    """
    t1=threading.Thread(target=get_order_result,args=(order_id,))
    t1.setDaemon(True)#守护进程
    t1.start()#开始执行子线程
    for one in range(20):
        time.sleep(1)#模拟其它接口执行时间
        print("{}正在执行其它测试".format(one))
    over_time=time.time()
    print("耗时{}秒".format(over_time-start_time))