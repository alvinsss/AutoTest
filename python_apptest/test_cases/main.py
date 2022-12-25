# -*- coding: utf-8 -*-
# @Time    : 2022/8/17 9:03
# @Author  : alvin
# @File    : main.py
# @Software: PyCharm
import pytest
"""
筛选用例的方式：
1、注册标签名(smoke、nmb)
   在根目录下面，创建一个文件：pytest.ini
   [pytest]
   markers=
2、给用例打标签: @pytest.mark.已注册的标签名
3、运行的时候，根据标签名过滤用例
   -m 标签名
"""

if __name__ == '__main__':
    # pytest.main(["-s","-v","-m smoke"])
    pytest.main(["-s","-v"])