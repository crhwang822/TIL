import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        int ti = 1;
        int N;

        Queue<int[]> q = new LinkedList<>();


        while((N = Integer.parseInt(br.readLine())) != 0) {
            int[][] map = new int[N][N];
            int[][] dist = new int[N][N];
            for(int i = 0; i < dist.length; i++)
                Arrays.fill(dist[i], Integer.MAX_VALUE);


            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            q.add(new int[]{0,0});

            dist[0][0] = map[0][0];
            while(!q.isEmpty()) {
                int[] cur = q.poll();


                for(int i = 0; i < 4; i++) {
                    int nr = cur[0] + dr[i];
                    int nc = cur[1] + dc[i];
                    if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
                        continue;
                    }
                    if(dist[nr][nc] > dist[cur[0]][cur[1]] + map[nr][nc]) {
                        dist[nr][nc] = dist[cur[0]][cur[1]] + map[nr][nc];
                        q.add(new int[]{nr, nc});
                    }
                }
            }
//
//            for(int i = 0; i < N; i++) {
//                for(int j = 0; j < N; j++) {
//                    System.out.print(dist[i][j] + " " );
//                }
//                System.out.println();
//            }

            sb.append("Problem ");
            sb.append(ti++);
            sb.append(": ");
            sb.append(dist[N-1][N-1]);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}