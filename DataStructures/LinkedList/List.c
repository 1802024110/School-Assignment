//
// Created by 18020 on 2023/4/4.
//
#include "List.h"
#include <stdio.h>
#include <malloc.h>

typedef int ElemType;
typedef struct node{
    // 数据
    ElemType data;
    // 下一个节点的指针
    struct node *next;
}LNode,*LinkList;

LinkList Create_Head(){
    LinkList  L,s;
    ElemType x,flag = 0;
    printf("输入:");
    scanf("%d",&x);
    while (x!=flag){
        s = (LinkList) malloc(sizeof(LNode));
        s->data = x;
        s->next = L;
        L = s;
        scanf("%d",&x);
    }
    s = (LinkList) malloc(sizeof(LNode));
    s->next = L;
    L = s;
    return L;
};

void DispList(LinkList L){
    if(L == NULL){
        printf("参数传入错误");
        return;
    }
    LinkList p;
    p = L->next;
    while (p!=NULL){
        printf("%d,",p->data);
        p = p->next;
    }
};
