# -*- coding: utf-8 -*-
# @Time    : 2022/9/1 17:06
# @Author  : alvin
# @File    : 跨应用.py
# @Software: PyCharm
from appium import webdriver
from time import sleep
from appium.webdriver.common.mobileby import MobileBy
from appium.webdriver.common.multi_action import MultiAction
from appium.webdriver.common.touch_action import TouchAction
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

desired_caps = {
    "automationName":"UiAutomator2",
    "platformName":"Android",
    "platformVersion":"7.1",
    "appPackage":"com.baidu.BaiduMap",
    "appActivity":"com.baidu.baidumaps.WelcomeScreen",
    "noReset":True
}
# 2、跟appium建立连接，将1中的启动参数传递给appium
driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub',desired_caps)
# driver.background_app(5)
sleep(10)
# 得到当前设备大小
size = driver.get_window_size()
print(size)

driver.start_activity("com.lemon.lemonban","com.lemon.lemonban.activity.WelcomeActivity")
# 等待 我的柠檬出现，并点击进入
loc = (MobileBy.ID,"com.lemon.lemonban:id/navigation_my")
WebDriverWait(driver,20).until(EC.visibility_of_element_located(loc))
driver.find_element(*loc).click()
print("我的柠檬")
