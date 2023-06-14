import json
import re
import time

import pandas as pd
import jieba
from collections import Counter

file_path = '../../data/comment/青城山.json'

# 读取分析文本,返回一段字符串
def read_file(file_path):
    comments = ''
    with open(file_path, 'r', encoding='utf-8') as f:
        text = f.read()
        # 转为列表
        text = eval(text)
        # 遍历列表
        for i in text:
            # 添加评论到comments
            comments += i['content']
            # print(i)
    return comments

# 读取分析文本,返回一个列表
def read_file_to_list(file_path):
    with open(file_path, 'r', encoding='utf-8') as f:
        text = f.read()
        # 转为列表
        text = eval(text)
    return text

comments_list = read_file_to_list(file_path)
comments_text = read_file(file_path)

# 分词
def tokenization(comments):
    # 分词
    words = jieba.lcut(comments)
    # 去掉符号,空格,换行符,逗号,句号
    for i in range(len(words)):
        words[i] = words[i].strip()
        # 去掉中英文符号
        words[i] = re.sub("[\s+\.\!\/_,$%^*(+\"\')]+|[+——！，。？、~@#￥%……&*（）:；【】「」《》【】“”‘’]+", "", words[i])

        if words[i] == ' ' or words[i] == '\n' or words[i] == '\t' or words[i] == '\r':
            words[i] = ''
    # 去掉空字符
    while '' in words:
        words.remove('')
    return words

# 去除停用词
def remove_stopwords(words):
    # 加载中文停用词表
    stopwords_path = '../file/cn_stopwords.txt'
    with open(stopwords_path, 'r', encoding='utf-8') as f:
        stopwords = f.read().splitlines()

    # 去除停用词
    new_words = []
    for word in words:
        if word not in stopwords:
            new_words.append(word)
    return new_words

# 列表转为DataFrame
def list_to_df(words,columns=['word']):
    df = pd.DataFrame(words, columns=['word'])
    return df

# 获得词频
def get_word_counts(comments,count=100):
    # 分词
    words = tokenization(comments)

    # 去除停用词
    new_words = remove_stopwords(words)

    # 统计词频
    word_counts = Counter(new_words)

    # 获取出现频率前100的词语及其出现次数
    top_words = word_counts.most_common(count)

    # 将结果转换为JSON格式的字符串
    result = []
    for word, count in top_words:
        result.append({
            'word': word,
            'count': count
        })
    return json.dumps(result, ensure_ascii=False).encode('utf-8').decode('utf-8')

# print(get_word_counts(comments_text))

# 获得评论最多的前三个月
def get_top_three_month(comments):
    # 获得评论时间列表
    comments_times = []
    for i in comments:
        comments_times.append(i['date'])

    month_counts = {}
    for time_str in comments_times:
        # 将时间字符串转换为时间元组
        time_tuple = time.strptime(time_str, '%Y-%m-%d')
        # 获取月份
        month = time_tuple.tm_mon
        if month in month_counts:
            month_counts[month] += 1
        else:
            month_counts[month] = 1

    # 按照评论数量从大到小排序
    sorted_month_counts = sorted(month_counts.items(), key=lambda x: x[1], reverse=True)

    # 取出评论数量前3的月份
    top_months = [{'month': month, 'count': count} for month, count in sorted_month_counts[:3]]
    json_str = json.dumps(top_months, ensure_ascii=False)
    return json_str


# print(get_top_three_month(comments_list))

# 评论长度分析对评论的长度进行统计分析，了解游客对景区的评价和反馈是否充分和详细，以及游客评论的倾向和态度。
def get_comment_length(comments):
    # 获得评论长度列表
    comments_length = []
    for i in comments:
        comments_length.append(len(i['content']))

    # 统计评论长度
    length_counts = Counter(comments_length)

    # 转换成指定格式
    result = []
    for length, count in length_counts.items():
        result.append({"value": length, "count": count})

    return result

print(get_comment_length(comments_list))