import java.io.*;

public class Main {

    public static int mod = 1000000007;
    public static int[][] A = {{1,1}, {1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        long n = Long.parseLong(br.readLine());

        //F_n = {{f_n+1}, {f_n}} = A^(n) * F_0
        //F_0 = {{f_1}, {f_0}} = {{1}, {0}}
        long[][] ans = mul(func(n), new long[][]{{1}, {0}});
        sb.append(ans[1][0]);

        bw.write(sb.toString());
        bw.close();
    }

    public static long[][] func(long e) {
        long[][] res = {{1,0}, {0,1}};
        long[][] base = {{1, 1}, {1, 0}};

        while(e > 0) {
            if(e % 2 == 1) {
                res = mul(res, base);
                e--;
            }
            base = mul(base, base);
            e /= 2;
        }
        return res;
    }


    public static long[][] mul(long[][] mat1, long[][] mat2) {
        long[][] res = new long[mat1.length][mat2[0].length];
        for(int i = 0; i < mat1.length; i++) {
            for(int j = 0; j < mat2[0].length; j++) {
                for(int k = 0; k < mat2.length; k++) {
                    res[i][j] += (mat1[i][k] * mat2[k][j]);
                    res[i][j] %= mod;
                }
            }
        }
        return res;
    }

}
