import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        sb.append(func(a, b, c));

        bw.write(sb.toString());
        bw.close();
    }

    public static long func(int a, int b, int c) {
        if(b == 1) {
            return a % c;
        }

        long val = 0;
        long temp = func(a, b / 2, c);
        if(b % 2 == 0) {
            val = (temp % c) * (temp % c);
        } else {
            long other = func(a, b / 2 + 1, c);
            val = (temp % c) * (other % c);
        }

        return val % c;
    }

}
