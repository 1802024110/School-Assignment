#include <stdio.h>
#include <windows.h>
#include "List.h"
int main() {
    SetConsoleOutputCP(65001); // 设置控制台输出编码为 UTF-8，避免中文乱码
    system("cls"); //清屏

    LinkList L1 = Create_Head();

    DispList(L1);
    return 0;
}
