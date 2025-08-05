import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int Ti = 0; Ti < T; Ti++) {
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] files = new int[k];
//            int[][] dp = new int[k][k];
            List<int[][]> list = new ArrayList<>();
            for(int i = 0; i < k; i++)
                list.add(new int[k][2]);

            for(int i = 0; i < k; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                list.get(i)[i][0] = files[i];
//                dp[i][i] = files[i];
            }


            //dp[r][r+c] 값 업데이트
            for(int c = 1; c < k; c++) {  //col++
                for(int r = 0; r < k - 1; r++) { //row++
                    if(r + c >= k)
                        break;
                    int min = Integer.MAX_VALUE;
                    for(int i = r; i < r + c; i++) {
//                        int temp = dp[r][i] + dp[i+1][r+c];
                        int temp = list.get(r)[i][0] + list.get(i+1)[r+c][0] + list.get(r)[i][1] + list.get(i+1)[r+c][1];
                        if(temp < min) {
//                            a = dp[r][i];
//                            b = dp[i+1][r+c];
                            list.get(r)[r+c][0] = list.get(r)[i][0] + list.get(i+1)[r+c][0];
                            list.get(r)[r+c][1] = temp;
                            min = temp;
                        }
                    }
//                    dp[r][r+c] = min;
                }
            }
            bw.write(list.get(0)[k-1][1] + "\n");
        }

        bw.close();
    }
}