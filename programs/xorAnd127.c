#include <stdio.h>

int main() {
    char *str = "Hello World";
    char andResult[50];
    char xorResult[50];
    int i = 0;

    while (str[i] != '\0') {
        andResult[i] = str[i] & 127;
        xorResult[i] = str[i] ^ 127;
        i++;
    }

    andResult[i] = '\0';
    xorResult[i] = '\0';

    printf("Original String: %s\n", str);
    printf("AND with 127: %s\n", andResult);
    printf("XOR with 127: %s\n", xorResult);

    return 0;
}
