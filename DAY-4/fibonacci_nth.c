#include <stdio.h>

int main() {
    int n, i;
    long long a = 0, b = 1, next;

    printf("Enter the value of n: ");
    scanf("%d", &n);

    if (n == 1)
        printf("Nth Fibonacci term = %lld", a);
    else if (n == 2)
        printf("Nth Fibonacci term = %lld", b);
    else {
        for (i = 3; i <= n; i++) {
            next = a + b;
            a = b;
            b = next;
        }
        printf("Nth Fibonacci term = %lld", b);
    }

    return 0;
}
