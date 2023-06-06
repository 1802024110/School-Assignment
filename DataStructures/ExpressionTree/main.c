#include <stdio.h>
#include <malloc.h>
#include <windows.h>

// 定义常量最大长度
int const MAXSIZE = 1000;

// 定义数据类型和二叉树结构体
typedef char DataType;
typedef struct node{
    DataType data;
    struct node *lchild;
    struct node *rchild;
}BitNode, *BiTree;

// 创建二叉树，参数为表达式字符串和起始、终止位置
BiTree create_Tree(char str[MAXSIZE],int start,int end){

    int i;
    int pos=-1;
    BiTree root;

    // 如果已经到达叶子节点，创建节点并返回
    if(end-start==1){
        root=(BiTree)malloc(sizeof(BitNode));
        root->data=str[start];
        root->lchild=root->rchild=NULL;
        return root;
    }

    // 根据运算符位置递归创建左右子树
    for(i=start;i<end;i++){
        if(str[i]=='+' || str[i]=='-')
            pos=i;
    }
    if  (pos==-1){
        for (i = start; i < end; i++) {
            if(str[i]=='*'||str[i]=='/')
                pos=i;
        }
    }
    root=(BiTree)malloc(sizeof(BitNode));
    root->data=str[pos];
    root->lchild=create_Tree(str,start,pos);
    root->rchild=create_Tree(str,pos+1,end);
    return root;
}

// 访问节点
void Visit(BiTree root){
    printf("%c ",root->data);
}

// 中序遍历，参数为根节点
void InOrder(BiTree root){
    if (root==NULL)
        return;
    InOrder(root->lchild);
    Visit(root);
    InOrder(root->rchild);
}

// 计算表达式结果，参数为根节点
int result(BiTree root){
    int res;
    if(root->lchild==NULL && root->rchild==NULL){
        res=(int)(root->data)-48;
        return res;
    }
    switch(root->data){
        case '+':
            return result(root->lchild)+result(root->rchild);
        case '-':
            return result(root->lchild)-result(root->rchild);
        case '*':
            return result(root->lchild)*result(root->rchild);
        case '/':
            return result(root->lchild)/result(root->rchild);
    }
    return res;
}

// 从标准输入中读取一个以 '#' 结尾的字符串
// 返回读取的字符串
char* read_expression() {
    // 分配 MAXSIZE 大小的缓冲区
    char* str = (char*)malloc(sizeof(char) * MAXSIZE);
    if (str == NULL) {
        printf("内存分配失败\n");
        exit(1);
    }

    // 提示用户输入表达式
    printf("请输入表达式(以#结束)： ");

    // 循环读入字符，直到读入 '#' 或达到最大长度
    int i;
    char ch;
    for (i = 0; i < MAXSIZE; i++) {
        scanf("%c", &ch);
        if (ch == '#')
            break;
        else
            str[i] = ch;
    }
    str[i] = '\0'; // 结尾添加 '\0'
    return str;
}

// 主函数
int main() {
    SetConsoleOutputCP(65001);

    // 读取表达式字符串
    char* str = read_expression();

    // 创建二叉树
    BiTree root = create_Tree(str, 0, strlen(str));

    // 中序遍历二叉树
    InOrder(root);

    // 输出表达式计算结果
    printf("计算结果：%d\n", result(root));

    // 释放缓冲区
    free(str);

    return 0;
}