from data_parser.search import get_attractions_list
from request.scenery import get_scenery_dian_ping
from request.search import get_search_json
import os

# 文件保存路径
path = "../data/comment"

class Search:
    def __init__(self):
        self.search_value = input("请输入要搜索的景点名称：")
        self.scenery_list = get_attractions_list(get_search_json(self.search_value))
        self.total = self.scenery_list[-1]['total']
        self.page = 1
        self.choose_scenery_info = self.choose_search_result()
        self.scenery_id = self.choose_scenery_info['景点ID']
        self.scenery_name = self.choose_scenery_info['标题']

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

    # 获得评论
    def get_comment(self, page=1, page_size=10, lab_id=1):
        dian_ping = get_scenery_dian_ping(self.scenery_id, page, page_size, lab_id)
        isSuccess = dian_ping['isSuccess']
        if not isSuccess == 1:
            print("获取评论失败")
            return []

        # 评论列表
        comments = {}

        page = dian_ping['pageInfo']['page']
        page_size = dian_ping['pageInfo']['pageSize']
        total_page = dian_ping['pageInfo']['totalPage']
        total_count = dian_ping['pageInfo']['totalCount']
        degree_level = dian_ping['degreeLevel']
        good_comment = dian_ping['goodNum']
        middle_comment = dian_ping['midNum']
        bad_comment = dian_ping['badNum']
        dp_list = dian_ping['dpList']

        # 添加评论长度
        comments['comment_count'] = total_count
        # 添加评论页数
        comments['page_size'] = page_size

        # print(f"共{total_count}条评论,当前第{page}页,共{total_page}页")
        # print(f"好评率：{degree_level}%")
        # print(f"好评：{good_comment}条，中评：{middle_comment}条，差评：{bad_comment}条")
        # print("评论内容：")
        for i in range(len(dp_list)):
            # 单条评论的列表
            comment = {}
            dp_images = dp_list[i]['dpImgUrl']
            # 添加评论图片{images:[]},这种格式
            comment['images'] = dp_images
            # 添加评论内容
            comment['content'] = dp_list[i]['dpContent']
            # 添加评论时间
            comment['date'] = dp_list[i]['dpDate']
            # 添加到评论列表
            try:
                comments['comments'].append(comment)
            except:
                comments['comments'] = [comment]
        return comments

    # 保存评论
    def save_comment(self):
        if not os.path.exists(path):
            os.makedirs(path)

        # 检查文件夹是否存在
        comments = self.get_comment()
        # 总页数
        total_page = comments['page_size']
        # 评论缓存buffer
        comment_buffer = []
        for i in range(total_page):
            comments = self.get_comment(page=i + 1)
            comments = comments['comments']

            for comment in comments:
                comment_buffer.append(comment)

            # 保存评论
        with open(f"../data/comment/{self.scenery_name}.json", 'w', encoding='utf-8') as f:
            f.write(str(comment_buffer))

    # 获得节点好评、中评、差评数量
    def get_comment_count(self):
        dian_ping = get_scenery_dian_ping(self.scenery_id)
        isSuccess = dian_ping['isSuccess']
        if not isSuccess == 1:
            print("获取评论失败")
            return []

        good_comment = dian_ping['goodNum']
        middle_comment = dian_ping['midNum']
        bad_comment = dian_ping['badNum']

        return [good_comment, middle_comment, bad_comment]


    # 保存景点好评、中评、差评数量
    def save_comment_count(self):
        if not os.path.exists(path):
            os.makedirs(path)

        dian_ping = get_scenery_dian_ping(self.scenery_id)
        isSuccess = dian_ping['isSuccess']
        if not isSuccess == 1:
            print("获取评论失败")
            return []

        good_comment = dian_ping['goodNum']
        middle_comment = dian_ping['midNum']
        bad_comment = dian_ping['badNum']

        print(f"好评：{good_comment}条，中评：{middle_comment}条，差评：{bad_comment}条")

        with open(f"../data/comment/{self.scenery_name}_count.json", 'w', encoding='utf-8') as f:
            f.write(str([good_comment, middle_comment, bad_comment]))

