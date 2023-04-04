//
// Created by 18020 on 2023/4/4.
//

#ifndef LINKEDLIST_LIST_H
#define LINKEDLIST_LIST_H
typedef int ElemType;
typedef struct node LNode,*LinkList;

LinkList Create_Head();

/**
 * 输出链表
 * @Param LinkList 需要被输出的链表
 * */
void DispList(LinkList L);

// 尾插入 尾指针

/* 查找
按位置查找第i个
等于i
按值查找
返回指针
找到，返回指向我到结点的指销
没有找到，返回空指针*/

// 单向非循环链表
// 单向循环链表
// 双向非循环链表
// 双向循环链表
#endif //LINKEDLIST_LIST_H
