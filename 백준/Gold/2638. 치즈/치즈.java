import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] cheese = new int[n][m];
        int[][] visitCnt = new int[n][m];
        int cnt = 0;

        //입력
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
                if(cheese[i][j] == 1)
                    cnt++;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        int time = 0;
        while(cnt > 0) {
            for(int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
                Arrays.fill(visitCnt[i], 0);
            }
            q.add(new int[]{0, 0});
            while(!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                for(int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc]) {
                        continue;
                    }

                    if(cheese[nr][nc] == 1) {
                        visitCnt[nr][nc]++;
                    } else {
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(cheese[i][j] == 1 && visitCnt[i][j] > 1) {
                        cheese[i][j] = 0;
                        cnt--;
                    }
                }
            }
            time++;
        }


        bw.write(time + "");
        bw.close();
    }
}

