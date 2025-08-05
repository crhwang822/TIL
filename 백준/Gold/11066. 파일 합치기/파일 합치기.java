import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int Ti = 0; Ti < T; Ti++) {
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] files = new int[k];
            int[] sum = new int[k+1];
            int[][] dp = new int[k][k];

            for(int i = 0; i < k; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                sum[i+1] = sum[i] + files[i];
            }


            //dp[r][r+c] 값 업데이트
            for(int c = 1; c < k; c++) {  //col++
                for(int r = 0; r < k - 1; r++) { //row++
                    if(r + c >= k)
                        break;
                    dp[r][r+c] = Integer.MAX_VALUE;
                    for(int i = r; i < r + c; i++) {
                        dp[r][r+c] = Math.min(dp[r][r+c], dp[r][i] + dp[i+1][r+c] + sum[r+c+1] - sum[r]);
                    }
                }
            }

            bw.write(dp[0][k - 1] + "\n");
        }

        bw.close();
    }
}