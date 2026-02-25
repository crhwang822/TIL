import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int W;
    public static int[][] events;
    public static int[][] dp;
    public static int[][] parent;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());

        events = new int[W + 1][2];
        dp = new int[W + 1][W + 1];
        parent = new int[W + 1][W + 1];

        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        for(int i = 0; i < W; i++)  {
            st = new StringTokenizer(br.readLine());
            events[i + 1] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        sb.append(dfs(0, 0));
        sb.append("\n");

        int a = 0, b = 0;
        for(int i=0; i<W;i++) {
            sb.append(parent[a][b]);
            sb.append("\n");

            if(parent[a][b] == 1) {
                a = i + 1;
            } else {
                b = i + 1;
            }
        }

        System.out.println(sb.toString());

    }

    public static int dfs(int a, int b) {
        int next = Math.max(a, b) + 1;

        if(next > W)
            return 0;

        if(dp[a][b] != -1)
            return dp[a][b];

        int tempX1 = a == 0? 1 : events[a][0];
        int tempY1 = a == 0? 1 : events[a][1];
        int tempX2 = b == 0? N : events[b][0];
        int tempY2 = b == 0? N : events[b][1];

        int value1 = dfs(next, b) + Math.abs(events[next][0] - tempX1) + Math.abs(events[next][1] - tempY1);
        int value2 = dfs(a, next) + Math.abs(events[next][0] - tempX2) + Math.abs(events[next][1] - tempY2);

        if(value1 > value2) {
            dp[a][b] = value2;
            parent[a][b] = 2;
        } else {
            dp[a][b] = value1;
            parent[a][b] = 1;
        }

        return dp[a][b];
    }
}