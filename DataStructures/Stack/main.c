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

/** 判断栈是否为空
 * @Param s 栈
 * @Return 1 空 0 非空
 * */
int Empty_SeqStack(SqStack *s){
    if (s->top == -1){
        // 判断栈是否为空
        return 1;
    }
    return 0;
}

/** 出栈
 * @Param s 栈
 * @Return ElemType 出栈元素
 * */

ElemType Pop(SqStack *s){
    if (Empty_SeqStack(s)){
        // 判断栈是否为空
        printf("栈空");
        exit(0);
    }
    ElemType e;
    e = s->data[s->top];
    // 取出栈顶元素
    s->top--;
    // 栈顶指针减 1
    return e;
}

/** 输出栈中元素
 * @Param s 栈
 * @Return void
 * */
void Show(SqStack *s){
    if (Empty_SeqStack(s)){
        // 判断栈是否为空
        printf("栈空");
        return;
    }
    for (int i = 0; i <= s->top; i++){
        // 遍历栈中元素, 从栈底到栈顶
        printf("%c ", s->data[i]);
    }
    printf("\n");
}

// 将十进制数n转换为base进制数
void Convert(SqStack *s, int n, int base) {
    int r;
    while (n != 0) {
        r = n % base; // 求余数
        Push(s, r); // 将余数入栈
        n = n / base; // 更新n的值
    }
}

// 读取输入的十进制数和要转换的进制
void Input(int *n, int *base) {
    printf("请输入一个十进制数n：");
    scanf("%d", n);
    printf("请输入要转换的进制(base)：");
    scanf("%d", base);
}

// 输出转换后的进制数
void Output(SqStack *s, int n, int base) {
    printf("%d转换为%d进制的结果为：", n, base);
    while (!Empty_SeqStack(s)) { // 将栈中元素出栈并打印
        printf("%d", Pop(s));
    }
    printf("\n");
}


int main() {
    return 0;
}