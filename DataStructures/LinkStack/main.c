#include <stdio.h>
#include <malloc.h>

typedef int ElemType;
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

/** 出栈
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

int main() {
    LinkStack top = Init();
    top = PushStack(top, 40);
    top = PushStack(top, 30);
    top = PushStack(top, 20);
    top = PushStack(top, 10);
    ElemType e ;
    top = PopStack(top,&e);
    printf("出栈元素为：%d\n",e);
    Display(top);
    return 0;
}
