import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] connections = new int[n][2];
        int[] dp = new int[n];
        int ans = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            connections[i][0] = Integer.parseInt(st.nextToken());
            connections[i][1] = Integer.parseInt(st.nextToken());
        }

        //전봇대 A 기준 오름차순 정렬
        Arrays.sort(connections, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                int temp;
                if(connections[i][1] > connections[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        ans = connections.length - ans;

        bw.write(ans + "");
        bw.close();
    }
}