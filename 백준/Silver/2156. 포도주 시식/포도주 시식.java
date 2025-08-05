import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n + 1];

        for(int i = 1; i < dp.length; i++) {
            arr[i - 1] = Integer.parseInt(br.readLine());

            if(i == 1)
                dp[i] = arr[i - 1];
            else if(i == 2)
                dp[i] = arr[i - 1] + arr[i - 2];
            else {
                int a = dp[i - 2] + arr[i - 1];  //i - 1번째 잔을 안 마시는 경우
                int b = dp[i - 3] + arr[i - 2] + arr[i - 1];  //i - 1번째 잔을 마시는 경우
                int c = dp[i - 1];       //i번째 잔을 안 마시는 경우
                dp[i] = Math.max(a, Math.max(b, c));
            }

        }

        bw.write(dp[n] + "");
        bw.close();

    }
}