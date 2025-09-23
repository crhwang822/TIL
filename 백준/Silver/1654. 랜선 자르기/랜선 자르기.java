import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        for(int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        long left = 1;
        long right = arr[k - 1];
        long answer = 0;
        while(left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            for(int i = 0; i < k; i++) {
                cnt += (arr[i] / mid);
            }
            if(cnt >= n) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }

        bw.write(answer + "");
        bw.close();
    }

}