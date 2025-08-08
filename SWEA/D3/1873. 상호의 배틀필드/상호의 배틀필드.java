import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int Ti = 0; Ti < T; Ti++) {
            //입력
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            char[][] map = new char[h][w];
            int[] cur = new int[2];
            for(int i = 0; i < h; i++) {
                String str = br.readLine();
                for(int j = 0; j < w; j++) {
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
                        cur[0] = i;
                        cur[1] = j;
                    }
                }
            }
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            //
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};

            int index = 0;
            while(index < input.length()) {
                switch (input.charAt(index++)) {
                    case 'S':
                        int dir = "^v<>".indexOf(map[cur[0]][cur[1]]);
                        int x = cur[1];
                        int y = cur[0];
                        while(x + dx[dir] > -1 && x + dx[dir] < w && y + dy[dir] > -1 && y + dy[dir] < h) {
                            x += dx[dir];
                            y += dy[dir];
                            if(map[y][x] == '#')
                                break;
                            if(map[y][x] == '*') {
                                map[y][x] = '.';
                                break;
                            }
                        }
                        break;
                    case 'U' :
                        map[cur[0]][cur[1]] = '.';
                        if(cur[0] > 0 && map[cur[0] - 1][cur[1]] == '.')
                            cur[0]--;
                        map[cur[0]][cur[1]] = '^';
                        break;
                    case 'D':
                        map[cur[0]][cur[1]] = '.';
                        if(cur[0] < h - 1 && map[cur[0] + 1][cur[1]] == '.')
                            cur[0]++;
                        map[cur[0]][cur[1]] = 'v';
                        break;
                    case 'L':
                        map[cur[0]][cur[1]] = '.';
                        if(cur[1] > 0 && map[cur[0]][cur[1] - 1] == '.')
                            cur[1]--;
                        map[cur[0]][cur[1]] = '<';
                        break;
                    case 'R':
                        map[cur[0]][cur[1]] = '.';
                        if(cur[1] < w - 1 && map[cur[0]][cur[1] + 1] == '.')
                            cur[1]++;
                        map[cur[0]][cur[1]] = '>';
                        break;
                }
            }

            //출력
            sb.append("#");
            sb.append(Ti + 1);
            sb.append(" ");

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            bw.write(sb.toString());
            sb.setLength(0);
        }

        bw.close();
    }
}