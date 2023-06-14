import requests
from functools import wraps

from bs4 import BeautifulSoup


class MySession(requests.Session):
    def get(self, url, **kwargs):
        try:
            response = super().get(url, **kwargs)
            response.soup = BeautifulSoup(response.text, 'lxml')
            return response
        except Exception as e:
            return super().get(url, **kwargs)


session = MySession()


# 定义装饰器函数，接受一个被装饰的函数作为参数
def my_request(func):
    """
    全局requests装饰器，统一session

    Args:
        func: 被装饰的函数，接受一个session参数

    Returns:
        被装饰的函数的返回值
    """

    # 使用functools.wraps装饰器，保留原函数的元信息
    @wraps(func)
    def wrapper(*args, **kwargs):
        # 在每次调用被装饰的函数之前，修改session对象的headers属性
        session.headers.update({
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.0.0"
        })
        # 调用被装饰的函数，并传入session对象和其他参数
        return func(session, *args, **kwargs)

    # 返回装饰后的函数
    return wrapper
