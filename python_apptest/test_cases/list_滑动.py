# -*- coding: utf-8 -*-
# @Time    : 2022/9/1 15:24
# @Author  : alvin
# @File    : list_滑动.py
# @Software: PyCharm
"""

1、如果没有找到  元素，那么就需要滑动
2、滑动几次，能找到元素呢？
循环滑动：滑一次，确认一次能否找到元素。
如果找不着，再重复。
while

3、如果说滑到了底部，还没有找到元素,也不再滑动了。
怎么知道滑到了底部？--- 页面的内容是否发生了变化 。
得到页面的内容：driver.page_source
"""

# 判断你要的元素是否出现。-- 接口测试
# 如果没找着了，继续滑动。
# 滑动之后，判断你要的元素是否出现。
# 如果没找着了，继续滑动。
# 直到元素找到了，break
# 直到滑动到了页面底部，break

from appium.webdriver.common.touch_action import TouchAction

from appium import webdriver
from time import sleep

from appium.webdriver.common.mobileby import MobileBy
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


from selenium.webdriver.common.by import By
from time import sleep

# 1、启动参数准备好。
desired_caps = {
    "automationName":"UiAutomator2",
    "platformName":"Android",
    "platformVersion":"7.1",
    "deviceName":"xiaomi",
    "appPackage":"com.lemon.lemonban",
    "appActivity":"com.lemon.lemonban.activity.WelcomeActivity",
    "noReset":True
}

# 2、跟appium建立连接，将1中的启动参数传递给appium
driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub',desired_caps)

# 切换到题 库，
loc = (MobileBy.ID,"com.lemon.lemonban:id/navigation_tiku")
WebDriverWait(driver,20).until(EC.visibility_of_element_located(loc))
driver.find_element(*loc).click()

# 得到设备的大小
device_size = driver.get_window_size()

# 等待题库页面的元素可见.
loc = (MobileBy.ID,"com.lemon.lemonban:id/fragment_category_description")
WebDriverWait(driver,20).until(EC.visibility_of_all_elements_located(loc))
sleep(0.5)

# 查找 - 接口测试  元素是否存在。
loc = (MobileBy.ANDROID_UIAUTOMATOR,'text("接口测试")')

# 定义新页面，和老页面。如果有滑动，那么要更新这2个值。
old_page = None
new_page = driver.page_source

# 当没有滑动到页面底部的时候
while old_page != new_page:
    # 找元素。找到了，break
    try:
        WebDriverWait(driver, 5).until(EC.visibility_of_element_located(loc))
    except:
        # 没找着呢，滑动一下。更新一下old_page和new_page
        # 从下向上滑动
        driver.swipe(device_size["width"] * 0.5, device_size["height"] * 0.9,
                     device_size["width"] * 0.5, device_size["height"] * 0.1, 200)
        sleep(5)
        old_page = new_page
        new_page = driver.page_source
    else:
        driver.find_element(*loc).click()
        break



# 实例化TouchAction类
ta = TouchAction(driver)

# 得到设备的大小
device_size = driver.get_window_size()