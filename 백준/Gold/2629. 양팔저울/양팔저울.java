import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int[] weights = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            sum += weights[i];
        }

        boolean[][] dp = new boolean[n + 1][sum + 1];

        int m = Integer.parseInt(br.readLine());
        int[] beads = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            beads[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = true;
        for(int i = 1; i <= n; i++) {
            int cur = weights[i - 1];
            for(int w = 0; w < sum + 1; w++) {
                if(!dp[i - 1][w])
                    continue;

                //추를 놓지 않는 경우
                dp[i][w] = true;
                //추를 가벼운 쪽에 놓는 경우
                dp[i][Math.abs(w - cur)] = true;
                //추를 무거운 쪽에 놓는 경우
                dp[i][w + cur] = true;
            }
        }

        for(int i = 0; i < m; i++) {
            if(beads[i] < sum + 1 && dp[n][beads[i]])
                sb.append("Y ");
            else sb.append("N ");
        }

        bw.write(sb.toString());
        bw.close();
    }

}