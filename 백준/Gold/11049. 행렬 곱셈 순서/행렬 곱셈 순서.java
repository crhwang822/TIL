import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][2];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }

        for(int t = 1; t < n; t++) {
            for(int i = 1; i < n; i++) {
                if(i + t > n)
                    break;
                //dp[i][i + t] 값 갱신
                for(int k = 0; k < t; k++) {
                    dp[i][i + t] = Math.min(dp[i][i + t], dp[i][i + k] + dp[i + k + 1][i + t] + arr[i][0] * arr[i + k + 1][0] * arr[i + t][1]);
                }
            }
        }

        bw.write(dp[1][n] + "");
        bw.close();
    }

}