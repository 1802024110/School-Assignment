import inspect

import requests
import traceback

from utils.log import MyLogger

my_logger = MyLogger()


def handle_exception(type, value, _traceback):
    tb = traceback.extract_tb(_traceback)
    filename, line, _, _ = tb[-1]

    if type == requests.exceptions.SSLError:
        pass
        my_logger.error(f"Error occurred in {filename} at line {line}: SSLError请检查网络")
    else:
        pass
        my_logger.error(f"Error occurred in {filename} at line {line}: {value}")
