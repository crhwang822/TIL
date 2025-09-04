import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[][] arr = new int[v + 1][v + 1];
        for(int i = 1; i < arr.length; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = Math.min(arr[a][b], c);
        }

        for(int k = 1; k <= v; k++) {
            for(int i = 1; i <= v; i++) {
                for(int j = 1; j <= v; j++) {
                    if(arr[i][k] == Integer.MAX_VALUE || arr[k][j] == Integer.MAX_VALUE)
                        continue;
                    if(arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= v; i++) {
            for(int j = 1; j <= v; j++) {
                if(arr[i][j] == Integer.MAX_VALUE || arr[j][i] == Integer.MAX_VALUE)
                    continue;
                answer = Math.min(answer, arr[i][j] + arr[j][i]);
            }
        }

        if(answer == Integer.MAX_VALUE)
            sb.append("-1");
        else sb.append(answer);

        bw.write(sb.toString());
        bw.close();
    }
}
