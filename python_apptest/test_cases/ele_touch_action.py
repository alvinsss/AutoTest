# -*- coding: utf-8 -*-
# @Time    : 2022/8/31 11:38
# @Author  : alvin
# @File    : ele_action.py
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
    "appActivity":"com.lemon.lemonban.activity.WelcomeActivity"
}
# 2、跟appium建立连接，将1中的启动参数传递给appium
driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub',desired_caps)
# driver.background_app(5)

locator=(By.XPATH,"//*[@text='视频教程']")
WebDriverWait(driver,20).until(EC.visibility_of_element_located(locator))
ele = driver.find_element(*(locator))
print("就业信息")
ele.click()
sleep(4)
# #实例化TouchAction 滑动
# ta=TouchAction(driver)
# #获取设备大小
device_size = driver.get_window_size()
# #第1步 按住press 坐标x  device_size["width"]*0.5
# # y device_size["height"]*0.9
# ta.press(x=device_size["width"]*0.5 ,y=device_size["height"]*0.9 ).wait(200)\
#     .move_to(x=device_size["width"]*0.5 ,y=device_size["height"]*0.1 ).wait(200).release()
# #第2步 调用perform去执行
# ta.perform()

driver.swipe(device_size["width"]*0.5,device_size["height"]*0.9,
             device_size["width"]*0.5,device_size["height"]*0.1,200)
