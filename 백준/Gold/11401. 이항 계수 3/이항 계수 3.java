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
        int n = Integer.parseInt(st.nextToken());  // 4 * 10^6
        int k = Integer.parseInt(st.nextToken());  // 4 * 10^6

        fact = new long[n + 1];
        Arrays.fill(fact, -1);
        fact[0] = 1;

        for(int i = 1; i < fact.length; i++) {
            fact[i] = (fact[i - 1] * i) % num;
        }

        long ans;
        if(k == 0 || k == n) {
            ans = 1;
        } else  {
            ans = ((fact[n] % num) * (pow(fact[k], num - 2) % num)) % num ;
            ans = (ans * (pow(fact[n - k], num - 2) % num)) % num;
        }

        sb.append(ans);

        bw.write(sb.toString());
        bw.close();
    }

    static long pow(long a, long e) {
        long res = 1L, base = a % num;
        while (e > 0) {
            if ((e & 1L) == 1L) res = (res * base) % num;
            base = (base * base) % num;
            e >>= 1;
        }
        return res;
    }

}
