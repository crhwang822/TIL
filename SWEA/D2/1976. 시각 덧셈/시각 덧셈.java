import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testCase = 1; testCase <= T; testCase++) {
            int h = sc.nextInt();
            int m = sc.nextInt();
            int plusH = sc.nextInt();
            int plusM = sc.nextInt();
            
           	plusH += (m+plusM) / 60;
            m = (m + plusM) % 60;
            h = (h + plusH) % 12 == 0? 12: (h+plusH) % 12;
            
            System.out.println("#" + testCase + " " + h + " " + m);
        }
    }
}