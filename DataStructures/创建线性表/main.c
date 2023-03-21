#include <stdio.h>
#include <malloc.h>
#include <windows.h>


#define MAXSIZE 100000
typedef char ElemType; //定义元素类型为字符型
typedef struct SqlList {
    ElemType Data[MAXSIZE]; //线性表元素存储数组
    int Length; //线性表长度
} *List;

// 创建线性表并且赋空值
List MakeEmpty() {
    List list;
    list = (List) malloc(sizeof(struct SqlList)); //分配线性表结构体空间
    list->Length = 0; //将线性表长度初始化为0
    return list; //返回线性表指针
}

int GetCapacity(List list) {
    return sizeof(list->Data) / sizeof(ElemType); //返回线性表存储数组的最大容量
}

int IsEmpty(List list) {
    if (list->Length == 0)
        return 1; //线性表为空，返回1
    else
        return 0; //线性表不为空，返回0
}

int Insert(List list, int index, ElemType data) {
    if (index < 0 || index > list->Length) return 0;
    for (int i = list->Length; i > index; i--) {
        list->Data[i] = list->Data[i - 1];
    }
    list->Data[index] = data;
    list->Length++;
    return 1;
}

void DispList(List list) {
    if (list->Length == 0) {
        printf("线性表为空\n");
    } else {
        for (int i = 1; i <= list->Length; i++) {
            printf("%c ", list->Data[i]);
        }
        printf("\n线性表的长度：%d\n", list->Length);
    }
}

int main() {
    SetConsoleOutputCP(65001); // 设置控制台输出编码为 UTF-8，避免中文乱码

    List list = MakeEmpty(); //创建一个空的线性表
    printf("线性表的长度：%d\n", list->Length); //输出线性表长度为0
    int capacity = GetCapacity(list); //获取线性表的最大容量
    printf("线性表的最大容量：%d\n", capacity); //输出线性表的最大容量

    Insert(list, 1, 'a'); //在第一个位置插入字符'a'
    Insert(list, 2, 'b'); //在第二个位置插入字符'b'
    Insert(list, 3, 'c'); //在第三个位置插入字符'c'
    DispList(list); //打印线性表中的元素和长度

    int isEmpty = IsEmpty(list); //判断线性表是否为空
    if (isEmpty == 1) {
        printf("线性表为空\n");
    } else {
        printf("线性表不为空\n");
    }

    return 0;
}