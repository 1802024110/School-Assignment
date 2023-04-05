#include <stdio.h>
#include <windows.h>
#include "List.h"
typedef int ElemType;
typedef struct node{
    // 数据
    ElemType data;
    // 下一个节点的指针
    struct node *next;
}LNode,*LinkList;
int main() {
    SetConsoleOutputCP(65001); // 设置控制台输出编码为 UTF-8，避免中文乱码
    system("cls"); //清屏

    LinkList L = Create_Head();
    // 调用GetElem方法获取链表中第3个元素
    LNode *p = GetElem(L, 1);
    printf("GetElem(L, 1)=%d\n", p->data) ;

    LNode *p2 = LocateElem(L,20);
    printf("LocateElem(L, 20) =%d\n", p2->data) ;
    return 0;
}
