import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        //입력
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> dp = new ArrayList<>();
        dp.add(0);

        //dp
        for(int i = 1; i < arr.length; i++) {
            int tail = dp.get(dp.size() - 1);
            int cur = arr[i];
            if(cur > tail) {
                dp.add(cur);
            } else {
                int idx = lowerBound(dp, cur);
                dp.set(idx, cur);
            }
        }

        bw.write(dp.size() - 1 + "");
        bw.close();
    }

    public static int lowerBound(List<Integer> dp, int val) {
        int left = 0;
        int right = dp.size() - 1;
        int minIdx = dp.size();
        while(left <= right) {
            int mid = (left + right) / 2;
            if(dp.get(mid) >= val) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            } else {
                left = mid + 1;
            }
        }
        return minIdx;
    }
}