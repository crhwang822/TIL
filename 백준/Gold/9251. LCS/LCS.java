import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        int max = 0;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                int up = dp[i-1][j];
                int left = dp[i][j-1];

                dp[i][j] = Math.max(up, left);
                if(str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                max = Math.max(max, dp[i][j]);
            }
        }

        bw.write(max + "");
        bw.close();
    }
}