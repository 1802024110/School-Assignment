import inspect

import requests
import traceback

from utils.log import MyLogger

my_logger = MyLogger()


def handle_exception(type, value, _traceback):
    tb_formatted = traceback.format_tb(_traceback)

    if type == requests.exceptions.SSLError:
        my_logger.error(f"发生错误: {value}\n报错栈追踪信息:\n{''.join(tb_formatted)}\n请检查网络.")
    else:
        my_logger.error(f"发生错误: {value}\n报错追踪信息:\n{''.join(tb_formatted)}")