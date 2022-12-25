# -*- coding: utf-8 -*-
# @Time    : 2022/8/30 15:28
# @Author  : alvin
# @File    : ele_locator.py
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
# ele = driver.find_element(MobileBy.ID,"com.lemon.lemonban:id/navigation_tiku")
# driver.implicitly_wait(15)
locator=(By.XPATH,"//*[@text='全程班']")
WebDriverWait(driver,20).until(EC.visibility_of_element_located(locator))
ele = driver.find_element(*(locator))
print("linearLayout")
ele.click()
sleep(6)

locator_close=(By.CLASS_NAME,"android.widget.ImageButton")
WebDriverWait(driver,20).until(EC.visibility_of_element_located(locator_close))
ele_close = driver.find_element(*(locator_close))
ele_close.click()
sleep(2)

locator_closesure=(By.ID,"com.lemon.lemonban:id/tv_sure")
WebDriverWait(driver,20).until(EC.visibility_of_element_located(locator_closesure))
ele_close = driver.find_element(*(locator_closesure))
ele_close.click()
print("locator_closesure")
sleep(3)

locator_aboutme=(MobileBy.ANDROID_UIAUTOMATOR,'text("视频教程")')
WebDriverWait(driver,20).until(EC.visibility_of_element_located(locator_aboutme))
ele = driver.find_element(*(locator_aboutme))
print("locator_aboutme")
ele.click()
driver.background_app(6)#后台运行6秒
