# 导入模块
from wordcloud import WordCloud
import jieba

# 提供文本数据
text = "今天是星期二，天气晴朗，适合出去玩。我和我的朋友们去了公园，看到了很多美丽的花草树木。我们还在湖边喂了鸭子，拍了很多照片。我觉得今天很开心，希望明天也能这样。"

# 对中文文本进行分词
words = jieba.cut(text)
text = " ".join(words)

# 创建词云对象，并指定字体文件
wc = WordCloud(width=800, height=600, background_color="white", max_words=100, font_path="simhei.ttf")

# 生成词云
wc.generate(text)

# 显示词云
wc.to_image().show()