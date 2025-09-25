import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] obj = new int[n][2];
        int[][] dp = new int[n + 1][k + 1];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            obj[i][0] = Integer.parseInt(st.nextToken());
            obj[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < dp.length; i++) {
            for(int w = 0; w < dp[0].length; w++) {
                dp[i][w] = dp[i - 1][w];
                if(w >= obj[i - 1][0])
                    dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - obj[i - 1][0]] + obj[i - 1][1]);
            }
        }

        sb.append(dp[n][k]);
        bw.write(sb.toString());
        bw.close();
    }

}
