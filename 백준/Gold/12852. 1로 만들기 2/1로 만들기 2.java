import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][2];
        for(int i = 1; i < n + 1; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[1][0] = 0;
        dp[1][1] = -1;



        for(int i = 2; i < dp.length; i++) {
            if(i % 2 == 0 && dp[i][0] > 1 + dp[i / 2][0]) {
                dp[i][0] = 1 + dp[i / 2][0];
                dp[i][1] = i / 2;
            }
            if(i % 3 == 0 && dp[i][0] > 1 + dp[i / 3][0]) {
                dp[i][0] = 1 + dp[i / 3][0];
                dp[i][1] = i / 3;
            }
            if(dp[i][0] > 1 + dp[i - 1][0]) {
                dp[i][0] = 1 + dp[i - 1][0];
                dp[i][1] = i - 1;
            }
        }

        sb.append(dp[n][0]);
        sb.append("\n");
        int index = n;
        while(index != -1) {
            sb.append(index);
            index = dp[index][1];
            sb.append(" ");
        }
        bw.write(sb.toString());
        bw.close();
    }

}