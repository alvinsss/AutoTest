# -*- coding: utf-8 -*-
# @Time    : 2023/2/10 12:23
# @Author  : alvin
# @File    : test_user.py
# @Software: PyCharm
import pytest,allure
from python_apitest.utils.handle_excel import get_excel_data
from python_apitest.utils.handle_path import allure_json_path
from python_apitest.common.baseRequest import RequestAssert
"""
测试文件执行条件：

    1- 该业务层代码封装ok
    2- 需要自动化测试用例----数据驱动-使用指定文件类型做
        功能用例：人去执行
            1- excel
            2- word
            3- xmind
            4- yaml
            5- 数据库
        自动化用例选型：靠代码或者工具
            1- excel
            2- yaml
"""

@pytest.mark.user
@allure.epic('alist项目')
@allure.feature('用户模块')
class TestUser(RequestAssert):

    # 创建用户，获取conftest初始化的接口实例，直接使用 libs 封装的接口调用父类一系列（增、删、改）方法即可
    @pytest.mark.parametrize('title,inBody,expData',get_excel_data('用户管理','usercreate','标题','请求参数','响应预期结果') )
    @allure.title("{title}")
    @pytest.mark.create
    @pytest.mark.skipif()

    @allure.story("新建用户")
    def test_user_create(self,title,inBody,expData,user_init): #user_init初始化 返回实例
        print("inBody",inBody)
        print("expData",expData)
        res=user_init.create(inBody)
        self.define_api_assert(res['code'],'=',expData['code'])

    #删除用户
    @pytest.mark.parametrize('title,inBody,expData',get_excel_data('用户管理','userdelete','标题','请求参数','响应预期结果') )
    @allure.title("{title}")
    @pytest.mark.delete
    @pytest.mark.skip(reason="没开发完，不做自动化")
    @allure.story("删除用户")
    def test_user_delete(self,title,inBody,expData,user_init):
        print("inBody",inBody)
        print("expData",expData)
        res=user_init.delete(inBody)
        self.define_api_assert(res['code'],'=',expData['code'])

    #修改用户
    @pytest.mark.parametrize('title,inBody,expData',get_excel_data('用户管理','userupdate','标题','请求参数','响应预期结果') )
    @allure.title("{title}")
    @pytest.mark.update
    @allure.story("用户更新")
    def test_user_update(self,title,inBody,expData,user_init):
        print("inBody",inBody)
        print("expData",expData)
        res=user_init.update(inBody)
        self.define_api_assert(res['code'],'=',expData['code'])

    #查询用户-llist
    @pytest.mark.parametrize('title,inBody,expData',get_excel_data('用户管理','userlist','标题','请求参数','响应预期结果') )
    @allure.title("{title}")
    @pytest.mark.listall
    @allure.story("查询用户列表")
    def test_user_list(self,title,inBody,expData,user_init):
        print("inBody",inBody)
        print("expData",expData)
        res=user_init.query(inBody)
        self.define_api_assert(res['code'],'=',expData['code'])

    #查询用户-one
    @pytest.mark.parametrize('title,inBody,expData',get_excel_data('用户管理','userget_one','标题','请求参数','响应预期结果') )
    @allure.title("{title}")
    @pytest.mark.getone
    def test_user_getone(self,title,inBody,expData,user_init):
        print("inBody",inBody)
        print("expData",expData)
        res=user_init.get_one(inBody)
        self.define_api_assert(res['code'],'=',expData['code'])

        #修改用户
    @pytest.mark.parametrize('title,inBody,expData',get_excel_data('用户管理','userupdate','标题','请求参数','响应预期结果') )
    @allure.title("{title}")
    @pytest.mark.skip("忽略")
    def test_user_update_flow(self,title,inBody,expData,user_init): #user_init初始化 返回实例
        # {"id": 2, "username": "guest", "password": "guest", "base_path": "/", "role": 1, "permission": 1008, "github_id": 0}
        with allure.step("1：获取用户列表"):
            res = user_init.query({})
            assert  res != None
        with allure.step("2:选择列表任意一个userid"):
            userid = res["data"]["content"][4]['id']
            username = res["data"]["content"][4]['username']
        with allure.step("3:修改用户权限"):
            inBody['id'] = userid
            inBody['username'] = username
            res_updata = user_init.update(inBody)
            # self.define_api_assert(res_updata['code'],'=',expData['code'])

if __name__ == '__main__':
    #输出 打印信息 -s
    #--clean-alluredir   清空json上一次运行的数据文件 allure serve ./outFiles/report/tmp
    pytest.main(['test_user.py','-s','--alluredir',allure_json_path,'--clean-alluredir'])


"""
常见问题：在浏览器里出现allure页面显示 NO data
allure工作原理：
    1- 特性：allure是一个java应用---跨平台--Linux mac  win----
    2- 工作原理：
        1- allure是显示数据---就相当于显示屏
        2- 需要pytest 运行自动化测试用例 生成 json文件----具体的生成路径 alluredir = 存放json文件的路径
        3- allure  serve  存放json文件的路径
        4- 本机执行机器设置火狐为默认浏览器
"""