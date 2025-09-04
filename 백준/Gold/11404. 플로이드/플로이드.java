import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];
        for(int i = 1; i < arr.length; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
            arr[i][i] = 0;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(arr[a][b] > c)
                arr[a][b] = c;
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(arr[i][k] == Integer.MAX_VALUE || arr[k][j] == Integer.MAX_VALUE)
                        continue;
                    if(arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(arr[i][j] == Integer.MAX_VALUE)
                    sb.append("0");
                else sb.append(arr[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}
