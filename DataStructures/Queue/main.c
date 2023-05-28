#include <stdio.h>
#include <stdlib.h>

#define MAXSIZE 1024
typedef char ElemType;
typedef struct {
    ElemType data[MAXSIZE];
    int front;
    int rear;
} SeQueue;

//初始化队列
void InitQueue(SeQueue *q) {
    q->front = -1;
    q->rear = -1;
}

//进队
int InQueue(SeQueue *q, ElemType x) {
    if (q->rear == MAXSIZE - 1) {
        printf("队满，不能进队\n");
        return 0;
    }//判断队列是否已满
    q->rear++;
    q->data[q->rear] = x;
    return 1;
}

//判断队列是否为空
int IsEmpty(SeQueue *q) {
    int count;
    count = (q->rear) - (q->front);
    if (count == 0)
        return 1;
    return 0;
}

//出队
ElemType OutQueue(SeQueue *q) {
    if (IsEmpty(q)) {
        return NULL;
    }
    q->front++;
    return q->data[q->front];
}

//读取队头元素
ElemType GetFront(SeQueue *q) {
    return q->data[q->front + 1];
}

//读取队尾元素
ElemType GetRear(SeQueue *q) {
    return q->data[q->rear + 1];
}

//销毁队列
void DestroyQueue(SeQueue *q) {
    free(q);
}

//显示队列所有元素
void PrintQueue(SeQueue *q) {
    int i;
    if (IsEmpty(q)) {
        printf("空队列\n");
        return;
    }
    printf("队列包含以下元素\n");
    for (i = q->front + 1; i <= q->rear; i++) {
        printf("%c  ", q->data[i]);
    }
    printf("\n");
}

int main(int argc, char *argv[]) {
    SeQueue *q;
    q = (SeQueue *) malloc(sizeof(SeQueue));
    InitQueue(q);
    InQueue(q, 'a');
    InQueue(q, 'b');
    InQueue(q, 'c');
    InQueue(q, 'd');

    DestroyQueue(q);

    PrintQueue(q);
    return 0;
}
