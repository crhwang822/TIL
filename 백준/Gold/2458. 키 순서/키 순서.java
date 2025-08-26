import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans = 0;
        int[][] arr = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++)
            Arrays.fill(arr[i], Integer.MAX_VALUE);

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = b;
        }

        for(int mid = 1; mid <= n; mid++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                   if(arr[i][mid] != Integer.MAX_VALUE && arr[mid][j] != Integer.MAX_VALUE) {
                       arr[i][j] = mid;
                   }
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            int sum = 0;
            for(int j = 1; j <= n; j++) {
                if(arr[i][j] != Integer.MAX_VALUE)
                    sum++;
                if(arr[j][i] != Integer.MAX_VALUE)
                    sum++;
            }
            if(sum == n - 1)
                ans++;
        }

        bw.write(ans + "");
        bw.close();
    }

}