import java.util.Scanner;

public class Solution {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        

        for(int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();
        	int M = sc.nextInt();
            
        	int[][] arr = new int[N][N];
            for(int i = 0; i < N; i++) 
                for(int j = 0; j < N; j++) 
                    arr[i][j] = sc.nextInt();
            
            int size = N - M + 1;
            int max = 0;
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    int temp = 0;
                    for(int a = 0; a < M; a++)
                        for(int b = 0; b < M; b++)
                            temp += arr[i + a][j +b];
                    max = Math.max(temp, max);
                }
            }
            
            System.out.println("#" + testCase + " " + max);
        }
        
    }
    
}