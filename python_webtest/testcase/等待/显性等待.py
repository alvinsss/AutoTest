# -*- coding: utf-8 -*-
# @Time    : 2023/2/7 19:06
# @Author  : alvin
# @File    : 显性等待.py
# @Software: PyCharm
'''
更加灵活，WebDriverWait 类，显性等待类
driver : webdriver实例
timeout 超时时间
poll_frequency 间隔时间 默认0.5
ignored_exceptions 忽略异常（元祖） -- 一旦发生异常
方法until
method 在等待期间内 每间隔一段时间调用当前方法，如果不能执行False 否则返回值为正常值
message 如果超时 timeoutException 把message传入异常
not_until 当条件不成立继续执行
'''
from  selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.common.by import By
from  selenium.webdriver.support import expected_conditions as EC
from selenium import webdriver
import  os

base_path = (os.path.dirname(os.path.dirname(os.path.dirname(__file__))))
dirver_path = os.path.join(base_path,"driver_path","chromedriver.exe")
print(base_path,dirver_path)

driver = webdriver.Chrome(executable_path=dirver_path)
#打开网址
driver.get("http://novel.hctestedu.com/")
#查找元素 可以通过判断 get_attribute("type") 来进行操作，输入框定位
search_input = driver.find_element_by_id("searchKey")
search_input.send_keys("365")
driver.find_element_by_id("btnSearch").click()
locator=(By.XPATH,'//*[@id="bookList"]/tr/td[3]/a')
# 每隔0.5秒调用until ，元素被显示出来结束，没找到报错 message 不存在
WebDriverWait(driver,5).until(EC.presence_of_element_located(locator),"不存在")
print("当前元素已经被获取到")
driver.quit()
