import java.io.*;
import java.util.*;

//SWEA
public class Solution {

    public static int N;
    public static int length;
    public static int connections;
    public static int[][] map;
    public static List<int[]> cores = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        //테스트케이스 시작
        for(int Ti = 1; Ti <= T; Ti++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            length = Integer.MAX_VALUE;
            cores.clear();
            connections = 0;

            //지도 입력
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++)  {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1) {
                        cores.add(new int[]{i, j});
                    }
                }
            }

            dfs(0, 0, 0);

            //출력
            sb.append("#");
            sb.append(Ti);
            sb.append(" ");
            sb.append(length);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

    public static void dfs(int depth, int len, int cnt) {
        if(depth == cores.size()) {
            if(cnt > connections) {
                connections = cnt;
                length = len;
            } else if (cnt == connections){
                length = Math.min(length, len);
            }
            return;
        }

        boolean flag;
        int[] temp;

        int r = cores.get(depth)[0];
        int c = cores.get(depth)[1];

        if(r == 0 || r == N - 1 || c == 0 || c == N - 1) {
            dfs(depth + 1, len, cnt + 1);

        } else {
            //해당 코어에 전선을 연결하지 않음
            dfs(depth + 1, len, cnt);
            //해당 코어 윗방향으로 전선 설치
            flag = true;
            for(int i = r - 1; i >= 0; i--) {
                if(map[i][c] != 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                for(int i = r - 1; i >= 0; i--) {
                    map[i][c] = 2;
                }
                dfs(depth + 1,  len + r, cnt + 1);
                for(int i = r - 1; i >= 0; i--) {
                    map[i][c] = 0;
                }
            }


            //해당 코어 아래 방향으로 전선 설치
            flag = true;
            for(int i = r + 1; i < N; i++) {
                if(map[i][c] != 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                for(int i = r + 1; i < N; i++)  {
                    map[i][c] = 2;
                }
                dfs(depth + 1, len + (N - 1 - r), cnt + 1);
                for(int i = r + 1; i < N; i++)  {
                    map[i][c] = 0;
                }
            }

            //해당 코어 왼쪽 방향으로 전선 설치
            flag = true;
            temp = map[r].clone();
            for(int j = c - 1; j >= 0; j--) {
                if(map[r][j] == 0) {
                    map[r][j] = 2;
                } else {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                dfs(depth + 1, len + c, cnt + 1);
            }
            map[r] = temp;

            //해당 코어 오른쪽 방향으로 전선 설치
            flag = true;
            temp = map[r].clone();
            for(int j = c + 1; j < N; j++) {
                if(map[r][j] == 0) {
                    map[r][j] = 2;
                } else {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                dfs(depth + 1, len + (N - 1 - c), cnt + 1);
            }
            map[r] = temp;
        }
    }
}
