from decorators.param_check import search_code_check


def add_https(url):
    """传入url，返回带http的url"""
    if url.startswith('//'):
        url = 'https:' + url
    return url


@search_code_check
def get_attractions_list(json: dict):
    """传入搜索的json，返回简化的数据"""
    total = json['ReturnValue']['Total']
    # 搜索结果的总数
    attractions_list = json['ReturnValue']['Records']
    # 搜索结果的列表
    new_attractions_list = []
    # 新的列表,key为中文
    for attraction in attractions_list:
        new_attraction = {
            '标题': attraction['Title'],
            '副标题': attraction['SubTitle'],
            '景点ID': attraction['ProductId'],
            '描述': attraction['Describe'],
            '图片链接': add_https(attraction['Picture']),
            '产品链接': add_https(attraction['ProductUrl']),
            '等级': attraction['GradeId'],
            '开放时间': attraction['OpenTime'],
            '景区地址': attraction['Address'],
            '景区概述': attraction['Summary'],
            '距离': attraction['Distance'],
            '原价': attraction['OriginalPrice'],
            '优惠券金额': attraction['CouponAmt'],
            '是否支持当天下单当天使用': attraction['OrdAD'],
            '最晚可选取的入园时间': attraction['OrdTL'],
            '内部分类名称': attraction['InnerTypeName'],
            '是否为同城线路': attraction['TCLine'],
            '标签列表': attraction['Labels'],
            '季节': attraction['Season'],
            '价格': attraction['Price'],
            '城市ID': attraction['CityId'],
            '城市名称': attraction['CityName'],
            '内部分类': attraction['InnerType'],
            '业务类型': attraction['BusinessType'],
            '销售数量': attraction['SaleCount'],
            '评论数量': attraction['CommentCount'],
            '评论好评率': attraction['CommentRate'],
            '天数': attraction['Day'],
            '行程安排': attraction['Schedule'],
            '标签': attraction['Tag'],
            '目的地': attraction['Dests'],
            '是否有优惠券': attraction['Coupon'],
            '跳转标签': attraction['JumpTag'],
            '积分金额': attraction['IntegralMoney'],
            '积分内容': attraction['IntegralContent']
        }
        new_attractions_list.append(new_attraction)
    # 将total添加到列表中
    new_attractions_list.append({'total': total})
    return new_attractions_list

