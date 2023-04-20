# 景点的爬虫函数
# //www.ly.com/scenery/BookSceneryTicket_1239.html
import random

from bs4 import BeautifulSoup

from decorators.my_session import my_request
from utils.Urls import Urls


@my_request
def get_scenery_book_knows_new(session, id):
    """传入景点id，返回景点预订须知"""
    params = {
        "action": "GetSceneryBookKnowsNew",
        # 获得景点须知
        "id": id,
        # 景点id
        "iid": float(random.randint(1000000000000000, 9999999999999999)) / 10000000000000000,
        # 随机数16位小数，不知道有什么用
    }
    request = session.get(Urls.SceneryPriceFrame_URL.value, params=params)
    return request.json()


@my_request
def get_scenery_description(session, id):
    """传入景点id，返回景点简介"""
    index_url = Urls.BASE_URL.value + f'/scenery/BookSceneryTicket_{id}.html'
    request = session.get(index_url)
    soup = request.soup
    descriptions = soup.select('#scenery_intro_con > div.b_i_m.clearfix > div > div')
    description_list = []
    for description in descriptions:
        text = description.text
        # 去掉文本中的换行和html标签
        text = text.replace('\n', '').replace('\r', '').replace('\t', '').replace(' ', '')
        image = description.select('img')
        if image:
            image = image[0].attrs['orisrc']
            # 有些图片的src是以//开头的，需要加上https:
            if image.startswith('//'):
                image = 'https:' + image
        description_list.append({
            'text': text,
            'image': image
        })
    return description_list


@my_request
def get_scenery_dian_ping(session, id, page=1, page_size=10, lab_id=1):
    """传入景点id，返回景点点评
    :param id: 景点id
    :param page: 页码
    :param page_size: 每页数量
    :param lab_id: 1:全部 2:好评 3:中评 4:差评 5:有图 6:最新
    :return: 景点点评json
    """
    params = {
        "action": "GetDianPingList",
        "sid": id,
        "page": page,
        "pageSize": page_size,
        "labId": lab_id,
        # 1:全部 2:好评 3:中评 4:差评 5:有图 6:最新
        "sort": 0,
        "iid": float(random.randint(1000000000000000, 9999999999999999)) / 10000000000000000,
    }
    request = session.get(Urls.SceneryDianPing_URL.value, params=params)
    return request.json()


@my_request
def get_scenery_traffic(session, id):
    """传入景点id，返回景点交通信息"""
    index_url = Urls.BASE_URL.value + f'/scenery/BookSceneryTicket_{id}.html'
    request = session.get(index_url)
    soup = request.soup
    traffic_box = soup.select('#traffic_route_con > div.b_i_m.clearfix > div.tra_line > ul')[0]
    traffic = {
        '公共交通': traffic_box.select('li')[0].text.replace(' ', '').replace('\n', ''),
        '周边停车场': traffic_box.select('li')[1].text.replace(' ', '').replace('\n', '').replace('\xa0', ''),
    }
    print(traffic)


print(get_scenery_traffic(1239))
