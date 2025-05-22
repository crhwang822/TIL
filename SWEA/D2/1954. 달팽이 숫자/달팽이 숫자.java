import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testCase = 1; testCase <= T; testCase++) {
            int n = sc.nextInt();
            int[][] dir = new int[][]{{0,1}, {1, 0}, {0,-1}, {-1,0}};
            int[][] answer = new int[n][n];
            int x = 0,  y = 0;
            int currentDirection = 0;
            
            for(int i = 1; i <= n * n; i++) {
                answer[x][y] = i;
                
                int nx = x + dir[currentDirection][0];
                int ny = y + dir[currentDirection][1];
                if( nx == n || nx == -1 ||  ny == n || ny == -1 || answer[nx][ny] != 0)
                    currentDirection = (currentDirection + 1) % 4;
                x += dir[currentDirection][0];
                y += dir[currentDirection][1];
            }
            
            //출력
            System.out.println("#" + testCase);
            for(int i = 0; i < answer.length; i++) {
                for(int j = 0; j < answer[0].length; j++)
                    System.out.print(answer[i][j] + " ");
                System.out.println();
            }
        }
    }
}