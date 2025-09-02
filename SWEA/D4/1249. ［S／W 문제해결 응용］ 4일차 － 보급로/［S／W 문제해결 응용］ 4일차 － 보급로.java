import java.io.*;
import java.util.*;

//SWEA
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[][] map;
        int[][] dist;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        //테스트케이스 시작
        for(int Ti = 1; Ti <= T; Ti++) {
            int N = Integer.parseInt(br.readLine());

            pq.clear();

            map = new int[N][N];
            dist = new int[N][N];

            for(int i = 0; i < N; i++)
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[0][0] = 0;

            for(int i = 0; i < N; i++) {
                String[] str = br.readLine().split("");
                for(int j = 0; j < N; j++)
                    map[i][j] = Integer.parseInt(str[j]);
            }

            pq.add(new int[]{0, 0, 0});

            while(!pq.isEmpty()){
                int[] cur = pq.poll();
                int r = cur[0];
                int c = cur[1];

                for(int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
                        continue;
                    }

                    if(dist[r][c] + map[nr][nc] < dist[nr][nc]) {
                        dist[nr][nc] = dist[r][c] + map[nr][nc];
                        pq.add(new int[]{nr, nc, dist[nr][nc]});
                    }
                }
            }

            int ans = dist[N - 1][N - 1];

            //출력
            sb.append("#");
            sb.append(Ti);
            sb.append(" ");
            sb.append(ans);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

}
