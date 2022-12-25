# -*- coding: utf-8 -*-
# @Time    : 2022/8/19 12:18
# @Author  : alvin
# @File    : demo_startapp.py
# @Software: PyCharm
# 1、启动参数准备好。

from appium import webdriver
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
driver.f
#3、运行代码
#前提  1、appium启动
