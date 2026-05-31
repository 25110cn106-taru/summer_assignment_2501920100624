#include <stdio.h>
#include <math.h>

int main() {
    int start, end, num, temp, digit, digits;
    int sum;

    printf("Enter the starting number: ");
    scanf("%d", &start);

    printf("Enter the ending number: ");
    scanf("%d", &end);

    printf("Armstrong numbers between %d and %d are:\n", start, end);

    for (num = start; num <= end; num++) {
        temp = num;
        digits = 0;
        sum = 0;

        // Count digits
        while (temp != 0) {
            digits++;
            temp /= 10;
        }

        temp = num;

        // Calculate sum of powers of digits
        while (temp != 0) {
            digit = temp % 10;
            sum += pow(digit, digits);
            temp /= 10;
        }

        if (sum == num)
            printf("%d ", num);
    }

    return 0;
}