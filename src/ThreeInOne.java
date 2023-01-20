import java.util.ArrayList;
import java.util.List;

public class ThreeInOne {
    public static void equalSumSets() {
        int n = 8; // replace with desired value of n
        List<Integer> set1 = new ArrayList<>();
        List<Integer> set2 = new ArrayList<>();
        List<Integer> set3 = new ArrayList<>();
        int sum = (n * (n + 1)) / 2; // calculate sum of all natural numbers from 1 to n
        if (sum % 3 != 0) {
            System.out.println("Cannot divide into 3 sets with equal sums.");
            return;
        }
        int targetSum = sum / 3;
        int currentSum = 0;
        for (int i = n; i >= 1; i--) {
            if (currentSum + i <= targetSum) {
                currentSum += i;
                set1.add(i);
            } else if (currentSum + i <= targetSum * 2) {
                currentSum += i;
                set2.add(i);
            } else {
                set3.add(i);
            }
        }
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Set 3: " + set3);
    }
}
