#include <stdio.h>
#include <malloc.h>
#include <windows.h>

typedef struct node {
    int coefficient;
    // 系数
    int exponent;
    // 指数
    struct node *next;
    // 指向下一个节点的指针
} PolyNode;

/**
 * 创建链表保存一元多项式
 * @Param void
 * @Return PolyNode* 返回链表的头指针
 * */
PolyNode *Init() {
    PolyNode *head;
    // 头指针
    PolyNode *end;
    // 尾指针
    PolyNode *p;
    // 临时指针
    PolyNode *p1;
    // 临时指针
    PolyNode *p2;
    // 临时指针
    int m, n;
    // 定义变量存储多项式的项数和循环计数器
    p = (PolyNode *) malloc(sizeof(PolyNode));
    // 创建头结点
    p->coefficient = 0;
    // 头结点的系数为0
    p->exponent = -1;
    // 头结点的指数为-1（方便后面的节点插入）
    p->next = NULL;
    // 头结点指向空
    head = p;
    // 让头指针指向头结点
    end = p;
    // 让尾指针指向头结点
    printf("请输入多项式的项数：");
    // 提示用户输入多项式的项数
    scanf("%d", &m);
    // 读入用户输入的项数
    for (n = 1; n <= m; n++) {
        // 用循环读入每一项的系数和指数
        p = (PolyNode *) malloc(sizeof(PolyNode));
        // 创建一个新的节点,重新开辟空间，防止读取的是以前的旧数据
        printf("请输入第 %d 项的系数和指数（用逗号分隔）：", n);
        // 提示用户输入第n项的系数和指数
        scanf("%d,%d", &p->coefficient, &p->exponent);
        // 读入用户输入的系数和指数
        if (p->exponent > end->exponent) {
            // 判断新节点应该插入到链表的尾部还是中间
            end->next = p;
            // 将新节点插入到链表的尾部
            p->next = NULL;
            end = end->next;
            // 更新尾指针指向最后一个节点
        } else {
            p1 = head;
            // p1指向头结点
            p2 = head->next;
            // p2指向第一个节点
            while (p2) {
                // 在链表中查找新节点应该插入的位置
                if (p2->exponent == p->exponent) {
                    // 如果新节点与链表中的某个节点具有相同的指数
                    p2->coefficient = p2->coefficient + p->coefficient;
                    // 将它们的系数相加
                    free(p);
                    // 释放新节点的空间
                    if (p2->coefficient == 0) {
                        // 如果相加后的系数为0
                        p1->next = p2->next;
                        // 将该节点从链表中删除
                        free(p2);
                        // 释放该节点的空间
                        if (p2->next == NULL) {
                            // 如果该节点是链表的最后一个节点
                            end = p1;
                            // 更新尾指针指向最后一个节点
                        }
                    }
                    break;
                    // 结束循环
                }
                if (p2->exponent > p->exponent) {
                    // 如果新节点的指数比当前节点的指数小
                    p1->next = p;
                    // 将新节点插入到当前节点之前
                    p->next = p2;
                    break;
                    // 结束循环
                }
                p1 = p1->next;
                // 更新p1和p2指针
                p2 = p2->next;
            }
        }
    }
    return head;
    // 返回链表头指针
}

/**
 * 打印链表
 * @Param PolyNode* head 链表的头指针
 * @Return void
*/
void PrintList(PolyNode *head) {
    PolyNode *p = head->next;
    // 创建一个指针p，让它指向链表的第一个节点
    while (p) {
        // 当p指向的节点不为空时
        printf("%dx^%d", p->coefficient, p->exponent);
        // 输出节点的系数和指数
        if (p->next) {
            // 如果还有下一个节点
            printf("+");
            // 换行
        }
        p = p->next;
        // 将p指向下一个节点
    }
    printf("\n");
    // 输出一个换行符
}

/**
 * 连个多项式链表相加，不反回新链表，直接将结果保存在第1个链表中
 * @Param PolyNode* head1 第1个多项式链表的头指针
 * @Param PolyNode* head2 第2个多项式链表的头指针
 * @Return void
 * */
void Add(PolyNode *head1, PolyNode *head2) {
    PolyNode *p1 = head1->next;  // 第1个多项式指针
    PolyNode *p2 = head2->next;  // 第2个多项式指针
    PolyNode *p3 = head1;        // 缓冲指针，用于存储第一个多项式的当前节点的前一个节点

    while (p1 && p2) {
        if (p1->exponent == p2->exponent) {
            // 如果两个多项式的指数相等，将两个多项式的系数相加
            p1->coefficient = p1->coefficient + p2->coefficient;
            if (p1->coefficient == 0) {
                // 如果相加后的系数为0,将该节点从链表中删除
                p3->next = p1->next;
                free(p1);
                p1 = p3->next;
                p2 = p2->next;
            } else {
                // 如果相加后的系数不为0,继续遍历下一个节点
                p3 = p1;
                p1 = p1->next;
                p2 = p2->next;
            }
        } else if (p2->exponent < p1->exponent) {
            // 如果第2个多项式的指数小于第1个多项式的指数
            p3->next = p2;
            p2 = p2->next;
            p3->next->next = p1;
            p3 = p3->next;
        } else {
            // 如果第2个多项式的指数大于第1个多项式的指数，且小于p3的指数
            p3 = p1;
            p1 = p1->next;
        }
    }

    // 特殊情况处理：如果还有未遍历完的多项式
    if (p2) {
        p3->next = p2;
    }
}

int main() {
    SetConsoleOutputCP(65001);
    // 设置控制台输出编码为 UTF-8，避免中文乱码
    system("cls");
    // 清屏

    PolyNode *list1 = Init();
    PolyNode *list2 = Init();
    Add(list1, list2);
    // 创建一个链表并初始化
    PrintList(list1);
    // 打印链表
    return 0;
}