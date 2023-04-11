//
// Created by 18020 on 2023/4/4.
//
#include "List.h"
#include <stdio.h>
#include <malloc.h>

typedef char ElemType;
typedef struct node{
    // 数据
    ElemType data;
    // 下一个节点的指针
    struct node *next;
}LNode,*LinkList;

LinkList Create_Head(){
    LinkList headNode, currentNode;
    //声明头节点和当前节点
    ElemType data, flag = '0';
    //声明数据和结束标志
    printf("请输入数据，以 %c 结束:", flag);
    //提示用户输入数据
    scanf("%c", &data);
    //读取用户输入的数据
    headNode = (LinkList) malloc(sizeof(LNode));
    //创建头节点
    headNode->next = NULL;
    //将头节点的指针域设为 NULL
    while (data != flag) {
        //循环读取用户输入的数据，直到遇到结束标志
        currentNode = (LinkList) malloc(sizeof(LNode));
        //创建当前节点
        currentNode->data = data;
        //将当前节点的数据域设为用户输入的数据
        currentNode->next = headNode->next;
        //将当前节点的指针域指向头节点的下一个节点
        headNode->next = currentNode;
        //将头节点的指针域指向当前节点
        scanf("%c", &data);
        //读取用户输入的数据
    }
    currentNode = (LinkList) malloc(sizeof(LNode));
    //创建一个新的节点
    currentNode->next = headNode->next;
    //将新节点的指针域指向头节点的下一个节点
    headNode->next = NULL;
    //将头节点的指针域指向新节点
    return currentNode;
    //返回头节点
};

void DispList(LinkList L){
    if(L == NULL){
        printf("参数传入错误");
        return;
    }
    LinkList p;
    p = L->next;
    while (p!=NULL){
        printf("%c,",p->data);
        p = p->next;
    }
};

LinkList GetElem(LinkList L,int i){
    if(L == NULL || i<1){
        printf("参数错误!\n");
    } else{
        LNode *p = L;
        int j = 0;
        while(p != NULL&& j < i){
            p = p->next;
            j++;
        }
        return p;
    }
}

LinkList LocateElem(LinkList L,ElemType e){
    if(L == NULL || e==NULL){
        printf("参数错误!\n");
    } else{
        LNode *p = L->next;
        while (p!= NULL && p->data!=e){
            p = p->next;
        }
        return p;
    }
}

void insertBeforeByVal(LinkList L,ElemType x,ElemType y){
    // 找到x节点
    LinkList  p,s;
    p = LocateElem(L,x);
    if(p==NULL){
        printf("参数错误，p为NULL");
    } else{
        // 为新节点申请空间
        s = (LinkList) malloc(sizeof(LNode));
        s->data = y;
        s->next = p->next;
        p->next=s;
    }
}
