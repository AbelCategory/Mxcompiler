#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <string.h>

int* array_malloc(int n) {
    int* arr = (int*) malloc(n * 4 + 4);
    arr[0] = n;
    return arr + 1;
}

int* class_malloc(int n) {
    int *ptr = (int*) malloc(n);
    return ptr;
}

void print(char *s) {
    printf("%s", s);
}

void println(char *s) {
    printf("%d\n", s);
}

void printInt(int n) {
    printf("%d", n);
}

void printlnInt(int n) {
    printf("%d\n", n);
}

int getInt() {
    int res;
    scanf("%d", &res);
    return res;
}

char *getString() {
    char *res = (char *) malloc(256);
    scanf("%s", res);
    return res;
}

char* toString(int x) {
    int len = 0, neg = 0, tl = 0;
    char *tmp = (char *) malloc(11);
    if(x < 0) x = -x, neg = 1;
    if(x == 0) tmp[len++] = 48;
    do {
        tmp[len++] = x % 10 + 48;
        x /= 10;
    } while(x);
    char *res = (char*) malloc(len + neg + 1);
    if(neg) res[tl++] = '-';
    do {
        res[tl++] = tmp[--len];
    } while(len);
    res[tl] = 0;
    return res;
}

int string_length(char *s) {
    return strlen(s);
}

char *string_substring(char *s, int l, int r) {
    char *res = (char *) malloc(r - l + 1);
    int len = 0;
    for(int i = l; i < r; ++i) {
        res[len++] = s[i];
    }
    res[len] = 0;
    return res;
}

int array_size(char *arr) {
    return *((int *) (arr - 4));
}

int string_parseInt(char *s) {
    int res = 0, neg = 0;
    if((*s) == '-') neg = 1;
    for(char *i = s; *i; ++i) {
        res = res * 10 + (*i) - 48;
    }
    if(neg) res = -res;
    return res;
}

int string_ord(char *s, int x) {    
    return s[x];
}