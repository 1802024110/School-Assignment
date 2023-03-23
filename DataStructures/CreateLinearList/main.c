#include <windows.h>
#include <stdio.h>
#include <malloc.h>

#define MAXSIZE 100000
typedef char ElemType; //定义元素类型为字符型
typedef struct SqlList {
    ElemType Data[MAXSIZE]; //线性表元素存储数组
    int Length; //线性表长度
} *List;

/**
 * @brief 创建线性表并且赋空值
 * @return 返回线性表指针
 */
List MakeEmpty() {
    List list;
    list = (List) malloc(sizeof(struct SqlList)); //分配线性表结构体空间
    list->Length = 0; //将线性表长度初始化为0
    return list; //返回线性表指针
}

/**
 * @brief 获取线性表的最大容量
 * @param list 线性表指针
 * @return 返回线性表存储数组的最大容量
 */
int GetCapacity(List list) {
    return sizeof(list->Data) / sizeof(ElemType); //返回线性表存储数组的最大容量
}

/**
 * @brief 判断线性表是否为空
 * @param list 需要判断的线性表
 * @return 0失败，1成功
 */
int IsEmpty(List list) {
    if (list->Length == 0)
        return 1; //线性表为空，返回1
    else
        return 0; //线性表不为空，返回0
}

/**
 * @brief 在指定位置插入元素
 * @param list 需要插入元素的线性表
 * @param index 需要插入元素的位置
 * @param data 需要插入的元素值
 * @return 0失败，1成功
 */
int Insert(List list, int index, ElemType data) {
    if (index < 1 || index > list->Length + 1) return 0; //插入位置不合法，返回0
    if (list->Length == MAXSIZE) return 0; //线性表已满，返回0
    if (index == 1) { //插入第一个元素
        for (int i = list->Length; i > 0; i--) { //从后向前遍历
            list->Data[i] = list->Data[i - 1]; //将后面元素后移
        }
        list->Length++; //线性表长度增1
        list->Data[1] = data; //插入元素
    } else if (index == list->Length + 1) { //插入最后一个元素
        list->Data[index - 1] = data; //插入元素
        list->Length++; //线性表长度增1
    } else {
        for (int i = list->Length - 1; i >= index - 1; i--) { //从后向前遍历
            list->Data[i + 1] = list->Data[i]; //将后面元素后移
        }
        list->Data[index - 1] = data; //插入元素
        list->Length++; //线性表长度增1
    }
    return 1; //返回1
}

/**
 * @brief 打印线性表中的元素和长度
 * @param list 需要打印的线性表
 */
void DispList(List list) {
    if (list->Length == 0) {
        printf("线性表为空\n");
    } else {
        for (int i = 1; i <= list->Length; i++) {
            printf("%c, ", list->Data[i]);
        }
        printf("线性表的长度：%d\n", list->Length);
    }
}

/**
 * @brief 删除指定位置的元素
 * @param list 需要删除元素的线性表
 * @param index 需要删除元素的位置
 * @return 0失败，1成功
 */
int Delete(List list, int index) {
    if (index < 1 || index > list->Length) {
        return 0;
    }
    for (int i = index; i < list->Length; i++) {
        list->Data[i - 1] = list->Data[i];
    }
    list->Length--;
    return 1;
}

/**
 * @brief 获取指定位置的元素值
 * @param list 需要获取元素的线性表
 * @param index 需要获取元素的位置
 * @return 返回指定位置的元素，如果获取失败返回'\0'
 */
ElemType getElem(List list, int index) {
    if (index < 1 || index > list->Length) {
        return '\0'; //返回空字符表示获取失败
    }
    return list->Data[index]; //返回指定位置的元素
}

/**
 * 在线性表中更新指定位置的元素
 *
 * @param list 线性表指针
 * @param index 更新的位置
 * @param data 新的元素值
 * @return 更新成功返回1，否则返回0
 */
int Update(List list, int index, ElemType data) {
    if (index < 1 || index > list->Length) {
        return 0; //更新位置不合法，返回0表示更新失败
    }
    list->Data[index] = data; //更新指定位置的元素
    return 1; //返回1表示更新成功
}

/**
 * 在线性表中查找指定元素的位置
 *
 * @param list 线性表指针
 * @param data 要查找的元素值
 * @return 元素在线性表中的位置，如果不在线性表中返回0
 */
int Locate(List list, ElemType data) {
    for (int i = 1; i <= list->Length; i++) {
        if (list->Data[i] == data) {
            return i; //返回元素在线性表中的位置
        }
    }
    return 0; //返回0表示元素不在线性表中
}

int main(void) {
    SetConsoleOutputCP(65001); // 设置控制台输出编码为 UTF-8，避免中文乱码
    system("cls"); //清屏
    // 初始化线性表
    List list = MakeEmpty();
    char choose = ' ';

    while (1) {

        printf("=============================================\n");
        printf("1.显示当前顺序表\n"
               "2.为顺序表添加元素\n"
               "3.删除顺序表中的元素\n"
               "4.修改顺序表中的元素\n"
               "5.查找顺序表中指定位置的元素\n"
               "6.查找顺序表中等于的元素\n"
               "0.退出\n");
        printf("=============================================\n");
        printf("请输入你的选择：");
        scanf("%c", &choose);
        getchar(); // 捕获缓冲区指针，防止按键阻塞
        int index = 0;
        char value = ' ';
        int succeed = 0;
        switch (choose) {
            case '1':
                // 显示当前线性表的所有值
                DispList(list);
                succeed = 2;
                break;
            case '2':
                printf("请输入新元素的下标");
                scanf("%d", &index);
                getchar(); // 读取缓冲区中的换行符

                printf("请输入新元素的值");
                scanf("%c", &value);
                getchar(); // 读取缓冲区中的换行符

                succeed = Insert(list, index, value);
                break;
            case '3':
                printf("请输入要删除元素的下标");
                scanf("%d", &index);
                getchar(); // 读取缓冲区中的换行符


                succeed = Delete(list, index);
                break;
            case '4':
                printf("请输入更新元素的下标");
                scanf("%d", &index);
                getchar(); // 读取缓冲区中的换行符


                printf("请输入更新元素的值");
                scanf("%c", &value);
                getchar(); // 读取缓冲区中的换行符


                succeed = Update(list, index, value);
                break;
            case '5':
                printf("请输入要查找元素的下标");
                scanf("%d", &index);
                getchar(); // 读取缓冲区中的换行符


                ElemType elemType = getElem(list, index);
                if (elemType == NULL) {
                    printf("查找失败");
                } else {
                    succeed = 2;
                    printf("该元素的值为%c\n", elemType);
                }
                break;
            case '6':
                printf("请输入要查找元素的值");
                scanf("%c", &value);
                getchar(); // 读取缓冲区中的换行符

                index = Locate(list,value);
                if (index != NULL){
                    printf("查找元素的下标是：%d\n", index);
                    succeed = 2;
                } else{
                    succeed = 0;
                }
                break;
            case '0':
                return 0;
            default:
                printf("未知选择\n");
                break;
        }
        if (succeed == 1) {
            printf("操作成功!\n");
        }else if(succeed == 2){}
        else {
            printf("操作失败!\n");
        }
    }
}