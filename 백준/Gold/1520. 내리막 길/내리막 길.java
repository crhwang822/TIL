import java.io.*;
import java.util.*;

public class Main {

    public static int[][] map;
    public static int[][] dp;
    public static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        map = new int[m][n];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);
        dp[0][0]  = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});

        int nr;
        int nc;
        int[] cur;

        dfs(m - 1, n - 1);


        bw.write(String.valueOf(dp[m-1][n-1]));
        bw.close();
    }

    public static void dfs(int r, int c) {
        dp[r][c] = 0;
        for(int i = 0; i < 4; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length)
                continue;
            if(map[r][c] < map[nr][nc]) {
                if(dp[nr][nc] == -1)
                    dfs(nr, nc);
                dp[r][c] += dp[nr][nc];
            }
        }
    }

}