import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    public static long mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] fact = new long[n + 1];
        fact[0] = 1;
        fact[1] = 1;
        for(int i = 2; i <= n; i++)
            fact[i] = (fact[i - 1] * i) % mod;

        long answer = 0;
        answer = ((fact[n] % mod) * (pow(fact[k], mod - 2) % mod)) % mod;
        answer = answer * (pow(fact[n - k], mod - 2) % mod);
        answer %= mod;

        bw.write(answer + "");
        bw.close();
    }

    public static long pow (long a, long b) {
        long ans = 1;
        long base = a;
        while(b > 0) {
            if(b % 2 == 1){
                ans = (ans * base) % mod;
                b--;
            }
            else {
                base = (base * base) % mod;
                b /= 2;
            }
        }
        return ans;
    }

}
