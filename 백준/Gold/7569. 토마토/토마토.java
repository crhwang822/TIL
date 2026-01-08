import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = -1;

        //하루가 지나면 익은 토마토의 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 위치에 존재하는 토마토가 영향을 받음
        //모든 토마토가 익게 되는 최소 일수

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] box = new int[h][n][m];

        Queue<int[]> q = new LinkedList<>();

        // 1: 익은 토마토, 0: 익지 않은 토마토, -1: 비어있는 공간
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k] == 1) q.add(new int[]{i, j, k, 0});
                }
            }
        }

        int a, b, c, day;
        while(!q.isEmpty()) {
            int[] arr = q.poll();
            a = arr[0];
            b = arr[1];
            c = arr[2];
            day = arr[3];

            answer = Math.max(answer, day);

            if(b > 0 && box[a][b-1][c] == 0) {
                box[a][b-1][c] = 1;
                q.add(new int[]{a, b-1, c, day + 1});
            }
            if(b < n - 1 && box[a][b+1][c] == 0) {
                box[a][b+1][c] = 1;
                q.add(new int[]{a, b+1, c, day + 1});
            }
            if(c > 0 && box[a][b][c-1] == 0) {
                box[a][b][c-1] = 1;
                q.add(new int[]{a, b, c-1, day + 1});
            }
            if(c < m - 1 && box[a][b][c+1] == 0) {
                box[a][b][c+1] = 1;
                q.add(new int[]{a, b, c+1, day + 1});
            }
            if(a > 0 && box[a-1][b][c] == 0) {
                box[a-1][b][c] = 1;
                q.add(new int[]{a-1, b, c, day + 1});
            }
            if(a < h - 1 && box[a+1][b][c] == 0) {
                box[a+1][b][c] = 1;
                q.add(new int[]{a+1, b, c, day + 1});
            }


        }

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(box[i][j][k] == 0) {
                        answer = -1;
                    }
                }
            }
        }

        bw.write(answer + "");
        bw.close();
    }
}