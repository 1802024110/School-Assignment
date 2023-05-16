#include <stdio.h>
#include <process.h>
#include <malloc.h>

#define MAXSIZE 100
typedef char ElemType;

typedef struct {
    ElemType data[MAXSIZE];
    int top;
} SqStack; // 顺序栈

SqStack * Init(){
    SqStack *s;
    s = (SqStack *)malloc(sizeof(SqStack));
    if (!s){
        printf("内存分配失败");
        exit(0);
    }
    s->top = -1;
    return s;
}

int Push(SqStack *s, ElemType e){
    if (s->top == MAXSIZE - 1){
        printf("栈满");
        return 0;
    }
    s->top++;
    s->data[s->top] = e;
    return 1;
}

int main() {
    printf("Hello, World!\n");
    return 0;
}
