import turtle

# 设置棋盘格子的大小和间隔
cell_size = 50
cell_padding = 5

# 初始化turtle
turtle.setup(500, 500)
turtle.penup()
turtle.speed(0)
turtle.hideturtle()

# 绘制棋盘
for row in range(9):
    for col in range(9):
        x = col * (cell_size + cell_padding) - 4 * cell_size
        y = row * (cell_size + cell_padding) - 4 * cell_size
        turtle.goto(x, y)
        turtle.pendown()
        turtle.setheading(0)
        for i in range(4):
            turtle.forward(cell_size)
            turtle.right(90)
        turtle.penup()

# 显示绘制结果
turtle.done()