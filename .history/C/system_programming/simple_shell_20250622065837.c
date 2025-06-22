#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

int main() {
    char command[256];
    while (1) {
        printf("mini-shell> ");
        fgets(comman, 256, stdin);
        system(command);
    }
}