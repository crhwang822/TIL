import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testCase = 1; testCase <= T; testCase++) {
            int[] number = new int[]{2,3,5,7,11};
            int[] answer = new int[5];
            int n = sc.nextInt();
            
            for(int i = 0; i < number.length; i++) {
                while(n % number[i] == 0) {
                	answer[i]++;
                	n /= number[i];
            	}
            }
            
            System.out.print("#" + testCase);
            for(int i = 0; i < answer.length; i++)
                System.out.print(" " + answer[i]);
            System.out.println();
        }
    }
}