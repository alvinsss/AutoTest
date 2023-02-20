# -*- coding: utf-8 -*-
# @Time    : 2023/2/20 20:29
# @Author  : alvin
# @File    : handle_image.py
# @Software: PyCharm

import pytesseract
from PIL import Image

class ImageAction():
    '''
    传入地址 返回验证码
    '''
    def __init__(self,path):
        self.__path = path
        self.image = None

    #     #获取图片
    # def get_image (self):
    #     img = Image.open(self.__path)
    #     return img

    def __image_grayscale_deal(self):
        #获取图片
        self.image = Image.open(self.__path)
        if  self.image != None:
            #灰度，去颜色
            self.image = self.image.convert('L')#全局不需要return
        # img.show()#展示灰度之后图片，去颜色

    #二值化处理  白的更白，黑的更黑
    def __image_threashoding_method(self):
        threshold = 160
        table = []
        for i in range(256):
            #去掉干扰线
            if i < threshold:
                table.append(0)
            else:
                table.append(1)
        self.image.point(table,'1')
        # image.show()
        return self.image

    def get_captcha_crack(self):
        self.__image_grayscale_deal()
        self.__image_threashoding_method()
        res= pytesseract.image_to_string(self.image)
        return res.split("\n")[0]

if __name__ == '__main__':
    image = ImageAction("./1.png")
    res = image.get_captcha_crack()
    print(res)
