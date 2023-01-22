import java.util.Scanner;

/*
Задание 4

Число делителей

Гениальный программист Райк Мосс ведет архив всех решенных задач. В его архиве n задач. Сегодня ему попалась 
на глаза задача, которую он уже видел раньше. К сожалению, гениальный программист забыл решение, поэтому хочет 
найти задачу в архиве.

Райк помнит, что задача имеет номер x в его архиве, обладающий такими свойствами:
1. 1≤x≤n,x целое число
2. x имеет максимальное число положительных целых делителей среди всех чисел от 1 до n.
3. Среди всех чисел, которые удовлетворяют пунктам 1 и 2 х является максимальным

Найдите x, чтобы Райк смог найти нужную запись в архиве. 
*/

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
