import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][2];
        for(int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = -1;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && dp[j][0] + 1 > dp[i][0]) {
                    dp[i][0] = dp[j][0] + 1;
                    dp[i][1] = j;
                }
            }
        }

        int index = 0;
        int max = 1;
        for(int i = 0; i < n; i++) {
            if(dp[i][0] > max) {
                max = dp[i][0];
                index = i;
            }
        }

        sb.append(max);
        sb.append("\n");

        int[] answer = new int[max];
        for(int i = 0; i < answer.length; i++) {
            answer[answer.length - 1 - i] = arr[index];
            index = dp[index][1];
        }

        for(int i = 0; i < answer.length; i++) {
            sb.append(answer[i]);
            sb.append(" ");
        }


        bw.write(sb.toString());
        bw.close();
    }

}