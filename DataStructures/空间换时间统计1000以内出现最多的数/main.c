#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <windows.h>

#define MAX 1000 //定义最大值

int main()
{
    SetConsoleOutputCP(65001); // 设置控制台输出编码为 UTF-8，避免中文乱码

    int arr[MAX];
    //定义一个数组，存放随机数
    int freq[MAX] = {0}; //定义一个数组，存放每个数的出现次数
    int max_freq = 0; //定义一个变量，存放最大的出现次数
    int most_freq = 0; //定义一个变量，存放出现次数最多的数

    //生成随机数并存入数组
    srand(time(NULL)); //设置随机种子
    for (int i = 0; i < MAX; i++)
    {
        arr[i] = rand() % MAX; //生成0到MAX-1之间的随机数
        // freq[arr[i]]++; //直接在生成时统计次数，更新对应的出现次数
    }
    printf("\n");

    // 另外统计次数
    for (int i = 0; i < MAX; i++) {
        freq[i] = 0;
        for (int j = 0; j < MAX; j++) {
            if (arr[i] == arr[j] ){
                freq[i]++;
            }
        }
    }

    //遍历出现次数数组，找出最大值和对应的索引
    for (int i = 0; i < MAX; i++)
    {
        if (freq[i] > max_freq)
        {
            max_freq = freq[i]; //更新最大值
            most_freq = i; //更新索引
        }
    }

    //打印结果
    printf("在1000以内出现次数最多的数是%d，它出现了%d次。\n", most_freq, max_freq);

    return 0;
}