import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static int w;
    public static int h;
    public static char[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new char[h][w];
        int[] start = new int[2];

        for(int i = 0; i < h; i++) {
            String str = br.readLine();
            for(int j = 0; j < w; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'T') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        int[][] dist = new int[h][w];
        for(int i = 0; i < h; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[start[0]][start[1]] = 0;


        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        pq.add(new int[]{start[0], start[1], dist[start[0]][start[1]]});

        int[] cur;
        int r, c, nr, nc, sum, answer = Integer.MAX_VALUE;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};


        while(!pq.isEmpty()) {
            cur = pq.poll();
            r = cur[0];
            c = cur[1];

            if(map[r][c] == 'E') {
                answer = Math.min(answer, cur[2]);
            }

            for(int i = 0; i < 4; i++) {
                nr = r + dr[i];
                nc = c + dc[i];
                sum = 0;

                while(validate(nr, nc)) {
                    if(map[nr][nc] == 'H')
                        break;

                    if(map[nr][nc] == 'R') {
                        if(dist[r][c] + sum < dist[nr - dr[i]][nc - dc[i]]) {
                            dist[nr - dr[i]][nc - dc[i]] = dist[r][c] + sum;
                            pq.add(new int[]{nr - dr[i], nc - dc[i], dist[nr - dr[i]][nc - dc[i]]});
                        }
                        break;
                    }

                    if(map[nr][nc] == 'E' || map[nr][nc] == 'T') {
                        if(dist[r][c] + sum < dist[nr][nc]) {
                            dist[nr][nc] = dist[r][c] + sum;
                            pq.add(new int[]{nr, nc, dist[nr][nc]});
                        }
                        break;
                    }

                    sum += (map[nr][nc] - '0');

                    nr += dr[i];
                    nc += dc[i];
                }
            }
        }

        if(answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer + "");
    }

    public static boolean validate(int nr, int nc) {
        if(nr < 0 || nc < 0 || nr >= h || nc >= w) {
            return false;
        }

        return true;
    }
}