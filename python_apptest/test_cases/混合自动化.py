# -*- coding: utf-8 -*-
# @Time    : 2022/9/5 15:30
# @Author  : alvin
# @File    : 混合自动化.py
# @Software: PyCharm
from appium.webdriver.common.touch_action import TouchAction

from appium import webdriver
from time import sleep

from appium.webdriver.common.mobileby import MobileBy
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


from selenium.webdriver.common.by import By
from time import sleep
#=============  app自动化测试   ==============

# 1、启动参数准备好。
desired_caps = {
    "automationName":"UiAutomator2",
    "platformName":"Android",
    "platformVersion":"7.1",
    "deviceName":"xiaomi",
    "appPackage":"com.lemon.lemonban",
    "appActivity":"com.lemon.lemonban.activity.WelcomeActivity",
    "noReset":True,
    "chromedriverExecutableDir":"E:\\eclipse-workspace\AutoTest\\java_webtest\\src\\test\\resources"
}

# 2、跟appium建立连接，将1中的启动参数传递给appium
driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub',desired_caps)

# 获取一下当前所有的contexts
print("原生控件页面的contexts: ",driver.contexts)

# 找到柠檬社区，并点击进入，
loc = (MobileBy.ANDROID_UIAUTOMATOR,'text("柠檬社区")')
WebDriverWait(driver,20).until(EC.visibility_of_element_located(loc))
driver.find_element(*loc).click()  #进入到混合页面当中。

sleep(5)
# 获取一下当前所有的contexts
print("进入了混合页面以后的contexts: ",driver.contexts)
# 切换进入到你要的webview当中。
driver.switch_to.context('WEBVIEW_com.lemon.lemonban')

# ==============  进入web自动化 html页面当中  ========================

# 等待元素
loc = (MobileBy.XPATH,'//a[@text="app 兼容性测试用工具？"]')
WebDriverWait(driver,20).until(EC.visibility_of_element_located(loc))
driver.find_element(*loc).click()

sleep(5)

# 回到原生控件当中
driver.switch_to.context('NATIVE_APP')