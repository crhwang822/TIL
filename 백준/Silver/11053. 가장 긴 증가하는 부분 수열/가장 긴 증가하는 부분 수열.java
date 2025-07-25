import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        int ans = 0;

        for(int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                int temp;
                if(a[i] > a[j]) {
                    temp = dp[j] + 1;
                    dp[i] = Math.max(dp[i], temp);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        bw.write(ans + "");
        bw.close();
    }
}