# -*- coding: utf-8 -*-
# @Time    : 2023/2/15 14:30
# @Author  : alvin
# @File    : test_storage.py
# @Software: PyCharm
import pytest
import allure
from python_apitest.utils.handle_excel import get_excel_data
from python_apitest.utils.handle_path import allure_json_path
from python_apitest.common.baseRequest import RequestAssert

@pytest.mark.storage
@allure.epic('alist')
@allure.feature('存储模块')
@allure.suite('存储模块all')
class Teststorage(RequestAssert):
    #workboot，用例编号前缀，
    @pytest.mark.parametrize('title,inBody,expData',get_excel_data('存储管理','storage','标题','请求参数','响应预期结果',runCase=['all']) )
    @allure.title("{title}")
    @allure.story("查询storage列表")
    @allure.story("获取存储列表")
    @allure.description("获取admin存储列表")
    @allure.testcase("http://127.0.0.1:5244")
    # @pytest.mark.usefixtures("apistorage")
    def test_storage_list(self,title,inBody,expData,storage_init): # 返回实例
        print("title",title)
        print("inBody",inBody)
        print("expData",expData)
        res=storage_init.query(inBody)
        #多重判断
        with pytest.assume : self.define_api_assert(res['code'],'=',expData['code'])
        with pytest.assume : self.define_api_assert(res['code'],'=',expData['code'])

if __name__ == '__main__':
    pytest.main(['test_storage.py','-s','--alluredir',allure_json_path,'--clean-alluredir'])
