from decorators.my_session import my_request

from utils.Urls import Urls


@my_request
def get_search_json(session):
    data = {
        "sourceType": "pc",  # 请求来源类型（电脑 PC）
        "cityname": "%E6%88%90%E9%83%BD",  # URL 编码的城市名称（"%E6%88%90%E9%83%BD" 对应的是 "成都"）
        "keyword": "青城山",  # URL 编码的搜索关键词（"%E9%9D%92%E5%9F%8E%E5%B1%B1" 对应的是 "青城山"）
        "startCityId": "324",  # 城市 ID（成都的城市 ID 是 324）
        "FilterClasses": 5,  # 出游类型,
        "from": 0,
        "to": 11,
        # "searchType": "1000",  # 搜索类型（1000 表示景点门票）
        # "callback": "alter(123)",  # 回调函数名
        # "isStat": "0",  # 是否统计
        # "selectType": "5",  # 选择类型（5 表示按照销量排序）
        # "selectSourceType": "1",  # 选择来源类型（1 表示门票）
        # "isTab": "1",  # 是否展示门票和产品标签
        # "projectType": "0",  # 项目类型（0 表示所有项目）
        # "fchannel": "",  # 渠道来源
        # "fpagetype": "",  # 页面类型
        # "_": "1681212743152"  # 时间戳,
    }
    search_req = session.get(Urls.GetSearchResult_URL.value, params=data)
    return search_req.json()

