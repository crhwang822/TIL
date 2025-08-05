import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[100][10];
        for(int i = 1; i < 10; i++) {
            dp[0][i] = 1;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 10; j++) {
                if(j != 0)
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % 1000000000;
                if(j != 9)
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % 1000000000;
            }
        }

        long answer = 0;
        for(int i = 0; i < 10; i++) {
            answer = (answer + dp[n - 1][i]) % 1000000000;
        }

        bw.write(answer + "");
        bw.close();

    }
}