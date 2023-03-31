//
// Created by 18020 on 2023/3/29.
//

#ifndef C_LIST_H
#define C_LIST_H
#define MAXSIZE 100000
typedef char ElemType; //定义元素类型为字符型
typedef struct SqlList {
    ElemType Data[MAXSIZE]; //线性表元素存储数组
    int Length; //线性表长度
} *List;

int GetLength(const List list);
List MakeEmpty();
int GetCapacity(const List list);
int IsEmpty(const List list);
int Insert(List list, int position, ElemType elem);
void DispList(const List list);
int Delete(List list, int position);
ElemType GetElem(const List list, int position);
int Update(List list, int position, ElemType elem);
int Locate(const List list, ElemType elem);
void MargetList(List A, List B, List C);
ElemType GetElem(const List list, int position);
void Common(const List list1, const List list2);
void Asc_Common(List A, List B, List C);
void Asc_List(List a,List b);
#endif //C_LIST_H
