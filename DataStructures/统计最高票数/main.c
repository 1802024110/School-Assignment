#include <stdio.h>
#include <string.h>
#include <windows.h>

// 定义一个结构体表示一个人
struct person {
    char name[10]; // 姓名
    int ticket; // 票数
};

// 定义一个常量表示参与投票的人数
#define NUM 3

int main() {
    SetConsoleOutputCP(65001); // 设置控制台输出编码为 UTF-8，避免中文乱码
    SetConsoleCP(65001); // 设置控制台输入编码为 UTF-8

    // 定义一个包含三个人的结构体数组，并初始化票数为0
    struct person people[NUM] = {{"Tom", 0}, {"wangwu", 0}, {"Jsery", 0}};

    // 循环NUM次接收用户输入的名字和票数
    for (int i = 0; i < NUM; i++) {
        // 接收用户输入名字
        printf("请输入姓名：");
        char input_name[10];
        scanf("%s", input_name);

        // 遍历数组找到匹配项并增加票数
        for (int j = 0; j < NUM; j++) {
            if (strcmp(people[j].name, input_name) == 0) {
                people[j].ticket++;
                break; // 找到匹配项后退出循环
            }
        }
    }

    // 定义一个变量用来存储最多票数，并初始化为0
    int max_ticket = 0;

    // 定义一个变量用来存储最多票数对应的姓名，并初始化为空字符串
    char winner_name[10] = "";

    // 循环遍历数组找出最多票数和姓名
    for (int i = 0; i < NUM; i++) {
        if (people[i].ticket > max_ticket) {
            max_ticket = people[i].ticket;
            strcpy(winner_name, people[i].name);
        }

        // 输出每个人的姓名和票数
        printf("姓名：%s 票数：%d\n", people[i].name, people[i].ticket);
    }


    // 输出最多投票的姓名和票数
    printf("最多投票的是：%s 票数：%d\n", winner_name, max_ticket);

    return 0;
}