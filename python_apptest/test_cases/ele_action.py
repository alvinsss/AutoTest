# -*- coding: utf-8 -*-
# @Time    : 2022/8/31 11:38
# @Author  : alvin
# @File    : ele_action.py
# @Software: PyCharm

from appium import webdriver
from time import sleep
from appium.webdriver.common.mobileby import MobileBy
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

desired_caps = {
    "automationName":"UiAutomator2",
    "platformName":"Android",
    "platformVersion":"7.1",
    "deviceName":"HUAWEI",
    "appPackage":"com.lemon.lemonban",
    "appActivity":"com.lemon.lemonban.activity.WelcomeActivity"
}
# 2、跟appium建立连接，将1中的启动参数传递给appium
driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub',desired_caps)
driver.background_app(5)

locator=(By.XPATH,"//*[@text='全程班']")
WebDriverWait(driver,20).until(EC.visibility_of_element_located(locator))
ele = driver.find_element(*(locator))
print("linearLayout")
text=ele.text
print(text)
size=ele.size
print(size)
loc = ele.location
print(loc)

sleep(6)