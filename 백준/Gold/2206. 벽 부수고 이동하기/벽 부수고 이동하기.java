import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = -1;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][][] visited = new boolean[n][m][2];

        for(int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        visited[0][0][1] = true;
        pq.add(new int[]{0, 0, 1, 1});

        int r, c, distance, opportunity;
        while(!pq.isEmpty()) {
            int[] arr = pq.poll();
            r = arr[0];
            c = arr[1];
            distance = arr[2];
            opportunity = arr[3];

            if(r == n - 1 && c == m - 1) {
                answer = distance;
                break;
            }

            //상
            if(r > 0) {
                if(map[r - 1][c] == 0 && !visited[r - 1][c][opportunity]) {
                    visited[r - 1][c][opportunity] = true;
                    pq.add(new int[]{r - 1, c, distance + 1, opportunity});
                }
                if(map[r - 1][c] == 1 && opportunity > 0 && !visited[r - 1][c][opportunity - 1]) {
                    visited[r - 1][c][opportunity - 1] = true;
                    pq.add(new int[]{r - 1, c, distance + 1, opportunity - 1});
                }
            }

            //하
            if(r < n - 1) {
                if(map[r + 1][c] == 0 && !visited[r + 1][c][opportunity]) {
                    visited[r + 1][c][opportunity] = true;
                    pq.add(new int[]{r + 1, c, distance + 1, opportunity});
                }
                if(map[r + 1][c] == 1 && opportunity > 0 && !visited[r + 1][c][opportunity - 1]) {
                    visited[r + 1][c][opportunity - 1] = true;
                    pq.add(new int[]{r + 1, c, distance + 1, opportunity - 1});
                }
            }

            //좌
            if(c > 0) {
                if(map[r][c - 1] == 0 && !visited[r][c - 1][opportunity]) {
                    visited[r][c - 1][opportunity] = true;
                    pq.add(new int[]{r, c - 1, distance + 1, opportunity});
                }
                if(map[r][c - 1] == 1 && opportunity > 0 && !visited[r][c - 1][opportunity - 1]) {
                    visited[r][c - 1][opportunity - 1] = true;
                    pq.add(new int[]{r, c - 1, distance + 1, opportunity - 1});
                }
            }

            //우
            if(c < m - 1) {
                    if(map[r][c + 1] == 0 && !visited[r][c + 1][opportunity]) {
                        visited[r][c + 1][opportunity] = true;
                        pq.add(new int[]{r, c + 1, distance + 1, opportunity});
                    }
                    if(map[r][c + 1] == 1 && opportunity > 0 && !visited[r][c + 1][opportunity - 1]) {
                        visited[r][c + 1][opportunity - 1] = true;
                        pq.add(new int[]{r, c + 1, distance + 1, opportunity - 1});
                    }
            }
        }

        bw.write(answer + "");
        bw.close();

    }
}