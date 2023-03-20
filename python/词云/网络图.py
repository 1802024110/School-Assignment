import networkx as nx
G = nx.Graph() # 创建一个空的图对象
G.add_node("A") # 添加一个节点A
G.add_node("B") # 添加一个节点B
G.add_node("C") # 添加一个节点C
G.add_edge("A", "B") # 添加一条边AB
G.add_edge("B", "C") # 添加一条边BC
import matplotlib.pyplot as plt

nx.draw(G, with_labels=True) # 用matplotlib绘制网络图，并显示节点标签
plt.show() # 显示图像

# 或者

import plotly.graph_objects as go
pos = nx.spring_layout(G) # 用spring布局算法计算节点位置
edge_x = [] # 存储边的x坐标列表
edge_y = [] # 存储边的y坐标列表
for edge in G.edges():
    x0, y0 = pos[edge[0]] # 边的起点坐标
    x1, y1 = pos[edge[1]] # 边的终点坐标
    edge_x.extend([x0, x1, None]) # 将边的x坐标加入列表，并在每条边之间插入None值，以便plotly正确绘制线段而不是多边形。
    edge_y.extend([y0, y1, None]) # 同理

edge_trace = go.Scatter( # 创建一个散点图对象，用于绘制边
    x=edge_x,
    y=edge_y,
    line=dict(width=0.5, color="#888"), # 设置线条宽度和颜色
    hoverinfo="none", # 不显示悬停信息框 
    mode="lines" # 设置模式为线段而不是点 
)

node_x = [] # 存储节点的x坐标列表 
node_y = [] # 存储节点的y坐标列表 
for node in G.nodes():
    x, y = pos[node]