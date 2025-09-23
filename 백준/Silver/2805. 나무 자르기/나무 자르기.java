import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);
        int left = 1;
        int right = trees[n - 1];
        int answer = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            long len = 0;
            for(int i = 0; i < n; i++) {
                len += Math.max(0, trees[i] - mid);
            }
            if(len >= m) { //
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