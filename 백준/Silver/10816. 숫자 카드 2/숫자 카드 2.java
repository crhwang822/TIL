import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] nums = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        for(int i = 0; i < m; i++) {
            int target = nums[i];
            int left = 0;
            int right = cards.length - 1;
            int minIdx = cards.length;
            int maxIdx = cards.length;
            while(left <= right) {
                int mid = (left + right) / 2;
                if(cards[mid] >= target) {
                    right = mid - 1;
                    minIdx = Math.min(minIdx, mid);
                } else {
                    left = mid + 1;
                }
            }

            left = 0;
            right = cards.length - 1;
            while(left <= right) {
                int mid = (left + right) / 2;
                if(cards[mid] > target) {
                    right = mid - 1;
                    maxIdx = Math.min(maxIdx, mid);
                } else {
                    left = mid + 1;
                }
            }

            bw.write(maxIdx - minIdx + " ");
        }

        bw.close();
    }

}