import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testCase = 1; testCase <= T; testCase++) {
            int num = sc.nextInt();
            int answer = -1 * (num / 2);
            if(num % 2 == 1)
                answer += num;
            
            System.out.println("#" + testCase + " " + answer);
        }
    }
}