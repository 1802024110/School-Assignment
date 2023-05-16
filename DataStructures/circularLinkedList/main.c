#include <stdio.h>
#include <stdlib.h>
#include <windows.h>;

typedef int ElemType;

typedef struct node {
    ElemType data;
    struct node *next;
} Node, *LinkList;


/*
 * 1. 创建单个循环链表
 * 2. 将两个单循环链表连接
 * 3. 打印输出
 * */

/** 尾插入创建单循环链表，返回头节点
 * */
LinkList createList(){
    ElemType flag = 0,x;
    LinkList head, p, q;
    head = (LinkList)malloc(sizeof(Node));
    head->next = head;
    p = head;
    printf("请输入数据，以空格分隔，0结束：");
    scanf("%d", &x);
    while (x != flag){
        q = (LinkList)malloc(sizeof(Node));
        q->data = x;
        p->next = q;
        p = q;
        scanf("%d", &x);
    }
    p->next = head;
    return head;
}

/** 创建单个循环链表，返回尾节点
 * */
LinkList createListReturnTail(){
    ElemType flag = 0,x;
    LinkList head,tail,q;
    head = (LinkList)malloc(sizeof(Node));
    head->next = head;
    tail = head;
    printf("请输入数据，以空格分隔，0结束：");
    scanf("%d", &x);
    while (x != flag){
        q = (LinkList)malloc(sizeof(Node));
        q->data = x;
        tail->next = q;
        tail = q;
        scanf("%d", &x);
    }
    tail->next = head->next;
    return tail;
}

/** 打印输出单循环链表
 * */
void display(LinkList head){
    LinkList p = head->next;
    while (p != head){
        printf("%d ", p->data);
        p = p->next;
    }
    printf("\n");
}
/** 打印输出单循环链表，传入尾节点，从小到大的顺序
 *
 * */
void display_1(LinkList head){
    LinkList p = head;
    do {
        printf("%d ", p->data);
        p = p->next;
    } while (p != head);
    printf("\n");
}

/** 连接两个单循环链表
 * */
LinkList unionList(LinkList head1, LinkList head2){
    LinkList p1,p2;
    p1 = head1->next;
    while (p1->next != head1){
        p1 = p1->next;
    }
    p2 = head2->next;
    p1->next = p2;
    while (p2->next != head2){
        p2 = p2->next;
    }
    p1->next = head2->next;
    p2->next = head1;
    free(head2);
    return head1;
}

/** 两个单循环表的连接，传入两个链表的尾节点
 * */
LinkList unionListByTail(LinkList tail1, LinkList tail2){
    LinkList p = tail1->next;
    tail1->next = tail2->next;
    tail2->next = p;
    return tail1;
}

int main() {
    SetConsoleOutputCP(65001);
    system("cls");

    LinkList tail1 = createListReturnTail();
    LinkList tail2 = createListReturnTail();
    LinkList head = unionListByTail(tail1, tail2);
    display_1(head);
    return 0;
}
