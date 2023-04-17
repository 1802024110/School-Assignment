# 景点的爬虫函数
# //www.ly.com/scenery/BookSceneryTicket_1239.html
from bs4 import BeautifulSoup

from decorators.my_session import my_request
from decorators.param_check import attraction_url_check


def get_html_tree(html: str):
    """传入html，返回BeautifulSoup对象"""
    soup = BeautifulSoup(html, 'lxml')
    return soup


@my_request
def get_booking_instructions(session, url):
    """传入景点url，返回预订须知"""
    # print(url)


print(get_booking_instructions('//www.ly.com/scenery/BookSceneryTicket_1239.html'))
