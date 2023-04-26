from data_parser.search import get_attractions_list
from request.scenery import get_scenery_dian_ping
from request.search import get_search_json


class Search():
    def __init__(self):
        self.search_value = input("请输入要搜索的景点名称：")
        self.scenery_list = get_attractions_list(get_search_json(self.search_value))
        self.total = self.scenery_list[-1]['total']
        self.page = 1
        self.choose_scenery_info = self.choose_search_result()
        self.scenery_id = self.choose_scenery_info['景点ID']

    def choose_search_result(self):
        """
        选择搜索结果,可以翻页
        :return: 景点的具体信息
        """
        for i in range(len(self.scenery_list) - 1):
            print(f"{i + 1}、{self.scenery_list[i]['标题']}")
        print(f"共{self.total}条搜索结果,当前第{self.page}页,共{self.total // 5 + 1}页")
        print("输入景点序号查看详情,输入j上一页,输入k下一页,输入q退出")
        choose = input("请输入：")
        if choose == 'q':
            exit()
        elif choose == 'j':
            if self.page == 1:
                print("已经是第一页了")
                self.choose_search_result()
            else:
                self.change_page(self.page - 1)
                self.choose_search_result()
        elif choose == 'k':
            if self.page == self.total // 5 + 1:
                print("已经是最后一页了")
                self.choose_search_result()
            else:
                self.change_page(self.page + 1)
                self.choose_search_result()
        else:
            try:
                print("你选择了：", self.scenery_list[int(choose) - 1]['标题'])
                return self.scenery_list[int(choose) - 1]
            except:
                print("输入错误")
                self.choose_search_result()

    # 换页
    def change_page(self, page):
        self.page = int(input("请输入要查看的页码："))
        self.scenery_list = get_attractions_list(
            get_search_json(self.search_value, page_from=(self.page - 1) * 5, page_to=self.page * 5))

    def get_search_total(self):
        return self.total

    # 展示评论
    def show_comment(self):
        dian_ping = get_scenery_dian_ping(self.scenery_id)
        isSuccess = dian_ping['isSuccess']
        if not isSuccess == 1:
            print("获取评论失败")
            return
        page = dian_ping['pageInfo']['page']
        page_size = dian_ping['pageInfo']['pageSize']
        total_page = dian_ping['pageInfo']['totalPage']
        total_count = dian_ping['pageInfo']['totalCount']
        degree_level = dian_ping['degreeLevel']
        good_comment = dian_ping['goodNum']
        middle_comment = dian_ping['midNum']
        bad_comment = dian_ping['badNum']
        dp_list = dian_ping['dpList']
        print(f"共{total_count}条评论,当前第{page}页,共{total_page}页")
        print(f"好评率：{degree_level}%")
        print(f"好评：{good_comment}条，中评：{middle_comment}条，差评：{bad_comment}条")
        print("评论内容：")
        for i in range(len(dp_list)):
            dp_images =  dian_ping['dpImgUrl']
            print(f"{i + 1}、{dp_list[i]['dpContent']} {not dp_images == [] if '有'+str(len(dp_images))+'张图片' else ''} - {dp_list[i]['dpTime']}")
# print(Search().get_search_total())
Search().show_comment()