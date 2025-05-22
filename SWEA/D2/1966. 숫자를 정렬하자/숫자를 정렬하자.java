import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i = 0; i < arr.length; i++)
                arr[i] = sc.nextInt();
            Arrays.sort(arr);
            System.out.print("#" + testCase + " ");
            for(int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
}