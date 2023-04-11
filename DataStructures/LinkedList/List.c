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

void insertAfterByVal(LinkList L, ElemType x, ElemType y) {
    // 从链表的第一个节点开始遍历
    LinkList p = L->next;
    while (p != NULL) {
        // 如果找到了值为 x 的节点
        if (p->data == x) {
            // 创建一个新节点并插入到链表中
            LinkList q = (LinkList) malloc(sizeof(LNode));
            // 设置新节点数据域的值
            q->data = y;
            // 将新节点的指针域指向原节点的后继节点
            q->next = p->next;
            // 将原节点的指针域指向新节点
            p->next = q;
            return;
        }
        // 更改指针，遍历链表
        p = p->next;
    }
    // 如果没有找到值为 x 的节点，则输出提示信息
    printf("链表中没有找到值为 %c 的节点！", x);
}

void deleteByVal(LinkList L, ElemType x) {
    LinkList pre = L;  // 定义前驱节点
    LinkList p = L->next;  // 定义当前节点
    while (p != NULL) {  // 遍历链表
        if (p->data == x) {  // 如果找到了值为 x 的节点
            pre->next = p->next;  // 修改前驱节点的指向
            free(p);  // 释放被删除节点的内存
            return;
        }
        pre = p;  // 更新前驱节点
        p = p->next;  // 更新当前节点
    }
    // 如果没有找到值为 x 的节点，则输出提示信息
    printf("链表中没有找到值为 %c 的节点！", x);
}
void deleteByPos(LinkList L,int pos);
