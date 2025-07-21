import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = Integer.MAX_VALUE;

        for(int i = 0; i <= n / 3; i++) {
            int x = i;
            int y = (n - 3 * i) / 5;
            if((n - 3 * i) % 5 == 0)
                cnt = Math.min(cnt, x + y);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(cnt == Integer.MAX_VALUE)
            bw.write("-1");
        else bw.write(cnt + "");
        bw.close();

    }
}