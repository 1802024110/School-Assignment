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
PNODE createListInEnd(ElementType *a,int n){
    // 创建头节点
    PNODE head = (PNODE)malloc(sizeof(NODE));
    head->next = NULL;
    head->prev = NULL;
    PNODE tail = head;
    for (int i = 0; i < n; i++) {
        // 创建新节点
        PNODE p = (PNODE)malloc(sizeof(NODE));
        p->data = a[i];
        // 将新节点插入到头节点之后
        tail->next = p;
        p->prev = tail;
        tail = p;
    }
    tail->next = NULL;
    return head;
}

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
void insertById(PNODE head,int pos,ElementType val){
    PNODE p = head;
    int i = 0;
    while(p != NULL && i < pos){
        p = p->next;
        i++;
    }
    if(p == NULL){
        printf("插入位置不合法\n");
        return;
    }
    PNODE q = (PNODE)malloc(sizeof(NODE));
    q->data = val;
    q->next = p->next;
    if(p->next != NULL){
        p->next->prev = q;
    }
    p->next = q;
    q->prev = p;
}
void deleteById(PNODE head,int pos,ElementType *e){
    PNODE p = head;
    int i = 0;
    while(p->next != NULL && i < pos){
        p = p->next;
        i++;
    }
    if(p->next == NULL){
        printf("删除位置不合法\n");
        return;
    }
    PNODE q = p->next;
    p->next = q->next;
    if(q->next != NULL){
        q->next->prev = p;
    }
    *e = q->data;
    free(q);
}
int main() {
    ElementType a[] = {1,2,3,4,5};
//    PNODE head = createList(a,5);
//    Display(head);
    PNODE head = createListInEnd(a,5);
    DisplayReverse(head);
    return 0;
}
