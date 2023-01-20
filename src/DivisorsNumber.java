import java.util.Scanner;

public class DivisorsNumber {
    public static void findX() {
        int n;
        try (Scanner in = new Scanner(System.in)) {
            n = in.nextInt();
        } catch (Exception e) {
            System.out.println("Вы указали не число.");
            return;
        }
        int maxDivisors = 0;
        int x = 0;
        for (int i = 1; i <= n; i++) {
            int divisors = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    divisors++;
                }
            }
            if (divisors >= maxDivisors) {
                maxDivisors = divisors;
                x = i;
            }
        }
        System.out.printf("%d\n%d", x, maxDivisors);
    }
}
