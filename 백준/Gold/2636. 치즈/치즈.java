import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] map = new int[h][w];
        int cnt = 0;
        boolean[][] visited = new boolean[h][w];

        for(int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) cnt++;
            }
        }

        //탐색
        map[0][0] = 2;
        List<int[]> q = new ArrayList<>();
        q.add(new int[]{0, 1});
        visited[0][0] = true;
        while(!q.isEmpty()) {
            int[] cur = q.get(0);
            int x = cur[0];
            int y = cur[1];
            q.remove(0);
            visited[x][y] = true;

            if(map[x][y] != 1) {
                if(x > 0 && !visited[x - 1][y]) {
                    q.add(new int[]{x - 1, y});
                    visited[x - 1][y] = true;
                }
                if(x < h - 1 && !visited[x + 1][y]) {
                    q.add(new int[]{x + 1, y});
                    visited[x + 1][y] = true;
                }
                if(y > 0 && !visited[x][y - 1]) {
                    q.add(new int[]{x, y - 1});
                    visited[x][y - 1] = true;
                }
                if(y < w - 1 && !visited[x][y + 1]) {
                    q.add(new int[]{x, y + 1});
                    visited[x][y + 1] = true;
                }
                map[x][y] = 2;
            }
        }
        int temp;
        int time = 1;
        while((temp = func(map, cnt)) != 0) {
            time++;
            cnt = temp;
        }
        bw.write(time + "\n");
        bw.write(cnt + "\n");
        bw.close();
    }

    public static int func(int[][] map, int cnt) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        List<int[]> q = new ArrayList<>();
        q.add(new int[]{0,0});
        boolean flag = false;
        while(!q.isEmpty()) {
            int[] cur = q.get(0);
            int x = cur[0];
            int y = cur[1];
            q.remove(0);

            if(map[x][y] == 0) {
                flag = true;
                if(flag)
                    map[x][y] = 2;
            }
            if(map[x][y] == 2) {
                if(x > 0 && !visited[x - 1][y]) {
                    q.add(new int[]{x - 1, y});
                    visited[x-1][y] = true;
                }
                if(x < map.length - 1 && !visited[x + 1][y]) {
                    q.add(new int[]{x + 1, y});
                    visited[x+1][y] = true;
                }
                if(y > 0 && !visited[x][y - 1]) {
                    q.add(new int[]{x, y - 1});
                    visited[x][y-1] = true;
                }
                if(y < map[0].length - 1 && !visited[x][y + 1]) {
                    q.add(new int[]{x, y + 1});
                    visited[x][y+1] = true;
                }

            } else {
                cnt--;
                map[x][y] = 2;
            }

        }
        return cnt;
    }
}