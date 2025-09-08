import java.io.*;
import java.util.*;

public class Main {

    public static int num = 1000000007;
    public static long[] fact;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] mat1 = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                mat1[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] mat2 = new int[m][k];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < k; j++) {
                mat2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] res = new int[n][k];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < k; j++) {
                for(int p = 0; p < m; p++) {
                    res[i][j] += (mat1[i][p] * mat2[p][j]);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < k; j++) {
                sb.append(res[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

}
