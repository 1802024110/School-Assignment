#include <stdio.h>
#include <malloc.h>
typedef struct node{
    int coef; // 系数
    int expn; // 指数
    struct node * next;
}plinknode;

/**
 * 创建链表保存一元多项式
 * */
plinknode * Init(){
    plinknode *head,*end,*p,*p1,*p2;
    int m,n;
    p=(plinknode *)malloc(sizeof(plinknode));
    p->coef = 0;
    p->expn = -1;
    p->next = NULL;
    head = p;
    end = p;
    printf("多项式的项数：");
    scanf("%d",&m);
    for (n = 1; n <= m; n++) {
        // 重新开辟空间，防止把正常的元素修改了
        p=(plinknode *)malloc(sizeof(plinknode));
        printf("系数，指数：");
        scanf("%d,%d",&p->coef,&p->expn);
        if(p->expn>end->expn){
            end->next = p;
            p->next = NULL;
            end = end->next;
        } else{
            p1 = head;
            p2 = head->next;
            while (p2){
                if(p2->expn == p->expn){
                    p2->coef = p2->coef+p->coef;
                    free(p);
                    if(p2->coef == 0){
                        p1->next = p2->next;
                        free(p2);
                        if(p2->next == NULL){
                            end = p1;
                        }
                        free(p2);
                    }
                    break;
                }
                if(p2->expn>p->expn){
                    p1->next=p;
                    p2->next=p2;
                    break;
                }
                p1 = p1->next;
                p2 = p2->next;
            }
        }
    }
    return head;
}

int main() {
    printf("Hello, World!\n");
    return 0;
}
