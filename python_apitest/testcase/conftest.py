# -*- coding: utf-8 -*-
# @Time    : 2023/2/10 12:49
# @Author  : alvin
# @File    : conftest.py
# @Software: PyCharm
import pytest

from python_apitest.libs.login import Login
from python_apitest.configs.config import NAME_PSW
from python_apitest.libs.user import User
from python_apitest.libs.storage import Storage
from python_apitest.utils.handle_log import log
from python_apitest.utils.handle_file_encode import read_and_convert
from python_apitest.utils.handle_path import testData_path
from python_apitest.utils.handle_mysql import mysqlcon
from python_apitest.utils.handle_apiserver import get_apiserver


"""
作用：环境初始化和返回被测试接口实例，方便testcase层直接使用
，使用conftest.py进行结合pytest.fixture进行测试环境及变量初始化操作
"""
#没有返回值的fixture
@pytest.fixture(scope='session',autouse=True)
def start_running(start_init):
    #---自动化测试前的--环境操作
    log.info('------------------------------')
    log.info('---Alist项目自动化测试开始执行')
    yield #-yeild后面没有值就是没有返回值
    log.info('---Alist项目自动化测试执行结束')
    log.info('---Alist项目自动化测试执行完成，数据清除完成')

@pytest.fixture(scope='class')
def notreturn():#没有yeild或者return  也是没有返回值
    print('没有返回值的fixture')

@pytest.fixture(scope='session')
def start_init(start_init_env,start_init_db,start_init_testdata_convert_encode):
    log.info('---Alist项目API自动化初始化结束')

@pytest.fixture(scope='session')
def start_init_testdata_convert_encode():
    log.info('---测试数据文件编码转换开始')
    log.info("--批量转化,测试数据文件:{}进行中...".format(testData_path))
    read_and_convert(testData_path)
    log.info('---测试数据文件编码转换结束')

@pytest.fixture(scope='session')
def start_init_db():
    log.info('---测试数据库垃圾清理开始')
    mysqlcon.db_init()
    log.info('---测试数据库垃圾清理结束')

@pytest.fixture(scope='session')
def start_init_env():
    log.info('---Alist项目API自动化初始化开始')
    log.info('---测试环境部署状态检查开始')
    get_apiserver()
    log.info('---测试环境部署状态检查结束')

#--------登录操作-----------
#其他的业务层测试代码需要调用这个登录
#返回值的fixture---直接使用这个函数名--就是代表返回值 -login_init == token
@pytest.fixture(scope='session')
def login_init():
    log.info('---用户操作登录---')
    token = Login().login(NAME_PSW,getToken=True)
    # log("token",token)
    yield token#返回token---有返回值
    log.info('---登录完成---')#或者可以执行退出操作
    #return token#后面就不能写代码

#--------用户管理，为了返回用户实例-----------
#如果一个fixture需要使用另外一个fixture的返回值，直接使用fixture即可
@pytest.fixture(scope='class')
def user_init(login_init):
    log.info('---用户管理实例创建开始---')
    userObject = User(login_init)
    yield userObject#返回值返回用户实例
    log.info('---用户管理实例创建完成---')

@pytest.fixture(scope='class')
def storage_init(login_init):
    log.info('---Storage管理实例创建开始---')
    storageObject = Storage(login_init)
    yield storageObject#返回值返回Storage实例
    log.info('---Storage管理实例创建完成---')