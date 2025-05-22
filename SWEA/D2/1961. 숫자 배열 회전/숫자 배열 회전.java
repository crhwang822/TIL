import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            for(int i = 0; i < matrix.length; i++)
                for(int j = 0; j < matrix.length; j++)
                    matrix[i][j] = sc.nextInt();
            
            int[][] arr1 = new int[N][N];
            int[][] arr2 = new int[N][N];
            int[][] arr3 = new int[N][N];
            
            //90도 회전
            for(int j = 0; j < N; j++)
                for(int i = N - 1; i >= 0; i--)
                    arr1[j][N - 1 - i] = matrix[i][j];
            
            //180도 회전
            for(int i = N - 1; i >= 0; i--)
                for(int j = N - 1; j >= 0; j--)
                    arr2[N - 1 -  i][N - 1 - j] = matrix[i][j];
            
            //270도 회전
            for(int j = N - 1; j >= 0; j--)
                for(int i = 0; i < N; i++)
                    arr3[N - 1 - j][i] = matrix[i][j];
            
            //출력
            System.out.println("#" + testCase);
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++)
                    System.out.print(arr1[i][j]);
                System.out.print(" ");
                for(int j = 0; j < N; j++)
                    System.out.print(arr2[i][j]);
                System.out.print(" ");
                for(int j = 0; j < N; j++)
                    System.out.print(arr3[i][j]);
                System.out.println();
            }
        }
    }
}