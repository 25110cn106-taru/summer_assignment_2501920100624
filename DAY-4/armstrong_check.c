#include <stdio.h>
#include <math.h>

int main() {
    int num, temp, remainder, digits = 0;
    int result = 0;

    printf("Enter a number: ");
    scanf("%d", &num);

    temp = num;

    // Count digits
    while (temp != 0) {
        digits++;
        temp /= 10;
    }

    temp = num;

    // Calculate sum of digits raised to the power of digits
    while (temp != 0) {
        remainder = temp % 10;
        result += pow(remainder, digits);
        temp /= 10;
    }

    if (result == num)
        printf("%d is an Armstrong number.", num);
    else
        printf("%d is not an Armstrong number.", num);

    return 0;
}