import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] box = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 0)
                    cnt++;
                else if(box[i][j] == 1)
                    q.add(new int[]{i, j, 0});
            }
        }

        if(cnt == 0) {
            bw.write("0");
            bw.close();
            System.exit(0);
        }

        boolean flag = true;
        boolean[][] visited = new boolean[n][m];
        int[] dr = {0,0,1,-1};
        int[] dc = {1,-1,0,0};

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                time = cur[2];

                if(nr < 0 || nc < 0 || nr >=n || nc >= m)
                    continue;

                if(box[nr][nc] == 0) {
                    box[nr][nc] = 1;
                    q.add(new int[]{nr, nc, cur[2] + 1});
                    cnt--;
                }
            }
        }


        if(cnt > 0)
            bw.write("-1");
        else bw.write(time + "");

        bw.close();
    }
}
