# -*- coding: utf-8 -*-
# @Time    : 2023/2/7 16:25
# @Author  : alvin
# @File    : ele_local_name.py
# @Software: PyCharm
from selenium import webdriver
import  os
base_path = os.path.dirname(os.path.dirname(__file__))
driver_path = os.path.join(base_path,"driver_path","chromedriver.exe")
driver = webdriver.Chrome(executable_path=driver_path)
#打开网址
driver.get("http://novel.hctestedu.com/")
#查找元素 可以通过判断 get_attribute("type") 来进行操作，输入框定位
search_input = driver.find_element_by_name("searchKey")