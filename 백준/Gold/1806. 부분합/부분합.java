import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        int start = 0;
        int end = 0;
        long sum = 0;
        int ans = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(true) {
            if(sum < s && end < n) {
                sum += arr[end];
                end++;
            } else {
                ans = Math.min(ans, end - start);
                sum -= arr[start];
                start++;
            }

            if(end == n && sum < s)
                break;
        }

        if(ans == Integer.MAX_VALUE)
            ans = 0;


        bw.write(ans + "");
        bw.close();
    }
}