# -*- coding: utf-8 -*-
# @Time    : 2023/2/16 12:51
# @Author  : alvin
# @File    : handle_file_encode.py
# @Software: PyCharm

import os
from chardet.universaldetector import UniversalDetector
from python_apitest.utils.handle_path import testData_path
from python_apitest.utils.handle_log import log

def read_file(file):
    """
    #二进制读文件
    :param file:
    :return:
    """
    with open (file,'rb') as f:
        return f.read()

def read_file_utf8(file):
    with open (file,'r',encoding='utf-8') as f:
        return f.read()


def get_datafile(path):
    """
    #返回查找目录符合文件类型，返回全路径列表
    :param path:
    :return:
    """
    typelist=['csv','ini','yaml']
    filelist=[]
    for (root,dirs,files) in os.walk(path):
        for file in files:
            #file是全名字符串
            if file.split( '.' )[-1] in typelist:
                filelist.append(os.path.join(root,file))
    return filelist


def get_encodeinfo(file):
    """
    #获取文件编码
    :param file:
    :return:
    """
    with open(file,'rb') as f:
        detector = UniversalDetector()
        for line in f.readlines():
            detector.feed(line)
            if detector.done:
                break
        detector.close()
        print("file:{},-----detector.result:{}".format(file,detector.result))
        return detector.result['encoding']

def convert_encodeTo(file,orig,des):
    '''
    二进制读，把文件转换成指定编码，并写入原先的文件中
    :param file: 文件
    :param orig: 原编码
    :param des:  目标编码
    :return:
    '''
    file_content = read_file(file)
    #编码格式
    orig = get_encodeinfo(file)
    # print("orig",orig)
    if orig == "Windows-1254" or orig == "MacRoman":
        file_decode = file_content.decode("utf-8",'ignore')
    elif orig :
        file_decode = file_content.decode(orig,'ignore')
    else:
        print("orig is  None exit")
        log.warning("current file is :{} , file encode info is :{}".format(file,orig))
        file_decode = file_content.decode("utf-8",'ignore')
    # encoding 指定的编码格式解码字符串。默认编码为字符串编码。errors参数可以指定不同的错误ignore处理
    #encode() 方法以 encoding 指定的编码格式编码字符串。
    file_encode = file_decode.encode(des)
    with open(file,'wb') as f:
        f.write(file_encode)

def read_and_convert(path,des_encode='utf-8'):
    """
    读取并转换
    :param path:
    :return:
    """
    filelist= get_datafile(path)
    filenum=0
    for filename in filelist:
        print("filename",filename)
        try:
            encode_info = get_encodeinfo(filename)
            if encode_info != des_encode:
                filenum +=1
                convert_encodeTo(filename,encode_info,des_encode)
                log.info("成功转换第{}文件，文件名称是:{}".format(filenum,filename))
        except Exception as e :
            log.error("current file is :{} , can not convert to utf-8 ".format(filename))
            raise '存在问题，情检查{}'.format(filename)


if __name__ == '__main__':
    read_and_convert(path=testData_path)
    # file= os.path.join(qatestData_path,"hhdb.csv")
    # get_encodeinfo
    # filelist=get_datafile(path=qatestData_path)
    # for file in filelist:
    #     data=read_file_utf8(file)
    #     print(data)