import logging
import colorlog


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

    def __getattr__(self, attr):
        if attr in ['debug', 'info', 'warning', 'error', 'critical']:
            def log(msg, *args, **kwargs):
                return getattr(super(), attr)(msg, *args, **kwargs)

            return log
        raise AttributeError(f"{self.__class__.__name__} object has no attribute '{attr}'")