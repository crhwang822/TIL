import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];

        int sx = 0;
        int sy = 0;
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == '0') {
                    sx = j;
                    sy = i;
                }
             }
        }

        int answer = -1;

        boolean[][][] visited = new boolean[n][m][64]; //키 상태를 비트 마스크 방식으로 표현
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy, 0, 0});

        while(!q.isEmpty()) {
            int[] arr = q.poll();
            int x = arr[0];
            int y = arr[1];
            int cnt = arr[2];
            int keyMask = arr[3];

            if(map[y][x] == '1') {
                answer = cnt;
                break;
            }

            //현재 좌표에 문이 있는데 열쇠가 없는 경우
            if('A' <= map[y][x] && map[y][x] <= 'F' && (keyMask & (1 << (map[y][x]- 'A'))) == 0) {
                continue;
            }

            if('a' <= map[y][x] && map[y][x] <= 'f') {
                keyMask |= (1 << (map[y][x]- 'a'));
            }

            if(x > 0 && !visited[y][x - 1][keyMask] && map[y][x - 1] != '#') {
                visited[y][x - 1][keyMask] = true;
                q.add(new int[]{x - 1, y, cnt + 1, keyMask});
            }

            if(y > 0 && !visited[y - 1][x][keyMask] && map[y - 1][x] != '#') {
                visited[y - 1][x][keyMask] = true;
                q.add(new int[]{x, y - 1, cnt + 1, keyMask});
            }

            if(x < m - 1 && !visited[y][x + 1][keyMask] && map[y][x + 1] != '#') {
                visited[y][x + 1][keyMask] = true;
                q.add(new int[]{x + 1, y, cnt + 1, keyMask});
            }

            if(y < n - 1 && !visited[y + 1][x][keyMask] && map[y + 1][x] != '#') {
                visited[y + 1][x][keyMask] = true;
                q.add(new int[]{x, y + 1, cnt + 1, keyMask});
            }

        }

        bw.write(answer + "");
        bw.close();
    }


}