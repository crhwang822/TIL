import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //활성화되어있는 앱의 수
        int m = Integer.parseInt(st.nextToken()); //확보해야하는 바이트 수
        int sum = 0;

        int[][] apps = new int[n][2];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) { //각 앱이 사용중인 메모리 바이트 수 m
            apps[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) { //각 앱을 비활성화 했을 경우의 비용 c
            apps[i][1] = Integer.parseInt(st.nextToken());
            sum += apps[i][1];
        }

        int[][] dp = new int[n + 1][sum + 1];
        for(int i = 0; i < n + 1; i++)
            Arrays.fill(dp[i], -1);
        dp[0][0] = 0;

        for(int i = 1; i <= n; i++) {  //100
            for(int v = 0; v < sum + 1; v++) {
                if(dp[i - 1][v] != -1) {
                    dp[i][v] = Math.max(dp[i][v], dp[i - 1][v]);
                    dp[i][v + apps[i - 1][1]] = Math.max(dp[i][v + apps[i - 1][1]], dp[i - 1][v] + apps[i - 1][0]);
                }
            }
        }

//        for(int i = 0; i < n + 1; i++) {
//            for(int j = 0; j < sum + 1; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        for(int i = 0; i < sum + 1; i++) {
            if(dp[n][i] >= m) {
                bw.write(i + "");
                break;
            }
        }

        bw.close();
    }

}