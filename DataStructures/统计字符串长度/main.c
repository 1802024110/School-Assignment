#include <stdio.h>
#include <windows.h>
#include <locale.h> // 加上这一行
// 定义一个函数，它接受一个 UTF-8 编码的字符串作为参数，并返回它的长度
int string_length(char *str) {
    // 初始化一个变量来存储长度
    int len = 0;
    // 循环遍历字符串的字节，直到遇到空字符
    while (str[len] != '\0') {
        // 检查当前字节是否是 UTF-8 的首字节
        if ((str[len] & 0x80) == 0 || (str[len] & 0xC0) == 0xC0) {
            // 对每个首字节，长度加一
            len++;
        }
        // 移动到下一个字节
        str++;
    }
    // 返回长度
    return len;
}

// 测试函数，用一些例子
int main() {

    setlocale(LC_ALL, "en_US.UTF-8"); // 设置区域设置以支持 UTF-8

    // 声明一些字符串
    char *s1 = "Hello";
    char *s2 = "World";

    // 使用函数打印字符串的长度
    printf("The length of '%s' is %d\n", s1, string_length(s1));
    printf("The length of '%s' is %d\n", s2, string_length(s2));

    return 0;
}