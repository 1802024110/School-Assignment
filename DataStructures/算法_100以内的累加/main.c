#include <stdio.h>
int fun1(int start,int end){
    int result;
    for (int i = start; i <= end; i++) {
        result += i;
    }
    return result;
}

int fun2(int start,int end){
    return (start + end) * end / 2;
}

int fun3(int start,int end){
    int a[100]  = {0};
    a[start] = 1;
    int result = 1;
    for (int i = start + 1; i <= end; i++) {
        result *= i;
        a[i] = result;
        result = 1;
    }
    return a[end];
}

int main() {
    int result ;
    result = fun2(1,100);
    printf("result= %d",result);
    return 0;
}
