# -*- coding: utf-8 -*-
# @Time    : 2023/2/7 16:25
# @Author  : alvin
# @File    : ele_local_name.py
# @Software: PyCharm
from selenium import webdriver
import  os
import time

base_path = (os.path.dirname(os.path.dirname(__file__)))
dirver_path = os.path.join(base_path,"driver_path","chromedriver.exe")
print(base_path,dirver_path)

driver = webdriver.Chrome(executable_path=dirver_path)
#打开网址
driver.get("http://novel.hctestedu.com/")
#查找元素 可以通过判断 get_attribute("type") 来进行操作，输入框定位
login_button = driver.find_element_by_partial_link_text("录")
login_button.click()
time.sleep(5)
driver.quit()
