import io
import logging
import traceback

import colorlog

import inspect

class LoggerHandler(logging.Logger):
    # 设置不同日志级别的颜色
    colorlog.default_log_colors['DEBUG'] = 'cyan'
    colorlog.default_log_colors['INFO'] = 'green'
    colorlog.default_log_colors['WARNING'] = 'yellow'
    colorlog.default_log_colors['ERROR'] = 'red'
    colorlog.default_log_colors['CRITICAL'] = 'bold_red'

    def __init__(self, name='root', logger_level='DEBUG', file="日志.log",
                 logger_format="[%(asctime)s] :%(log_color) s%("
                               "levelname)s %(filename)s [ "
                               "line:%(lineno)d ] %(message)s%("
                               "reset)s"):
        super().__init__(name)

        self.setLevel(logger_level)

        formatter = colorlog.ColoredFormatter(logger_format)

        if file:
            file_handler = logging.FileHandler(file)
            file_handler.setLevel(logger_level)
            file_formatter = logging.Formatter(
                '[%(asctime)s]  %(levelname)s %(filename)s [ line:%(lineno)d ] %(message)s')
            file_handler.setFormatter(file_formatter)
            self.addHandler(file_handler)

        stream_handler = logging.StreamHandler()
        stream_handler.setLevel(logger_level)
        stream_handler.setFormatter(formatter)
        self.addHandler(stream_handler)

    def error(self, msg, *args, filename=None, lineno=None, **kwargs):
        print("Error调用了")
        extra = {'filename': filename, 'lineno': lineno} if filename and lineno else None
        super().error("12313", *args, extra=extra, **kwargs)

# LoggerHandler().error("手动日志")
# LoggerHandler().info("手动日志")
