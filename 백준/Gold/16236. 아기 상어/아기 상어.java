import java.io.*;
import java.util.*;

public class Main {

    public static int[][] map;
    public static int r;
    public static int c;
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, -1, 0, 1};
    public static int size = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int time = 0;
        int cnt = 0;  //먹은 물고기 개수

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    r = i;
                    c = j;
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] != o2[2])
                    return o1[2] - o2[2];
                if(o1[0] != o2[0])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        boolean flag;
        while(true) {
            q.clear();
            pq.clear();
            flag = false;
            for(int i = 0; i < n; i++)
                Arrays.fill(visited[i], false);
            visited[r][c] = true;
            q.add(new int[]{r, c, 0});
            while(!q.isEmpty()) {
                int[] cur = q.poll();
                for(int i = 0; i < 4; i++) {
                    int nr = cur[0] + dr[i];
                    int nc = cur[1] + dc[i];
                    if(nr < 0 || nc < 0 || nr >= n || nc >= n)
                        continue;
                    if(visited[nr][nc] || map[nr][nc] > size)
                        continue;
                    visited[nr][nc] = true;
                    if(map[nr][nc] != 0 && map[nr][nc] < size) {
                        if(!pq.isEmpty() && pq.peek()[2]< cur[2] + 1) {
                            flag = true;
                            break;
                        }
                        pq.add(new int[]{nr, nc, cur[2] + 1});
                    }
                    q.add(new int[]{nr, nc, cur[2] + 1});
                }
                if(flag)
                    break;
            }
            if(pq.isEmpty()) break;
            int[] next = pq.poll();
            map[r][c] = 0;
            r = next[0];
            c = next[1];
            map[r][c] = 0;
            time += next[2];
            cnt++;
            if(cnt == size) {
                size++;
                cnt = 0;
            }
        }


        bw.write(time + "");
        bw.close();
    }

}