from enum import Enum, unique


# 成员值唯一
@unique
class Urls(Enum):
    BASE_URL = "https://so.ly.com"
    """
    搜索链接
    """
    GetSearchResult_URL = BASE_URL + "/commonAjax/AjaxHandler/GetSearchResult"