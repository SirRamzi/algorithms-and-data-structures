import java.util.Scanner;

/*
Хайвей
По шоссе едут машины. Шоссе однополосное, поэтому машины не могут обгонять друг друга. i-я машина едет перед 
(i+1)-й машиной и имеет максимальную скорость v_i. Если перед машиной едет машина с меньшей скоростью, 
то машина будет ехать медленнее, чтобы не врезаться.

Машины выстроились в последовательность и начали ехать. Определите, с какой скоростью будет ехать каждая машина.

Формат входных данных
В первой строке дано число n(1≤n≤10^5) — количество машин. Далее в n строках вводится по одному целому числу 
a_i(1<=a_i<=10^9) — скорость i-й машины.

Формат выходных данных
Выведите n чисел — скорость каждой машины на шоссе. 
 */

public class Highway {
    public static void vehicle_speed() {
        int n = 0;
        int[] vehicle_speed;
        try (Scanner in = new Scanner(System.in)) {
            n = in.nextInt();
            vehicle_speed = new int[n];
            for (int i = 0; i < vehicle_speed.length; i++) {
                vehicle_speed[i] = in.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Количество машин и их скорость являются целым числом.");
            return;
        }
        for (int i = 1; i < vehicle_speed.length; i++) {
            if (vehicle_speed[i] > vehicle_speed[i-1]) {
                vehicle_speed[i] = vehicle_speed[i-1];
            }
        }
        for (int i = 0; i < vehicle_speed.length; i++) {
            System.out.println(vehicle_speed[i]);
        }
    }
}
