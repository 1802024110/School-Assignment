import requests
import traceback

from utils.log import LoggerHandler


def handle_exception(type, value, _traceback):
    tb = traceback.extract_tb(_traceback)
    filename, line, _, _ = tb[-1]

    if type == requests.exceptions.SSLError:
        pass
        # LoggerHandler().error("错误类型:" + str(exc_type) + ",网络错误，具体错误消息:" + str(exc_value))
    else:
        pass
        # LoggerHandler().error("ErrorType:" + str(type) + ",ErrorMeg:" + str(exc_value))
LoggerHandler().error("dsfsd",filename="dfsd",lineno=12)
