#include <stdio.h>
char array[30000] = {0}; char *ptr = array;
int main() {
    char *program = "++>++.<."; // BF: increment, print
    for(int i = 0; program[i]; i++) {
        switch(program[i]) {
            case '>': ptr++; break;
            case '<': ptr--; break;
            case '+': ++*ptr; break;
            case '-': --*ptr; break;
            case '.': putchar(*ptr);break;
        }
    }
}