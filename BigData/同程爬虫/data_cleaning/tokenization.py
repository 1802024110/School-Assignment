import json
import re
import time

import pandas as pd
import nltk
import jieba
from collections import Counter

file_path = '../data/comment/青城山.json'

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

comments = read_file_to_list(file_path)

# 获得评论最多的前三个月
def get_top_three_month(comments):
    # 获得评论时间列表
    comments_times = []
    for i in comments:
        comments_times.append(i['date'])

    # TODO:统计评论时间，那几个月份的评论最多

    # 统计评论时间，那几个月份的评论最多
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

# 统计每个月出现词语最多的前10个词语
def get_top_ten_words(comments):
    # 将评论按照时间顺序排列
    comments_sorted = sorted(comments, key=lambda x: x['date'])

    # 将时间窗口设置为每月
    window_size = '30D'

    # 统计每个时间窗口中出现频率最高的词语及其出现次数
    word_counts = {}
    for comment in comments_sorted:
        # 将时间字符串转换为时间戳
        timestamp = time.mktime(time.strptime(comment['date'], '%Y-%m-%d'))
        # 使用 pandas 的 Timestamp 类来转换时间戳
        ts = pd.Timestamp.fromtimestamp(timestamp)
        # 获取时间窗口的字符串表示
        window_str = ts.floor(window_size).strftime('%Y-%m-%d') + '-' + ts.ceil(window_size).strftime('%Y-%m-%d')
        # 分词
        words = tokenization(comment['content'])
        # 去除停用词
        new_words = remove_stopwords(words)
        # 统计词频
        word_counts_window = Counter(new_words)
        # 取出出现频率最高的词语及其出现次数
        if word_counts_window:
            top_word, top_count = word_counts_window.most_common(1)[0]
            # 将结果存储到字典中
            if window_str in word_counts:
                word_counts[window_str][top_word] = top_count
            else:
                word_counts[window_str] = {top_word: top_count}

    # 将结果转换为 DataFrame 格式
    df = pd.DataFrame(word_counts).transpose()

    # 使用 resample 函数按照月份分组，并求出每组出现频率最高的前十个词语及其出现次数
    df_resampled = df.resample(window_size).apply(lambda x: dict(x.most_common(10)))

    # 将结果转换为 JSON 格式
    result = []
    for window_str, word_count in df_resampled.iterrows():
        for word, count in word_count[0].items():
            result.append({
                'window': window_str.strftime('%Y-%m-%d') + '-' + (window_str + pd.offsets.MonthEnd(1)).strftime('%Y-%m-%d'),
                'word': word,
                'count': count
            })

    json_str = json.dumps(result, ensure_ascii=False)
    print(json_str)

get_top_ten_words(comments)