from enum import Enum, unique


# 成员值唯一
@unique
class Urls(Enum):
    """爬虫用到的所有URl"""

    BASE_URL = "https://so.ly.com"
    """基础链接 """

    GetSearchResult_URL = BASE_URL + "/commonAjax/AjaxHandler/GetSearchResult"
    """搜索链接 """
