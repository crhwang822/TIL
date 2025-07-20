import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long s = 1;
        long e = k; //배열에서 k번째 수는 절대 k보다 클 수 없음
        long x = 0;

        while(s <= e) {
            x = (s + e) / 2;
            long cnt = 0;
            for(int i = 1; i <= N; i++)  {
                cnt += Math.min(N, x / i);
            }
            if(cnt >= k) {
                e = x - 1;
            }
            if(cnt < k)
                s = x + 1;
        }

        bw.write(s+"");
        bw.close();
    }
}