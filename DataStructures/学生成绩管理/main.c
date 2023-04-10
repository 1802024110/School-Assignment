#include <stdio.h>
#include <windows.h>


#define N 5 //定义学生人数为5

//定义结构体类型student
struct student
{
    int id; //学号
    char name[20]; //姓名
    int chinese; //语文成绩
    int math; //数学成绩
};

int main()
{
    SetConsoleOutputCP(65001); // 设置控制台输出编码为 UTF-8，避免中文乱码

    struct student stu[N]; //定义结构体数组stu存储学生信息
    int i; //循环变量

    printf("请输入%d个学生的信息（学号 姓名 语文成绩 数学成绩）：\n", N);
    for (i = 0; i < N; i++)
    {
        scanf("%d %s %d %d", &stu[i].id, stu[i].name, &stu[i].chinese, &stu[i].math); //从键盘输入学生信息
    }

    printf("两门课程成绩都及格的学生有：\n");
    for (i = 0; i < N; i++)
    {
        if (stu[i].chinese >= 60 && stu[i].math >= 60) //判断两门课程是否都及格
        {
            printf("学号：%d 姓名：%s\n", stu[i].id, stu[i].name); //输出及格的学生的学号和姓名
        }
    }

    return 0;
}