//
// Created by 18020 on 2023/4/4.
//

#ifndef LINKEDLIST_LIST_H
#define LINKEDLIST_LIST_H
typedef char ElemType;
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
 * @Param L 要查找的链表
 * @Param i  要查找的元素的位置
 * @Return 被查找元素的指针
 * */
LinkList GetElem(LinkList L,int i);

/**
 * 按值查找元素
 *  @Param L 要查找的链表
 *  @Param e 要查找的元素
 *  @Return 被查找元素的指针,若没有找到返回NULL
 * */
LinkList LocateElem(LinkList L,ElemType e);
/**
 * 在链表L中插入节点，在x后插入y
 * @Param LinkList L 需要被修改的链
 * @Param ElemType x 需要在链表什么值后面插入
 * @Param ElemType y 需要插入的值
 * */
void insertBeforeByVal(LinkList L,ElemType x,ElemType y);


// 单向非循环链表
// 单向循环链表
// 双向非循环链表
// 双向循环链表
#endif //LINKEDLIST_LIST_H
