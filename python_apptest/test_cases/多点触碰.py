# -*- coding: utf-8 -*-
# @Time    : 2022/9/1 16:21
# @Author  : alvin
# @File    : 多点触碰.py
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
# 地图放大
# 2个touchAtion
# 1个：从中心向左下角移动。按住 中心点，移动到左下角的点，然后释放
# 1个：从中心向右上角移动。按住 中心点，移动到右上角的点，然后释放

# 1个：从中心向左下角移动。按住 中心点，移动到左下角的点，然后释放
ta1 = TouchAction(driver)
ta1.press(x=size["width"]*0.5,y=size["height"]*0.5).wait(200). \
    move_to(x=size["width"]*0.1,y=size["height"]*0.9).wait(200).release()

# 1个：从中心向右上角移动。按住 中心点，移动到右上角的点，然后释放
ta2 = TouchAction(driver)
ta2.press(x=size["width"]*0.5,y=size["height"]*0.5).wait(200). \
    move_to(x=size["width"]*0.9,y=size["height"]*0.1).wait(200).release()

# 实例化Mutliaction类
ma = MultiAction(driver)

# 将TouchAction对象添加到ma当中
ma.add(ta1,ta2)
print("action")
# 执行动作
ma.perform()
print("action2")
