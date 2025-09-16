import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int p = b - a;
        int q = b;

        for(int i = 9; i > 1; i--) {
            if(p % i == 0 && q % i == 0) {
                p /= i;
                q /= i;
            }
        }

        sb.append(p);
        sb.append(" ");
        sb.append(q);

        bw.write(sb.toString());
        bw.close();
    }
}
