import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int testCase = 1; testCase <= 10; testCase++) {
            int n = sc.nextInt();
            int answer = 0;
            int[] heights = new int[n];
            for(int i = 0; i < n; i++) {
                heights[i] = sc.nextInt();
            }
            
            for(int i = 2; i < n - 2; i++) {
                int leftMax = Math.max(heights[i - 2], heights[i - 1]);
                int rightMax = Math.max(heights[i + 1], heights[i + 2]);
                int max = Math.max(leftMax, rightMax);
                answer += Math.max(0, heights[i] - max);
            }
            
            System.out.println("#" + testCase + " " + answer);
            
        }
    }
}