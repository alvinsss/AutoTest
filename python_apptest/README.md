
python版的apptest介绍<br>
=================<br>

1、目录结构
-----------

base:测试request包的封装，为了支持加密<br>
bin:执行测试入口，支持发送mail结果和HTMLTestRunner两种方式<br>
config:mysql和发邮件信息配置<br>
data:测试数据<br>
log:测试log<br>
page:PO,web 和 app的ui测试使用<br>
report:测试报告<br>
test_cases：具体的测试用例编写<br>
utils:工具类及excel,mysql.HTMLTestRunner3等<br>

2、使用说明
-----------

1、 在test_case包下写测试用例
2、 在bin目录的run.py执行测试(jenkins构建之后执行此文件)

3、运行效果截图
-----------

![mail形式的结果截图](https://github.com/alvinsss/apitest/blob/master/report/mail.png)<br>
![httprunner形式的结果截图](https://github.com/alvinsss/apitest/blob/master/report/htmlrunner.png)<br>

4、作者信息
-----------

author:alvin<br>
qq    :6449694<br>
email :wanghailin@aliyun.com<br>
