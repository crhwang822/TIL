import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int testCase = 1; testCase <= T; testCase++) {
            String[] str = sc.nextLine().split("");
            int answer = 1;
            
            for(int i = 0; i < str.length / 2; i++) {
                if(!str[i].equals(str[str.length - i - 1])) {
                    answer = 0;
                    break;
                }
            }
                   
            System.out.println("#" + testCase + " " + answer);
        }
    }
}