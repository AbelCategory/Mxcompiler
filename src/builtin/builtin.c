#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <string.h>
#include <stdbool.h>

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
    printf("%s\n", s);
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
    char *ret = malloc(20);
    sprintf(ret, "%d", x);
    return ret;
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
    int res;
    sscanf(s, "%d", &res);
    return res;
}

int string_ord(char *s, int x) {    
    return s[x];
}

char *string_add(char *s1, char *s2) {
    char *ret = (char *) malloc(strlen(s1) + strlen(s2) + 1);
    strcpy(ret, s1);
    strcat(ret, s2);
    return ret;
}

bool string_eq(char *s1, char *s2) {
    return !strcmp(s1, s2);
}

bool string_neq(char *s1, char *s2) {
    return strcmp(s1, s2);
}

bool string_lt(char *s1, char *s2) {
    return strcmp(s1, s2) < 0;
}

bool string_le(char *s1, char *s2) {
    return strcmp(s1, s2) <= 0;
}

bool string_gt(char *s1, char *s2) {
    return strcmp(s1, s2) > 0;
}

bool string_ge(char *s1, char *s2) {
    return strcmp(s1, s2) >= 0;
}