import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testCase = 1; testCase <= T; testCase++) {
            int[][] matrix = new int[9][9];
            int answer = 1;
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix.length; j++) 
                   	matrix[i][j] = sc.nextInt();
            }
            
            //구간합 구하기
            int[][] psum = new int[10][10];
            for(int i = 1; i < psum.length; i++)
                for(int j = 1; j < psum.length; j++)
                    psum[i][j] = psum[i-1][j] + psum[i][j-1] - psum[i-1][j-1] + matrix[i-1][j-1];
            
            //가로 합 확인
            for(int i = 1; i < psum.length; i++)
                if(psum[i][9] - psum[i-1][9] != 45)
                    answer = 0;
            
            //세로 합 확인
            for(int j = 1; j < psum.length; j++)
                if(psum[9][j] - psum[9][j-1] != 45)
                    answer = 0;
            
            //격자합 확인
            for(int i = 3; i < psum.length; i += 3) 
                for(int j = 3; j < psum.length; j += 3)
                    if(psum[i][j] - psum[i-3][j] - psum[i][j-3] + psum[i-3][j-3] != 45)
                        answer = 0;
            
            System.out.println("#" + testCase + " " + answer);
            
            
            
        }
    }
}