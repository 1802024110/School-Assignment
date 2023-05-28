#include <malloc.h>
#include <stdlib.h>

typedef char ElemType;
typedef struct Queue{
    ElemType *p;
    // 队头指针
    int front;
    // 队尾指针
    int rear;
} *Queue;

/** 初始化队列
 * @Params: Queue q 队列指针
 * */
void InitQueue(Queue q) {
    // 分配内存, 长度为4
    q->p = (ElemType *)malloc(sizeof(ElemType) * 4);
    if(q->p == NULL) exit(0);
    q->front = q->rear = 0;
}

/** 判断循环队列是否已满
 * */
int IsFull(Queue q) {
    // 队尾指针+1取模4等于队头指针, 则队列已满
    if((q->rear+1)%4 == q->front) return 1;
    return 0;
}

/** 判断循环队列是否为空
 * */
int IsEmpty(Queue q) {
    // 队头指针等于队尾指针, 则队列为空
    if(q->front == q->rear) return 1;
    return 0;
}

/** 循环队列入队
 * */
int InqQueue(Queue q,ElemType x){
    if(IsFull(q)) return 0;
    q->p[q->rear] = x;
    q->rear = (q->rear+1)%4;
    return 1;
}

/** 循环队列出队
 * */
int OutQueue(Queue q,ElemType *val){
    if(IsEmpty(q)) return 0;

    // 出队
    *val = q->p[q->front];
    // 更改队头指针，指向下一个元素
    q->front = (q->front+1)%4;
    return 1;
}

/** 循环输出队列
 * */
void PrintQueue(Queue q) {
    if(IsEmpty(q)) return;

    // 从队头开始循环输出
    int i = q->front;
    // 队尾指针不等于队头指针时, 继续循环
    while(i != q->rear) {
        printf("%c ",q->p[i]);
        // 指针+1取模4,因为队列长度为4
        i = (i+1)%4;
    }
    printf("\n");
}

int main(int argc, char *argv[]) {
    return 0;
}
