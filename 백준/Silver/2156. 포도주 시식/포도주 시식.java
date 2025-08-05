import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[][] dp = new int[n+1][4];

        for(int i = 1; i < dp.length; i++) {
            arr[i-1] = Integer.parseInt(br.readLine());

            dp[i][0] = dp[i - 1][1] + arr[i-1];
            dp[i][1] = dp[i - 1][2] + arr[i-1];
            dp[i][2] = dp[i-1][3];
            dp[i][3] = Math.max(dp[i][2],Math.max(dp[i][0], dp[i][1]));

        }

        bw.write(dp[n][3] + "");
        bw.close();

    }
}