import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    public static ArrayList<Integer>[] tree;
    public static int[][] dp;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        for(int i = 1; i < tree.length; i++)
            tree[i] = new ArrayList<>();
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];

        int a, b;
        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(1);


        bw.write(Math.min(dp[1][0], dp[1][1]) + "");
        bw.close();
    }

    public static void dfs(int num) {
        visited[num] = true;
        dp[num][1] = 1;

        for(int n : tree[num]) {
            if(!visited[n]) {
                dfs(n);
                dp[num][0] += dp[n][1];
                dp[num][1] += Math.min(dp[n][1], dp[n][0]);
            }
        }
    }
}
