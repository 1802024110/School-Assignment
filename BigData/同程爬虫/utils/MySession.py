import requests

def my_request(func):
    def wrapper(*args, **kwargs):
        session = requests.Session()
        session.headers.update({
            "Mozilla/5.0": "(Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.0.0"
        })
        kwargs.setdefault('timeout', 5)
        return func(session, *args, **kwargs)
    return wrapper

# @my_request
# def get_url(session, url, **kwargs):
#     return session.get(url, **kwargs)
