#include <stdio.h>;
#include <windows.h>;
#include "List.h";
/**
 * 将传入的第一个数组的第一个元素作为切分元素的条件，该元素置于新数组中间，大于该数组的置于右边，小于该数组的置于左边。
 * @param a 需要被切分的数组
 * @param b 被切分后的结果数组
 * @return int 成功1，失败0
 * */
int arraySplitting(List a, List b) {
    // 检查两个数组长度是否正确
    if (a->Length == 0 || a->Data[1] == NULL) {
        return 0;
    }

    // 复制输入数组到输出数组
    b->Length = a->Length;
    for (int i = 1; i <= a->Length; i++) {
        b->Data[i] = a->Data[i];
    }

    // 获取第一个元素作为切分条件
    ElemType first_index = a->Data[1];

    // 定义左右指针
    int left = 1, right = a->Length;

    // 遍历原数组
    for (int i = 1; i <= a->Length; i++) {
        if (a->Data[i] < first_index) {
            // 如果元素小于切分条件，则放在新数组的左边
            b->Data[left++] = a->Data[i];
        } else if (a->Data[i] > first_index) {
            // 如果元素大于切分条件，则放在新数组的右边
            b->Data[right--] = a->Data[i];
        }
    }

    // 将切分元素放在新数组中间
    b->Data[left] = first_index;

    // 返回成功
    return 1;
}

int main() {
    SetConsoleOutputCP(65001); // 设置控制台输出编码为 UTF-8，避免中文乱码
    system("cls"); //清屏

    List a = MakeEmpty();
    List b = MakeEmpty();
    Insert(a,1,'5');
    Insert(a,2,'3');
    Insert(a,3,'6');
    Insert(a,4,'5');
    Insert(a,5,'1');
    Insert(a,6,'8');
    Insert(a,7,'2');
    arraySplitting(a,b);
    DispList(b);
    return 0;
}
