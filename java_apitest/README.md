
java版的api/uitest介绍<br>
基于Java+Maven+TestNG+Selenium+Allure+SVN+Jenkins<br>
=================<br>

1、目录结构
-----------
cases：具体的测试用例编写<br>
constants:静态变量<br>
pojo:接口测试使用easypoi对excel列和实体类的成员变量映射关系<br>
UI po模式分层设计，进行页面对象分层维护元素定位和操作<br>
业务流程层封装业务流，基于操作函数封装<br>
用例层实现用例，基于业务流程组装<br>
优点：用例与页面解耦，提高用例可读性和可维护性，用例编写更灵活<br>
utils:对Excel http请求 jdbc等封装<br>
resources:测试数据xlsx路径<br>

2、使用说明
-----------
1、数据驱动：dataProvider数据提供者注入到测试方法中<br>
优点：用例与用例数据解耦，让操作相同但是数据不同的测试通过同一套脚本实现页面共性提取<br>
2、数据管理<br>
    Constants类保存常量数据<br>
3、用例失败截图<br>
	TestNG监听用例异常，截图嵌入Allure报表<br>
4、用例失败重试<br>
	TestNG监听用例失败，自动运行重试机制，提高用例执行稳定性<br>
5、多线程并发执行<br>
	提升测试效率，节约自动化测试时间<br>
	兼容性测试<br>
	线程安全问题-ThreadLocal<br>
6、用例管理<br>
  TestNG->testng.xml<br>
7、用例执行<br>
  Jenkins构建+定时任务+Email<br>

	
1、 通过指定testng文件及内容中的类和方法确定运行cases(jenkins构建之后执行此文件)

3、运行效果截图
-----------

![mail形式的结果截图](https://github.com/alvinsss/apitest/blob/master/report/mail.png)<br>
![httprunner形式的结果截图](https://github.com/alvinsss/apitest/blob/master/report/htmlrunner.png)<br>

4、作者信息
-----------

author:alvin<br>
qq    :6449694<br>
email :wanghailin@aliyun.com<br>
