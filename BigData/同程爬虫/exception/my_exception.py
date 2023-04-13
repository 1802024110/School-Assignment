from utils.log import LoggerHandler
import requests


def handle_exception(exc_type, exc_value, exc_traceback):
    # 处理异常的代码
    if exc_type == requests.exceptions.SSLError:
        LoggerHandler().error("错误类型:" + str(exc_type) + ",网络错误，具体错误消息:" + str(exc_value))
    else:
        LoggerHandler().error("ErrorType:" + str(exc_type) + ",ErrorMeg:" + str(exc_value))
