import java.io.*;
import java.util.*;

public class Main {

    public static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][] map = new int[h][w];

        int[] jumpR = {-2 , -2, -1, -1, 1, 1, 2, 2};
        int[] jumpC = {-1, 1, -2, 2, -2, 2, -1, 1};

        int[] walkR = {0, 0, 1, -1};
        int[] walkC = {1, -1, 0, 0};

        for(int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, cnt, k});
        boolean[][][] visited = new boolean[h][w][k+1];
        visited[0][0][k] = true;
        boolean flag = false;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            flag = false;
            //jump
            for(int i = 0; i < 8; i++) {
                if(cur[3] < 1)
                    break;
                int nr = cur[0] + jumpR[i];
                int nc = cur[1] + jumpC[i];
                //범위 check
                if(nr < 0  || nc < 0 || nr >= h || nc >= w)
                    continue;
                //장애물 check & 방문 check
                if(map[nr][nc] == 1 || visited[nr][nc][cur[3] - 1])
                    continue;
                if(nr == h -1 && nc == w - 1) {
                    cnt = cur[2] + 1;
                    flag = true;
                    break;
                }
                visited[nr][nc][cur[3] - 1] = true;
                q.add(new int[]{nr, nc, cur[2] + 1, cur[3] - 1});
            }

            //walk
            for(int i = 0; i < 4; i++) {
                int nr = cur[0] + walkR[i];
                int nc = cur[1] + walkC[i];
                //범위 check
                if(nr < 0  || nc < 0 || nr >= h || nc >= w)
                    continue;
                //장애물 check & 방문 check
                if(map[nr][nc] == 1 || visited[nr][nc][cur[3]])
                    continue;
                if(nr == h -1 && nc == w - 1) {
                    cnt = cur[2] + 1;
                    flag = true;
                    break;
                }
                visited[nr][nc][cur[3]] = true;
                q.add(new int[]{nr, nc, cur[2] + 1, cur[3]});
            }

            if(flag)
                break;
        }

        if(!flag && !(h == 1 && w == 1)) {
            cnt = -1;
        }


        bw.write(cnt + "");
        bw.close();
    }
}