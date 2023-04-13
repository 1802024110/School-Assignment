from functools import wraps

def search_code_check(func):
    @wraps(func)
    def wrapper(json):
        if not json["Success"] or json["Code"] != 200:
            raise ValueError("json数据获取失败")
        return func(json)

    return wrapper
