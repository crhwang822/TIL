import java.io.*;
import java.util.*;

public class Main {

    public static int[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String[] s1 = br.readLine().split("");
        String[] s2 = br.readLine().split("");

        int[][] dp = new int[s1.length + 1][s2.length + 1];

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(s1[i - 1].equals(s2[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
            }
        }

        bw.write(dp[s1.length][s2.length] + "\n");

        int r = s1.length;
        int c = s2.length;
        while(true) {
            if(dp[r][c] == 0) break;
            if(s1[r - 1].equals(s2[c - 1])) {
                sb.append(s1[r - 1]);
                r--;
                c--;
            } else {
                if(dp[r - 1][c] > dp[r][c - 1]) {
                    r--;
                } else {
                    c--;
                }
            }
        }


        bw.write(sb.reverse().toString());
        bw.close();
    }



}