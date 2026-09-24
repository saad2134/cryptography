#include <stdio.h>

int main() {
    char *str = "Hello World";
    char result[50];
    int i = 0;

    while (str[i] != '\0') {
        result[i] = str[i] ^ 0;
        i++;
    }

    result[i] = '\0';

    printf("Original String: %s\n", str);
    printf("XOR with 0 Result: %s\n", result);

    return 0;
}
