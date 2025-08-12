import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] minDist = new int[n][n];
        int[][] answer = new int[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(minDist[i], Integer.MAX_VALUE);
            minDist[i][i] = 0;
        }


        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            minDist[a-1][b-1] = v;
            minDist[b-1][a-1] = v;
            answer[a-1][b-1] = b;
            answer[b-1][a-1] = a;
        }

        for(int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        continue;
                    if(minDist[i][k] == Integer.MAX_VALUE || minDist[k][j] == Integer.MAX_VALUE)
                        continue;
                    int temp = minDist[i][k] + minDist[k][j];
                    if (temp < minDist[i][j]) {
                        minDist[i][j] = temp;
                        answer[i][j] = answer[i][k];
                    }
                }
            }
        }

        //출력
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j)
                    sb.append("-");
                else sb.append(answer[i][j]);
                sb.append("\t");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }


}