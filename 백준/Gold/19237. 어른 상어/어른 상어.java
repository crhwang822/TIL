import java.io.*;
import java.util.*;

public class Main {

    public static int[] dr = {0, -1, 1, 0, 0};
    public static int[] dc = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int time = 0;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][][] scent = new int[n][n][3];
        int[][] sharks = new int[m + 1][3];
        int[][][] dirs = new int[m + 1][5][4];

        //map
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num != 0) {
                    sharks[num][0] = i;
                    sharks[num][1] = j;
                    scent[i][j][0] = num;
                    scent[i][j][1] = time;
                }
            }
        }

        //각 상어가 바라보고있는 방향
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            sharks[i + 1][2] = Integer.parseInt(st.nextToken());
        }

        //각 상어의 방향별 우선순위
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= 4; j++) {
                st = new StringTokenizer(br.readLine());
                for(int q = 0; q < 4; q++) {
                    dirs[i][j][q] = Integer.parseInt(st.nextToken());
                }
            }
        }
        //각 상어의 방향별 우선순위
//        for(int i = 1; i <= m; i++) {
//            for(int j = 1; j <= 4; j++) {
//                for(int q = 0; q < 4; q++) {
//                    System.out.print(dirs[i][j][q] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

        //시뮬레이션 시작
        List<Integer> out = new ArrayList<>();
        boolean flag;
        while(time < 1001 && out.size() < m - 1) { //1000
            time++;

            for(int i = 1; i < sharks.length; i++) {  //400 : 1번 상어부터 이동 시작
                flag = false;
                if(out.contains(i))
                    continue;

                int r = sharks[i][0];
                int c = sharks[i][1];
                int dir = sharks[i][2];

                //1. 인접한 칸에서 냄새가 없는 칸 찾기
                for(int j = 0; j < 4; j++) {
                    int nr = r + dr[dirs[i][dir][j]];
                    int nc = c + dc[dirs[i][dir][j]];

                    if(nr < 0 || nc < 0 || nr >= n || nc >= n) {
                        continue;
                    }

                    //앞 번호 상어가 이미 같은 시간대에 거기 존재하는 경우
                    if(scent[nr][nc][0] > 0 && scent[nr][nc][2] == 0 && time - scent[nr][nc][1] == 0) {
                        flag = true;
                        out.add(i);
                        break;
                    }


                    //냄새가 남아있는 구역
                    if(scent[nr][nc][0] > 0 && time - scent[nr][nc][1] <= k) {
                        continue;
                    }


                    //빈 구역인 경우
                    if(scent[nr][nc][0] == 0 || time - scent[nr][nc][1] > k) {
                        flag = true;

                        scent[nr][nc][0] = i;
                        scent[nr][nc][1] = time;
                        scent[nr][nc][2] = 0;
                        sharks[i][0] = nr;
                        sharks[i][1] = nc;
                        sharks[i][2] = dirs[i][dir][j];
                        break;
                    }
                }

                //1번에서 이동을 마쳤으면 다음 상어 이동
                if(flag) continue;

                //2. 인접한 칸 중 본인의 냄새가 나는 칸 찾기
                for(int j = 0; j < 4; j++) {
                    int nr = r + dr[dirs[i][dir][j]];
                    int nc = c + dc[dirs[i][dir][j]];
                    if(nr < 0 || nc < 0 || nr >= n || nc >= n) {
                        continue;
                    }
                    //본인 냄새가 나는 구역
                    if(scent[nr][nc][0] == i && time - scent[nr][nc][1] <= k) {
                        scent[nr][nc][1] = time;
                        scent[nr][nc][2] = 1;
                        sharks[i][0] = nr;
                        sharks[i][1] = nc;
                        sharks[i][2] = dirs[i][dir][j];
                        break;
                    }
                }
            }
        }

        if(time > 1000)
            time = -1;

        bw.write(time + "");
        bw.close();
    }

}