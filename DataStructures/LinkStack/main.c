#include <stdio.h>
#include <malloc.h>
#include <windows.h>

typedef char ElemType;
typedef struct SNODE {
    ElemType data;
    struct SNODE *next;
} SNODE, *LinkStack;

/** 初始化空的链栈
 * @Return: 返回栈顶指针
 * */
LinkStack Init() {
    LinkStack top = NULL;
    return top;
}

/** 判断栈是否为空
 * @Param: top 栈顶指针
 * @Return: 1为空，0为非空
 * */
int isEmpty(LinkStack top) {
    return top == NULL ? 1 : 0;
}

/** 进栈
 * @Param: top 栈顶指针
 * @Param: e 进栈元素
 * @Return: 无
 * */
LinkStack PushStack(LinkStack top, ElemType e) {
    LinkStack p = (LinkStack) malloc(sizeof(SNODE));
    if (!p) {
        printf("内存分配失败！\n");
        return NULL;
    } else {
        p->data = e;
        p->next = top;
        top = p;
        return top;
    }
}

/** 出栈,带返回值
 *
 * */
LinkStack PopStack(LinkStack top,ElemType *e) {
    if (isEmpty(top)) {
        printf("栈为空！\n");
        return NULL;
    } else {
        LinkStack p = top;
        top = top->next;
        *e = p->data;
        free(p);
        return top;
    }
}

/** 出栈,不带返回值
 *
 * */
LinkStack PopStackNoReturn(LinkStack top) {
    if (isEmpty(top)) {
        printf("栈为空！\n");
        return NULL;
    } else {
        LinkStack p = top;
        top = top->next;
        free(p);
        return top;
    }
}

/** 取栈顶元素
 * @Param: top 栈顶指针
 * @Return: 栈顶元素
 * */
ElemType GetTop(LinkStack top) {
    if (isEmpty(top)) {
        printf("栈为空！\n");
        return -1;
    } else {
        return top->data;
    }
}

/** 输出栈
 * @Param: top 栈顶指针
 * @Return: 无
 * */
void Display(LinkStack top) {
    LinkStack p = top;
    while (p != NULL) {
        printf("%d ", p->data);
        p = p->next;
    }
    printf("\n");
}

// 匹配括号的函数
int MatchBracket(){
    // 初始化栈
    LinkStack top = Init();
    // 提示用户输入表达式
    printf("请输入表达式，以换行符结束：");
    // 逐个读取输入的字符
    char ch;
    while ((ch = getchar()) != '\n') {
        // 如果是左括号，入栈
        if (ch == '(' || ch == '[' || ch == '{') {
            top = PushStack(top, ch);
        }
            // 如果是右括号，进行匹配
        else if (ch == ')' || ch == ']' || ch == '}') {
            // 如果栈为空，说明右括号多于左括号
            if (isEmpty(top)) {
                printf("右括号多于左括号！\n");
                return 0;
            }
                // 如果栈不为空，进行匹配
            else {
                char topElem = GetTop(top);
                // 如果匹配成功，出栈
                if ((topElem == '(' && ch == ')') || (topElem == '[' && ch == ']') || (topElem == '{' && ch == '}')) {
                    top = PopStackNoReturn(top);
                }
                    // 如果匹配失败，返回错误
                else {
                    printf("括号不匹配！\n");
                    return 0;
                }
            }
        }
    }
    // 如果栈为空，说明匹配成功
    if (isEmpty(top)) {
        printf("括号匹配！\n");
        return 1;
    }
        // 如果栈不为空，说明左括号多于右括号
    else {
        printf("左括号多于右括号！\n");
        return 0;
    }
}

int main() {
    SetConsoleOutputCP(65001);
    MatchBracket();
    return 0;
}
