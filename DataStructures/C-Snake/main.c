#include <stdio.h>
#include <windows.h>
#include <conio.h>
#include <stdlib.h>
#include <time.h>

enum Direction {
    UP, DOWN, LEFT, RIGHT
};

struct Snake {
    int x;
    int y;
    struct Snake* next;
};

struct Serpent {
    enum Direction dir;
    int length;
};

struct Food {
    int x;
    int y;
};

struct Snake* head, * tail;
struct Food* food;
struct Serpent* serpent;
int food_eaten = 0;

void Gotoxy(int x, int y) {
    COORD pos;
    pos.X = x - 1;
    pos.Y = y - 1;
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), pos);
}

void Initsnake() {
    int i;
    head = tail = (struct Snake*)malloc(sizeof(struct Snake));
    head->next = NULL;
    food = (struct Food*)malloc(sizeof(struct Food));
    serpent = (struct Serpent*)malloc(sizeof(struct Serpent));
    serpent->dir = RIGHT;
    serpent->length = 2;
    for (i = 0; i < serpent->length; i++)
        Addtail(10 + i, 10);
    Initfood();
}

void Home() {
    int a;
    for (a = 0; a < 31; a++)
        printf("%c", 3);
    printf("\n");
    for (a = 0; a < 16; a++)
        printf("%c                             %c\n", 3, 3);
    for (a = 0; a < 31; a++)
        printf("%c", 3);
}

void Initfood() {
    int retry_count = 0;
    food_eaten = 0;
    struct Snake* q = head;
    srand((unsigned)time(NULL));
    food->x = rand() % (30 - 2) + 2;
    food->y = rand() % (15 - 2) + 2;
    while (q != tail) {
        if (q->x == food->x && q->y == food->y) {
            if (retry_count < 10) {
                retry_count++;
                Initfood();
            }
            else {
                printf("食物超过10次生成在身体上，请重新开始游戏\n");
                return;
            }
        }
        q = q->next;
    }
}

void Keyhit() {
    char n;
    if (_kbhit()) {
        n = _getch();
        switch (n) {
            case 'w':
                serpent->dir = (serpent->dir != DOWN) ? UP : serpent->dir;
                break;
            case 's':
                serpent->dir = (serpent->dir != UP) ? DOWN : serpent->dir;
                break;
            case 'a':
                serpent->dir = (serpent->dir != RIGHT) ? LEFT : serpent->dir;
                break;
            case 'd':
                serpent->dir = (serpent->dir != LEFT) ? RIGHT : serpent->dir;
                break;
        }
    }
}

void Move() {
    int a = 0;
    struct Snake* p;
    struct Snake* q;
    p = tail;
    switch (serpent->dir) {
        case UP:
            Addtail(p->x, p->y - 1);
            break;
        case DOWN:
            Addtail(p->x, p->y + 1);
            break;
        case LEFT:
            Addtail(p->x - 1, p->y);
            break;
        case RIGHT:
            Addtail(p->x + 1, p->y);
            break;
    }
    if (tail->x == food->x && tail->y == food->y) {
        serpent->length++;
        food_eaten = 1;
    }
    if (food_eaten != 1)
        clearhead();
    p = tail;
    q = head;
    while (q != tail) {
        if (q->x == p->x && q->y == p->y) {
            printf("\n撞到自己了");
            Sleep(3000);
            exit(0);
        }
        else {
            q = q->next;
        }
    }

    if (tail->x > 30 || tail->y > 17 || tail->x <= 1 || tail->y <= 1) {
        printf("\n撞到了墙壁");
        Sleep(3000);
        exit(0);
    }
}

void Addtail(int x, int y) {
    struct Snake* newnode = (struct Snake*)malloc(sizeof(struct Snake));
    newnode->x = x;
    newnode->y = y;
    newnode->next = NULL;
    tail->next = newnode;
    tail = newnode;
}

void clearhead() {
    struct Snake* p;
    p = head;
    p = p->next;
    head = p;
}

void Print() {
    // 获取标准输出的句柄
    HANDLE consoleOutput = GetStdHandle(STD_OUTPUT_HANDLE);

    Gotoxy(1, 1);
    // 设置字符的颜色为红色
    SetConsoleTextAttribute(consoleOutput, FOREGROUND_RED);
    Home();
    Gotoxy(food->x, food->y);

    // 设置字符的颜色为绿色
    SetConsoleTextAttribute(consoleOutput, FOREGROUND_GREEN);
    printf("%c", 4);
    struct Snake* q;
    q = head;
    while (q != NULL) {
        Gotoxy(q->x, q->y);
        // 设置字符的颜色为蓝色
        SetConsoleTextAttribute(consoleOutput, FOREGROUND_BLUE);
        printf("%c", 2);
        q = q->next;
    }
    if (food_eaten == 1)
        Initfood();
    Gotoxy(30, 20);
    // 恢复默认的字符颜色

    printf("成绩 :%d", serpent->length - 2);
}

int main() {
    Initsnake();
    while (1) {
        Keyhit();
        Move();
        system("cls");
        Print();
        Sleep(100);
    }
}
