import java.io.*;
import java.util.*;

public class Main {

    public static int[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[100001][2];
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        dp[n][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, 0});
        int time = -1;


        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int t = cur[1];

            if(x == k) {
                time = t;
                break;
            }

            if(x * 2 <= 100000 && t + 1 < dp[x * 2][0]) {
                dp[x * 2][0] = t + 1;
                dp[x * 2][1] = x;
                q.add(new int[]{x * 2, t + 1});
            }
            if(x + 1 <= 100000 && t + 1 < dp[x + 1][0]) {
                dp[x + 1][0] = t + 1;
                dp[x + 1][1] = x;
                q.add(new int[]{x + 1, t + 1});
            }
            if(x - 1 >= 0 && t + 1 < dp[x - 1][0]) {
                dp[x - 1][0] = t + 1;
                dp[x - 1][1] = x;
                q.add(new int[]{x - 1, t + 1});
            }
        }

        int[] path = new int[time + 1];
        int temp = k;

        for(int i = path.length - 1; i >= 0; i--) {
            path[i] = temp;
            temp = dp[temp][1];
        }

        sb.append(time);
        sb.append("\n");
        for(int i = 0; i < path.length; i++) {
            sb.append(path[i]);
            sb.append(" ");
        }

        bw.write(sb.toString());
        bw.close();
    }



}