import java.io.*;
import java.util.*;

public class Main {

    public static int num = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long[][] mat = new long[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                mat[i][j] = Long.parseLong(st.nextToken());
            }
        }

        mat = func(mat, b);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(mat[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

    public static long[][] func(long[][] mat, long e) {
        long[][] res = new long[mat.length][mat.length];
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat.length; j++) {
                if(i == j) res[i][j] = 1;
            }
        }
        long[][] temp = new long[mat.length][mat.length];
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat.length; j++)
                temp[i][j] = mat[i][j];
        }
        while(e > 0) {
            if(e % 2 == 1) {
                res = multiply(res, temp);
                e--;
            } else {
                temp = multiply(temp, temp);
                e /= 2;
            }
        }
        return res;
    }

    public static long[][] multiply(long[][] mat1, long[][] mat2) {
        long[][] res = new long[mat1.length][mat2[0].length];
        for(int i = 0; i < mat1.length; i++) {
            for(int j = 0; j < mat2[0].length; j++) {
                for(int k = 0; k < mat2.length; k++) {
                    res[i][j] +=  (mat1[i][k] * mat2[k][j]);
                    res[i][j] %= num;
                }
            }
        }

        return res;
    }
}
