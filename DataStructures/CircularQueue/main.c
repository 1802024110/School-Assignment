#include <malloc.h>

typedef char ElemType;

typedef struct snode{
    ElemType data;
    struct snode *next;
} node;

typedef struct queue{
    // 队头指针
    node *front;
    // 队尾指针
    node *rear;
} *Queue_t;

/** 初始化队列
 * */
Queue_t InitQueue() {
    Queue_t q = (Queue_t)malloc(sizeof(struct queue));
    q->front = q->rear = NULL;
    return q;
}

/** 链队列入队
 * @Param Queue_t 队列
 * @Param ElemType 入队元素
 * @Return int 0:入队失败 1:入队成功
 * */
int InQueue(Queue_t q,ElemType x){
    // 创建新节点
    node *new_p = (node *)malloc(sizeof(node));
    // 节点创建失败
    if(new_p == NULL) return 0;

    // 节点赋值
    new_p->data = x;
    new_p->next = NULL;

    // 如果头指针为空，说明队列为空，是第一个节点
    if(q->front == NULL){
        // 头指针和尾指针都指向新节点
        q->front = q->rear = new_p;
    } else{
        // 将新节点插入到队尾
        q->rear->next = new_p;
        // 尾指针指向新节点
        q->rear = new_p;
    }
    return 1;
}

/** 打印链队中的所有元素
 * @Param Queue_t 队列
 * @Return void
 * */
void PrintQueue(Queue_t q){
    // 判断队列是否为空
    if(q->front == NULL){
        printf("队列为空\n");
        return;
    }

    printf("队列元素如下\n");
    // 初始化临时指针指向头指针
    node *p = q->front;
    while (p != NULL){
        printf("%c ",p->data);
        p = p->next;
    }
    printf("\n");
}

/** 链队出队
 * @Parma Queue_t 队列
 * @Return ElemType 出队元素
 * */
ElemType OutQueue(Queue_t q){
    if(q->front == NULL){
        printf("队列为空\n");
        return 0;
    }
    // 临时指针指向头指针
    node *p = q->front;
    // 保存出队元素
    ElemType temp = p->data;

    // 头指针指向下一个节点
    q->front = q->front->next;

    // 如果头指针为空，说明队列为空，将尾指针置空
    if(q->front == NULL){
        q->rear = NULL;
    }

    // 释放出队节点
    free(p);
    return temp;
}

/** 获得队头元素
 * @Param Queue_t 队列
 * */
ElemType GetFront(Queue_t q){
    if(q->front == NULL){
        printf("队列为空\n");
        return 0;
    }
    return q->front->data;
}

/** 获得队尾元素
 * @Param Queue_t 队列
 * */
ElemType GetRear(Queue_t q){
    if(q->rear == NULL){
        printf("队列为空\n");
        return 0;
    }
    return q->rear->data;
}

/** 销毁队列
 * @Param Queue_t 队列
 * */
void DestroyQueue(Queue_t q){
    // 临时指针指向头指针
    node *p = q->front;
    // 循环释放所有节点
    while (p != NULL){
        // 临时指针指向下一个节点
        node *temp = p;
        p = p->next;
        free(temp);
    }
    // 头指针和尾指针置空
    q->front = q->rear = NULL;
}

int main(int argc, char *argv[]) {

    Queue_t q = InitQueue();
    InQueue(q,'a');
    InQueue(q,'b');
    InQueue(q,'c');

    DestroyQueue(q);

    PrintQueue(q);
    return 0;
}
