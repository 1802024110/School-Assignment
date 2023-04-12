from utils.MySession import my_request

from utils.Urls import Urls


@my_request
def get_search_json(session):
    json = session.get(Urls.GetSearchResult_URL.value)
    return json


print(get_search_json())
