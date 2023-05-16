#include <stdio.h>
#include <stdlib.h>

#define MAXSIZE 100
typedef char ElemType;
// 定义元素类型为 char

typedef struct {
    ElemType data[MAXSIZE];
    // 数据数组
    int top;
    // 栈顶指针
} SqStack;
// 顺序栈

SqStack * Init(){
    SqStack *s;
    s = (SqStack *)malloc(sizeof(SqStack));
    // 动态分配内存空间
    if (!s){
        printf("内存分配失败");
        exit(0);
    }
    s->top = -1;
    // 初始化栈顶指针
    return s;
}

/** 入栈
 * @Param s 栈
 * @Param e 入栈元素
 * @Return 1 成功 0 失败
 * */
int Push(SqStack *s, ElemType e){
    if (s->top == MAXSIZE - 1){
        // 判断栈是否已满
        printf("栈满");
        return 0;
    }
    s->top++;
    // 栈顶指针加 1
    s->data[s->top] = e;
    // 入栈元素放入栈顶位置
    return 1;
}

/** 出栈
 * @Param s 栈
 * @Param e 出栈元素
 * @Return 1 成功 0 失败
 * */
int Pop(SqStack *s, ElemType *e){
    if (s->top == -1){
        // 判断栈是否为空
        printf("栈空");
        return 0;
    }
    *e = s->data[s->top];
    // 取出栈顶元素
    s->top--;
    // 栈顶指针减 1
    return 1;
}

int main() {
    SqStack *s = Init();
    // 初始化栈
    Push(s, 'a');
    // 元素 'a' 入栈
    char b;
    Pop(s, &b);
    // 出栈操作，将出栈元素赋值给变量 b
    printf("b 是 %c", b);
    // 输出变量 b 的值
    return 0;
}