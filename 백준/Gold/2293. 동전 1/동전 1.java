import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] value = new int[n];
        int[] dp = new int[k + 1]; //dp[i] = i원을 만드는 경우의 수
        dp[0] = 1; //0원을 만드는 경우의 수는 1개

        for(int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

//        Arrays.sort(value);

        //순서가 상관 없는 조합을 구하는 것이므로 바깥 for는 금액이 되어야 ...
        for(int i = 0; i < value.length; i++) {
            int v = value[i];
            for(int j = v; j < dp.length; j++) {
                dp[j] += dp[j - v];
            }
        }


        bw.write(dp[k] + "");
        bw.close();
    }
}