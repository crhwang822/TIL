import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();
            int[] type = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10};
            int[] answer = new int[8];
            
            for(int i = 0; i < type.length; i++) {
                answer[i] = N / type[i];
                N %= type[i];
            }
            
            System.out.println("#" + testCase);
           	for(int i = 0; i < answer.length; i++)
                System.out.print(answer[i] + " ");
        	System.out.println();
        }
    }
}