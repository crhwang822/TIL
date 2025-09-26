import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int Ti = 0; Ti < T; Ti++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] cards = new int[n];
            for(int i = 0; i < n; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
            }
            int[][] dp = new int[n + 2][n + 2];
            int[] partSum = new int[n + 1];
            for(int i = 1; i < partSum.length; i++) {
                partSum[i] = partSum[i -1] + cards[i - 1];
            }

            for(int i = 0; i <= n; i++) {
                for(int r = 1; r < n + 1; r++) {
                    if(r + i > n)
                        continue;
                    //dp[r][r+i] 정의
                    //왼쪽을 선택한 경우
                    dp[r][r + i] = Math.max(dp[r][r + i], cards[r - 1] + (partSum[r + i] - partSum[r] - dp[r + 1][r + i]));
                    //오른쪽을 선택한 경우
                    dp[r][r + i] = Math.max(dp[r][r + i], cards[r + i - 1] + (partSum[r + i - 1] - partSum[r - 1] - dp[r][r + i - 1]));
                }
            }

            sb.append(dp[1][n]);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

}