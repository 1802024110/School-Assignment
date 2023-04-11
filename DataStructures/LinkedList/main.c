#include <stdio.h>
#include <windows.h>
#include "List.h"
typedef char ElemType;
typedef struct node{
    // 数据
    ElemType data;
    // 下一个节点的指针
    struct node *next;
}LNode,*LinkList;
int main() {
    SetConsoleOutputCP(65001); // 设置控制台输出编码为 UTF-8，避免中文乱码
    system("cls"); //清屏

    LinkList H = Create_Head();
//    DispList(H);
//    insertBeforeByVal(H,'b','d');
//    insertAfterByVal(H,'b','d');
//    deleteByVal(H,'b');
    deleteByPos(H,1);
    DispList(H);
    return 0;
}