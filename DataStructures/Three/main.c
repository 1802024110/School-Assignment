#include <stdio.h>
#include <malloc.h>
#include <windows.h>
typedef int DataType;
typedef struct node {
    // 数据域
    DataType data;
    // 左右子树
    struct node *lchild, *rchild;
} BitNode, *BiTree;

/** 初始化树
 * */
BiTree Init(){
    BiTree root = NULL;
    return root;
}

/** 使用左右子树创建树
 * */
BiTree Create(DataType data, BiTree lchild, BiTree rchild){
    BiTree p = (BiTree)malloc(sizeof(BitNode));
    if(p == NULL){
        printf("malloc错误\n");
        return NULL;
    }
    p->data = data;
    p->lchild = lchild;
    p->rchild = rchild;
    return p;
}

/** 添加节点 x的左子树
 * */
BiTree InsertLeft(BiTree root,DataType x, BiTree Parent){
    BiTree p = (BiTree)malloc(sizeof(BitNode));
    if(p == NULL){
        printf("malloc错误\n");
        return NULL;
    }
    p->data = x;
    p->lchild = NULL;
    p->rchild = NULL;
    if(Parent->lchild == NULL){
        Parent->lchild = p;
    }else{
        p->lchild = Parent->lchild;
        Parent->lchild = p;
    }
    return root;
}

/** 添加节点 x的右子树
 * */
BiTree InsertRight(BiTree root,DataType x, BiTree rchild){
    BiTree p = (BiTree)malloc(sizeof(BitNode));
    if(p == NULL){
        printf("malloc error\n");
        return NULL;
    }
    p->data = x;
    p->lchild = NULL;
    p->rchild = NULL;
    if(rchild->rchild == NULL){
        rchild->rchild = p;
    }else{
        p->rchild = rchild->rchild;
        rchild->rchild = p;
    }
    return root;
}

/** 删除节点 x的左子树
 * */
BiTree DeleteLeft(BiTree root, BiTree Parent){
    if(Parent->lchild == NULL || Parent == NULL){
        printf("删除错误\n");
        return root;
    }
    BiTree p = Parent->lchild;
    Parent->lchild = p->lchild;
    free(p);
    return root;
}

/** 删除节点 x的右子树
 * */
BiTree DeleteRight(BiTree root, BiTree rchild){
    if(rchild->rchild == NULL || rchild == NULL){
        printf("删除错误\n");
        return root;
    }
    BiTree p = rchild->rchild;
    rchild->rchild = p->rchild;
    free(p);
    return root;
}

/** 先序遍历
 * */
void PreOrder(BiTree root){
    if(root == NULL){
        return;
    }
    printf("%d ", root->data);
    PreOrder(root->lchild);
    PreOrder(root->rchild);
}

/** 中序遍历
 * */
void InOrder(BiTree root){
    if(root == NULL){
        return;
    }
    InOrder(root->lchild);
    printf("%d ", root->data);
    InOrder(root->rchild);
}

/** 后序遍历
 * */
void LastOrder(BiTree root){
    if(root == NULL){
        return;
    }
    LastOrder(root->lchild);
    LastOrder(root->rchild);
    printf("%d ", root->data);
}


int main() {
    SetConsoleOutputCP(65001); // 设置控制台输出编码为 UTF-8，避免中文乱码
    BiTree root = Init();
    root = Create(1, NULL, NULL);
    BiTree t = root;
    InsertLeft(root, 2, t);
    printf("先序遍历：");
    PreOrder(root);
    printf("\n");
    printf("中序遍历：");
    InOrder(root);
    printf("\n");
    printf("后序遍历：");
    LastOrder(root);
    printf("\n");

    InsertRight(root, 3, t);
    printf("先序遍历：");
    PreOrder(root);
    printf("\n");
    printf("中序遍历：");
    InOrder(root);
    printf("\n");
    printf("后序遍历：");
    LastOrder(root);
    printf("\n");
    return 0;
}
