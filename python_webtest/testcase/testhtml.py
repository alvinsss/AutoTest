# -*- coding: utf-8 -*-
# @Time    : 2023/2/8 15:01
# @Author  : alvin
# @File    : testhtml.py
# @Software: PyCharm
import os
import time

import pytest
from selenium import webdriver

base_path = os.path.dirname(os.path.dirname(__file__))
dirver_path = os.path.join(base_path,"driver_path","chromedriver.exe")
print(base_path,dirver_path)
@pytest.mark.temp
def testhtml_test1():
    print("testhtml_test1 temp")
    dr = webdriver.Chrome(executable_path=dirver_path)
    dr.get("http://www.baidu.com")
    time.sleep(2)
    dr.quit()

@pytest.mark.api
def testhtml_test2():
    print("testhtml_test2 api")
    dr = webdriver.Chrome(executable_path=dirver_path)
    dr.get("https://www.sogou.com")
    time.sleep(2)
    dr.quit()

@pytest.mark.api
def testhtml_test3():
    print("testhtml_test3 web")
    dr = webdriver.Chrome(executable_path=dirver_path)
    dr.get("http://127.0.0.1:5244")
    time.sleep(2)
    dr.quit()

@pytest.mark.api
def testhtml_test4():
    print("testhtml_test4 web")
    dr = webdriver.Chrome(executable_path=dirver_path)
    dr.get("https://blog.51cto.com")
    time.sleep(2)
    dr.quit()
# @pytest.mark.api
# @pytest.mark.flaky(reruns=2, reruns_delay=5)
# def testhtml_test4():
#     print("testhtml_test4 api")
#     assert  1 !=2

# @pytest.mark.api
# def testhtml_test3():
#     print("testhtml_test3 api")
#     assert  2 !=2


if __name__ == '__main__':
    # pytest.main(['-s', 'testhtml.py' ,'--reruns 3', '--reruns-delay 5'])
    # pytest.main(['-s', 'testhtml.py', '-n', '2']) #27.91s
    pytest.main(['-s' ,'testhtml.py'])

    #