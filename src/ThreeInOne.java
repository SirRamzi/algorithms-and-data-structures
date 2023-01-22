import java.util.Scanner;

public class ThreeInOne {
    // Helper method for computing the 3-partition problem.
    // If it returns true, then there exists three disjoint subsets with the sum
    public boolean disjointSubsetSum(int arr[], int size, int i, int j, int k, int store[]) {
        // return true if the subset is found
        if (i == 0 && j == 0 && k == 0) {
            return true;
        }

        // handling the base case: when no items are left
        if (size < 0) {
            return false;
        }

        // Case 1: The first subset contains the current element
        boolean c1 = false;
        if (i - arr[size] >= 0) {
            // keeping track of the current element. 1 means the first subset
            store[size] = 1;
            c1 = disjointSubsetSum(arr, size - 1, i - arr[size], j, k, store);
        }

        // Case 2: The second subset contains the current element
        boolean c2 = false;
        if (!c1 && (j - arr[size] >= 0)) {
            // keeping track of the current element. 2 means the second subset.
            store[size] = 2;
            c2 = disjointSubsetSum(arr, size - 1, i, j - arr[size], k, store);
        }

        // Case 3: The third subset contains the current element
        boolean c3 = false;
        if ((!c1 && !c2) && (k - arr[size] >= 0)) {
            // keeping track of the current element. 3 means the third subset.
            store[size] = 3;
            c3 = disjointSubsetSum(arr, size - 1, i, j, k - arr[size], store);
        }

        return (c1 || c2 || c3);
    }

    // method for computing the 3 partitions problem. It returns true if the given
    // set can be split into a set of three disjoint subsets with the equal sum.
    public boolean partitionInThree(int arr[], int store[]) {
        // it is obvious that for the three disjoint subsets
        // there have to be at least three elements present in the given array
        if (arr.length < 3) {
            return false;
        }
        // get the sum of all of the elements of the given array
        int sumOfEle = 0;
        for (int i = 0; i < arr.length; i++) {
            sumOfEle = sumOfEle + arr[i];
        }
        // return true if the sum of all the elements is divisible by 3 and
        // the input array can be divided into the three disjoint subsets with the equal
        // sum
        if ((sumOfEle % 3) == 0) {
            if (disjointSubsetSum(arr, arr.length - 1, sumOfEle / 3, sumOfEle / 3, sumOfEle / 3, store)) {
                return true;
            }
            return false;
        }
        return false;
    }

    void display(int arr[], int store[]) {
        // print the partitions
        int setSize;
        for (int j = 0; j < 3; j++) {
            setSize = 0;
            for (int m = 0; m < store.length; m++) {
                if (store[m] == j + 1) {
                    setSize++;
                }
            }

            System.out.println(setSize);
            for (int k = 0; k < arr.length; k++) {
                if (store[k] == j + 1) {
                    System.out.print(arr[k] + " ");
                }
            }
            System.out.println();
            System.out.println();
        }
    }

    // main method
    public static void main(String argvs[]) {
        int n = 0;
        int[] arr;
        try (Scanner in = new Scanner(System.in)) {
            n = in.nextInt();
            arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i + 1;
            }
        } catch (Exception e) {
            System.out.println("n должно быть целым числом");
            return;
        }
        // creating an object of the class
        ThreeInOne obj = new ThreeInOne();
        // for storing the elements of the disjoint subsets
        int[] store = new int[arr.length];
        if (obj.partitionInThree(arr, store)) {
            obj.display(arr, store);
        } else {
            System.out.println("-1");
        }
    }
}
