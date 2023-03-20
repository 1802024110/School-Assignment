#include <stdio.h>
#include <windows.h>
#include <ctype.h>  // 包含 isalpha() 函数的头文件

#define N 10001  // 定义输入字符串的最大长度为10001

char sentence[N]; // 存储输入字符串的字符数组
int worldCount = 0; // 单词计数器

int main() {
    SetConsoleOutputCP(65001); // 设置控制台输出编码为 UTF-8，避免中文乱码
    printf("请输入一个英文句子："); // 提示用户输入英文句子

    fgets(sentence, N, stdin); // 从标准输入中读取一行字符串，最多读取 N-1 个字符

    for (int i = 0; sentence[i] != '\0'; i++) { // 遍历输入字符串
        if (isspace(sentence[i])) { // 如果当前字符是空白字符，说明一个单词结束了
            worldCount++; // 单词计数器加一
        }
    }
    printf("输入的句子中有%d个单词。\n", worldCount); // 输出单词数量
    return 0; // 程序结束
}
