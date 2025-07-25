import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int s = 0;
        int e = arr.length - 1;
        int[] ans = new int[2];
        int prev = Integer.MAX_VALUE;
        while(s != e) {
            int sum = arr[s] + arr[e];
            if(Math.abs(sum) < prev) {
                prev = Math.abs(sum);
                ans[0] = arr[s];
                ans[1] = arr[e];
            }
            if(sum > 0)
                e--;
            else if(sum < 0)
                s++;
            else
                break;
        }

        bw.write(ans[0] + " " + ans[1]);
        bw.close();
    }
}