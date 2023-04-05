//
// Created by 18020 on 2023/4/4.
//

#ifndef LINKEDLIST_LIST_H
#define LINKEDLIST_LIST_H
typedef int ElemType;
typedef struct node LNode,*LinkList;
/**
 * 创建带头节点的链表
 * @Return 最后一个节点的指针
 * */
LinkList Create_Head();

/**
 * 输出链表
 * @Param LinkList 需要被输出的链表
 * */
void DispList(LinkList L);

// 尾插入 尾指针
/**
 * 按位查找元素
 * @Parem L 要查找的链表
 * @Parem i  要查找的元素的位置
 * @Return 被查找元素的指针
 * */
LNode *GetElem(LinkList L,int i);

/**
 * 按值查找元素
 *  @Parem L 要查找的链表
 *  @Parem e 要查找的元素
 *  @Return 被查找元素的指针
 * */
LNode *LocateElem(LinkList L,ElemType e);

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
