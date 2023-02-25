# -*- coding: utf-8 -*-
# @Time    : 2023/2/25 13:31
# @Author  : alvin
# @File    : handle_email.py
# @Software: PyCharm

# -*- coding: utf-8 -*-
# @Time    : 2020/12/15 20:37
# @Author  : alvin
# @File    : operationemail.py
# @Software: PyCharm

# coding: utf-8
import os
import smtplib
from email.mime.text import MIMEText

from handle_inifile import get_sendmail_info
from handle_path import config_path
from utils.handle_inifile import get_inifile

# -*- coding: utf-8 -*-
# @Time    : 2020/12/15 20:37
# @Author  : alvin
# @File    : operationemail.py
# @Software: PyCharm

# coding: utf-8
import smtplib
from email.mime.text import MIMEText


class MyMail:

    def __init__(self):
        confdata = get_sendmail_info()
        self.login_user = confdata['login_user']
        self.login_pwd = confdata['login_pwd']
        self.from_addr = confdata['from_addr']
        self.to_addrs = confdata['to_addrs']
        self.host = confdata['host']
        self.port = confdata['port']

    def send_mail(self, msginfo, subject):

        # 设置email信息
        # 邮件内容设置
        message = MIMEText( msginfo, 'plain', 'utf-8' )
        # 邮件主题
        # message['Subject'] = 'btc exchange eth mail info'
        message['Subject'] = subject
        # 发送方信息
        message['From'] = self.from_addr
        # 接受方信息
        message['To'] = self.to_addrs
        # print(message)
        # 登录并发送邮件
        try:
            smtpObj = smtplib.SMTP()
            # 连接到服务器
            smtpObj.connect( self.host, 25 )
            # 登录到服务器
            smtpObj.login( self.login_user, self.login_pwd )
            # 发送
            smtpObj.sendmail(
                self.from_addr, self.to_addrs.split( ',' ),
                message.as_string() )
            # 退出
            smtpObj.quit()
            print( 'send mail is success' )
        except smtplib.SMTPException as e:
            print( 'send mail is error', e )  # 打印错误


if __name__ == '__main__':
    mymail = MyMail()
    mymail.send_mail( "qatest all1", 'btc exchange eth mail info test' )
