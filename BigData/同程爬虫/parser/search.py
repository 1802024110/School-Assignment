# "GradeId": "5" - 等级，这里是5级景区
# "OpenTime": "淡季：08:30-17:00； 旺季：08:00-17:30；" - 开放时间，淡季和旺季的开放时间不同
# "Address": "四川省成都市都江堰市青城山镇青城山路" - 景区地址
# "Summary": "洞天福地，人间仙境" - 景区概述
# "Distance": null - 距离，这里为空值
# "OriginalPrice": "500" - 原价，这里是500元
# "CouponAmt": 0 - 优惠券金额，这里是0元
# "OrdAD": "0" - 是否支持当天下单当天使用(0,1)，这里为不支持
# "OrdTL": "1730" - 最晚可选取的入园时间
# "InnerTypeName": "景点" - 内部分类名称，这里是景点
# "TCLine": 0 - 是否为同城线路(0,1)，这里不是同城线路
# "Labels": [] - 标签列表，这里有两个标签，分别是游山玩水和自然风光
# "Describe": null - 描述，这里为空值
# "ProductUrl": "//www.ly.com/scenery/BookSceneryTicket_1239.html" - 产品链接
# "Season": "" - 季节，这里为空值
# "ProductId": "1239" - 产品ID，这里是1239
# "Title": "青城山" - 标题，这里是青城山
# "SubTitle": "洞天福地，人间仙境" - 副标题，这里与概述相同
# "Price": 500 - 价格，这里是500元
# "Picture": "//pic5.40017.cn/03/000/b7/b4/rB5oQFxU8tGAbOpmAAI1tgkceD4583.jpg" - 图片链接
# "CityId": 324 - 城市ID，这里是成都
# "CityName": "成都" - 城市名称，这里是成都
# "InnerType": 5 - 内部分类，这里是5
# "BusinessType": 4 - 业务类型，这里是4
# "SaleCount": 285 - 销售数量，这里是285
# "CommentCount": 465 - 评论数量，这里是465
# "CommentRate": 95.0 - 评论好评率，这里是95%
# "Day": 0 - 天数，这里为0
# "Schedule": "" - 行程安排，这里为空值
# "Tag": "||pos:1||k:青城山||locCId:324||cityId:324||pjId:scenery||resId:1239||ab:A||pgPath:/mdd/list/hot|*|" - 标签，这里包含了很多信息，比如位置、城市ID、产品类型等
# "Dests": [] - 目的地，这里为空列表
# "Coupon": 0 - 是否有优惠券(0,1)，这里没有
# "JumpTag": null - 跳转标签，这里为空值
# "IntegralMoney": 0 - 积分金额，这里为0元
# "IntegralContent": null - 积分内容，这里为空值
from decorators.param_check import search_code_check
from request.search import get_search_json


@search_code_check
def get_attractions_list(json: dict) -> dict:
    """传入搜索的json，返回简化的数据"""
    pass


get_attractions_list(get_search_json())
