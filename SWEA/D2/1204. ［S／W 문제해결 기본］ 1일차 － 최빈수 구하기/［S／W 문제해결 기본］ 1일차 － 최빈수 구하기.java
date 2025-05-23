import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testCase = 1; testCase <= T; testCase++) {
            int num = sc.nextInt();
            sc.nextLine();
            int[] count = new int[101];
            String[] scores = sc.nextLine().split(" ");
            int max = 100;
            for(String score : scores) {
                int s = Integer.parseInt(score);
                count[s]++;
                if(count[s] > count[max] || (count[s] == count[max] && s > max))
                    max = s;
            }
            System.out.println("#" + num + " " + max);
        }
    }
}