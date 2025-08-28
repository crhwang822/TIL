import java.io.*;
import java.util.*;

public class Solution {

    public static int N;
    public static int[][] pool;

    public static int time;

    public static int[] start = new int[2];
    public static int[] end = new int[2];

    public static int[] dc = {1, -1, 0, 0};
    public static int[] dr = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        boolean[][] visited;


        for(int Ti = 1; Ti <= T; Ti++) {
            //초기화
            N = Integer.parseInt(br.readLine());
            pool = new int[N][N];
            visited = new boolean[N][N];
            time = Integer.MAX_VALUE;

            //입력
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    pool[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 2; i++)
                start[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 2; i++)
                end[i] = Integer.parseInt(st.nextToken());

            //BFS

            visited[start[0]][start[1]] = true;
            dfs(new int[]{start[0], start[1], 0}, visited);
            
            if(time == Integer.MAX_VALUE)
                time = -1;

            sb.append("#");
            sb.append(Ti);
            sb.append(" ");
            sb.append(time);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

    public static void dfs(int[] init, boolean[][] v) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        for(int i = 0; i < N; i++)
            visited[i] = v[i].clone();

        q.add(init);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == end[0] && cur[1] == end[1]) {
                time = Math.min(time, cur[2]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                    continue;
                }
                if (visited[nr][nc] || pool[nr][nc] == 1)
                    continue;
                visited[nr][nc] = true;
                if (pool[nr][nc] == 0) {
                    q.add(new int[]{nr, nc, cur[2] + 1});
                } else {
                    dfs(new int[]{nr, nc, cur[2] + (3 - (cur[2] % 3))}, visited);
                }
            }

        }
    }
}