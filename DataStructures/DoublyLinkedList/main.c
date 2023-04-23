#include <stdio.h>
#include <malloc.h>

typedef int ElementType;
typedef struct node{
    struct node *prev;
    ElementType data;
    struct node *next;
} NODE,*PNODE;

/** 创建链表-头插入 包含头节点,使用数组a中的元素创建链表，元素个数为n
 * */
PNODE createList(ElementType *a,int n){
    // 创建头节点
    PNODE head = (PNODE)malloc(sizeof(NODE));
    head->next = NULL;
    head->prev = NULL;
    for (int i = 0; i < n; i++) {
        // 创建新节点
        PNODE p = (PNODE)malloc(sizeof(NODE));
        p->data = a[i];
        // 将新节点插入到头节点之后
        p->next = head->next;
        if(p->next != NULL){
            p->next->prev = p;
        }
        head->next = p;
        p->prev = head;
    }
    return head;
}

/** 创建链表-尾插入 包含头节点,使用数组a中的元素创建链表，元素个数为n
 * */
PNODE createListInEnd(ElementType *a,int n){}

/** 打印链表
 * */
void Display(PNODE head){
    if(head->prev == NULL && head->next == NULL){
        printf("链表为空\n");
        return;
    }

    PNODE p = head->next;
    while(p != NULL){
        printf("%d ",p->data);
        p = p->next;
    }
    printf("\n");
}

/** 打印链表，逆序
 * */
void DisplayReverse(PNODE head){
    if(head->prev == NULL && head->next == NULL){
        printf("链表为空\n");
        return;
    }
    PNODE p = head;
    while(p->next != NULL){
        p = p->next;
    }
    while(p != head){
        printf("%d ",p->data);
        p = p->prev;
    }
}
int main() {
    ElementType a[] = {1,2,3,4,5};
    PNODE head = createList(a,5);
//    Display(head);
    DisplayReverse(head);
    return 0;
}
