import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testCase = 1; testCase <= T; testCase++) {
            int n = sc.nextInt();
            int count = 0;
            boolean[] visited = new boolean[10];
            int visitCount = 0;
            while(visitCount < 10) {
                count++;
                long result = n * count;
                while(result > 0) {
                    int num = (int)(result % 10);
                    if(!visited[num]) {
                        visited[num] = true;
                        visitCount++;
                    }
                    result /= 10;
                }
            }
            System.out.println("#" + testCase + " " + n * count);
        }
    }
}