import sys

from exception.my_exception import handle_exception

if __name__ == '__main__':
    #  替换自带的异常处理器
    sys.excepthook = handle_exception
