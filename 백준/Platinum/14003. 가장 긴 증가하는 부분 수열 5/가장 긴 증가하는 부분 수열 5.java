import java.io.*;
import java.util.*;

public class Main {

    public static int[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = -1;
        }

        List<Integer> dp = new ArrayList<>();
        dp.add(0);

        for(int i = 1; i < arr.length; i++) {
            int cur = arr[i][0];
            if(arr[dp.get(dp.size() - 1)][0] < cur) {
                arr[i][1] = dp.get(dp.size() - 1);
                dp.add(i);
            } else {
                int index = lowerBound(dp, cur);
                if(index > 0)
                    arr[i][1] = dp.get(index - 1);
                dp.set(index, i);
            }
        }


        sb.append(dp.size());
        sb.append("\n");

        int[] answer = new int[dp.size()];
        int idx = dp.get(dp.size() - 1);
        for(int i = 0; i < dp.size(); i++) {
            answer[dp.size() - 1 - i] = arr[idx][0];
            idx = arr[idx][1];
        }

        for(int i = 0; i < answer.length; i++) {
            sb.append(answer[i]);
            sb.append(" ");
        }

        bw.write(sb.toString());
        bw.close();
    }

    public static int lowerBound(List<Integer> dp, int val) {
        int left = 0;
        int right = dp.size() - 1;
        int minIdx = Integer.MAX_VALUE;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[dp.get(mid)][0] >= val) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            } else {
                left = mid + 1;
            }
        }
        return minIdx;
    }

}