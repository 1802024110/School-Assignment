from utils.MySession import my_request
from utils.Urls import Urls


@my_request
def getSearchResult(session):
    a = session.get(Urls.GetSearchResult_URL.value)
    return a
a = getSearchResult()
print(a)