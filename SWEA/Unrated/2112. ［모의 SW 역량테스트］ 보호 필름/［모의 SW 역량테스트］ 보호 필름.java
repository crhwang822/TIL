import java.io.*;
import java.util.*;

public class Solution {

    public static int ans;
    public static int d;
    public static int w;
    public static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int Ti = 0; Ti < T; Ti++) {
            st = new StringTokenizer(br.readLine());
            ans = Integer.MAX_VALUE;
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            int[][] arr = new int[d][w];

            for(int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(arr, 0, 0, true);

            sb.append("#");
            sb.append(Ti + 1);
            sb.append(" ");
            sb.append(ans);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

    public static void dfs(int[][] arr, int cnt, int depth, boolean flag) {
        if(depth == arr.length) {
            if(check(arr))
                ans = Math.min(ans, cnt);
            return;
        }

        if(flag && check(arr)) {
            ans = Math.min(ans, cnt);
            return;
        }

        //투입 X
        dfs(arr, cnt, depth + 1, false);

        int[] backup = arr[depth].clone();
        Arrays.fill(arr[depth], 0);
        //a 약물 투입
        dfs(arr, cnt + 1, depth + 1, true);

        Arrays.fill(arr[depth], 1);
        //b 약물 투입
        dfs(arr, cnt + 1, depth + 1, true);

        arr[depth] = backup;

    }

    public static boolean check(int[][] arr) {
        for(int j = 0; j < arr[0].length; j++) {
            int cnt = 1;
            boolean flag = false;
            for(int i = 1; i < arr.length; i++) {
                if(arr[i][j] == arr[i-1][j])
                    cnt++;
                else cnt = 1;
                if(cnt >= k) {
                    flag = true;
                    break;
                }
            }
            if(!flag) return false;
        }
        return true;
    }
}