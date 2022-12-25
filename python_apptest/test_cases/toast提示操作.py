# -*- coding: utf-8 -*-
# @Time    : 2022/9/1 16:46
# @Author  : alvin
# @File    : toast提示操作.py
# @Software: PyCharm
from appium import webdriver
from time import sleep
from appium.webdriver.common.mobileby import MobileBy
from appium.webdriver.common.touch_action import TouchAction
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

desired_caps = {
    "automationName":"UiAutomator2",
    "platformName":"Android",
    "platformVersion":"7.1",
    "deviceName":"HUAWEI",
    "appPackage":"com.lemon.lemonban",
    "appActivity":"com.lemon.lemonban.activity.WelcomeActivity",
    "noReset":False
    #不登录状态
}
# 2、跟appium建立连接，将1中的启动参数传递给appium
driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub',desired_caps)

# 等待 我的柠檬出现，并点击进入
loc = (MobileBy.ID,"com.lemon.lemonban:id/navigation_my")
WebDriverWait(driver,20).until(EC.visibility_of_element_located(loc))
driver.find_element(*loc).click()

# 等待  点击头像登陆  元素可见，并点击进入
loc = (MobileBy.ID,'com.lemon.lemonban:id/fragment_my_lemon_avatar_layout')
WebDriverWait(driver,20).until(EC.visibility_of_element_located(loc))
driver.find_element(*loc).click()

# 等待  登陆按钮  元素可见，并点击进入
loc = (MobileBy.ID,'com.lemon.lemonban:id/btn_login')
WebDriverWait(driver,20).until(EC.visibility_of_element_located(loc))
driver.find_element(*loc).click()
print("toast")
# toast的xpath表达式
expr = '//*[contains(@text,"手机号码或")]'
loc = (MobileBy.XPATH,expr)
# 等待toast存在，而不是可见
try:
    # 0.01 看实际消失速度
    WebDriverWait(driver,8,0.01).until(EC.presence_of_element_located(loc))
except:
    print("哎呀，没有找到toast")
else:
    text = driver.find_element(*loc).text
    print(text)


