
python版的接口自动化框架介绍<br>
=================<br>

1、目录结构
-----------
1、docs:文档<br>
2、logs:日志记录<br>
3、data:测试数据<br>
4、report:测试报告<br>
5、extends:扩展预留<br>
6、libs:业务层按照接口创建的
7、utils:工具类读取yaml和xls文件等<br>
8、configs:yaml格式数据和log格式配置<br>
9、test_case：通过业务层调用基类执行测试断言<br>
10、common:request包的封装，更好的支持restful api接口规范<br>
11、pytest.ini:pytest执行入口，进行测试文件或目录或方法设置，支持allure插件报告等
-----------

2、使用说明
-----------

1、 在data下配置接口请求信息支持excel和yaml格式数据<br>
2、 在libs业务层创建接口同名类,继承基类，类似<br>
    class User(BaseRequest):<br>
               pass<br>
3、 在testcase指定测试测试内容<br>
4、 手动或jenkins方式在工程目录下执行pytest生成测试报告
-----------

运行之后结果报告<br>
![img.png](docs/img.png)

allure美化展示报告<br>
![img.png](docs/allure_perfor.png)

3、作者信息
-----------
author:alvin<br>
qq    :6449694<br>
wx    :kings_qa<br>
