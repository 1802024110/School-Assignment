# 景点的爬虫函数
# //www.ly.com/scenery/BookSceneryTicket_1239.html
from bs4 import BeautifulSoup

from decorators.my_session import my_request


@my_request
def get_booking_instructions(session, url):
    """传入景点url，返回预订须知"""
    rep = session.get(url)


get_booking_instructions('https://www.ly.com/scenery/BookSceneryTicket_1239.html')
