import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] fact = new int[n + 1];
        fact[0] = 1;
        fact[1] = 1;
        for(int i = 2; i <= n; i++)
            fact[i] = fact[i - 1] * i;

        int answer = 0;
        answer = fact[n] / (fact[k] * fact[n - k]);

        bw.write(answer + "");
        bw.close();
    }

}
