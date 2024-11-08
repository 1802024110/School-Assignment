#include <stdio.h>
#define N 10000
int a[N]; // 定义数组a，用于存储计算阶乘的结果

int main(int argc, char const *argv[])
{
    int n = 20; // 要计算的阶乘的数
    a[0] = 1; // 将数组a的第一位初始化为1，因为任何数的阶乘都是1的倍数
    int len = 1; // 定义数组a的长度为1
    int tmp, next; // 定义两个变量，用于存储阶乘的计算结果和进位值
    for (int i = 1; i <= n; i++) // 循环计算阶乘，从1到n
    {
        next = 0; // 将进位值初始化为0
        for (int j = 0; j < len; j++) // 逐位计算阶乘
        {
            tmp = a[j] * i + next; // 计算当前位的阶乘值，加上进位值
            a[j] = tmp % 10; // 将计算结果的个位数存储到数组a的当前位
            next = tmp / 10; // 将计算结果的十位数存储到进位值变量中，以便下一次计算使用
            if (j >= len - 1 && next > 0) // 判断是否需要动态增加数组a的长度
            {
                len++; // 当前数组a的最后一位已经计算完毕，但进位值不为0，说明需要再增加一位
            }
        }
    }
    for (int i = len - 1; i >= 0; i--) // 倒序输出数组a中的元素，以便得到正确的阶乘值
    {
        printf("%d", a[i]); // 输出当前位的数值
        if (i % 4 == 0 && i != 0) // 每输出5个数值，就在它们之间加上一个逗号，分组输出
            printf(",");
    }// 计算20的阶乘，并输出结果
    return 0;
}
