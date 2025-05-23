import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testCase = 1; testCase <= T; testCase++) {
            int commands = sc.nextInt();
            int d = 0;
            int v = 0;
            for(int i = 0; i < commands; i++) {
                int command = sc.nextInt();
                switch(command) {
                    case 1:
                        v += sc.nextInt();
                        break;
                    case 2: 
                        v = Math.max(0, v - sc.nextInt());
                        break;
                }
                d += v;
            }
            System.out.println("#" + testCase + " " + d);
        }
    }
}