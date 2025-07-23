import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] items = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[k+1][n+1];
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                int weight = items[j-1][0];
                dp[i][j] = dp[i][j-1];
                if(i >= weight) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-weight][j-1] + items[j-1][1]);
                }
            }
        }

        int max = 0;
        for(int i = 1; i < dp[0].length; i++) {
            max = Math.max(max, dp[dp.length - 1][i]);
        }

        bw.write(max+"");
        bw.close();
    }
}