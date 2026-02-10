import java.io.*;
import java.util.*;

public class Main {

    static final long INF = Long.MAX_VALUE / 4;

    static class Node implements Comparable<Node> {
        int r, c;
        long dist;
        Node(int r, int c, long dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
        @Override
        public int compareTo(Node o) {
            return Long.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char ch = str.charAt(j);
                if ('A' <= ch && ch <= 'Z') map[i][j] = ch - 'A';
                else map[i][j] = ch - 'a' + 26;
            }
        }

        long[][] go = dijkstraGo(map, n, m, t);
        long[][] back = dijkstraBack(map, n, m, t); // 역간선 비용으로 (0,0)->각점 = 각점->(0,0)

        int ans = map[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (go[i][j] >= INF || back[i][j] >= INF) continue;
                if (go[i][j] + back[i][j] <= d) {
                    ans = Math.max(ans, map[i][j]);
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }

    // (0,0) -> (r,c) 최소시간 (원래 규칙 그대로)
    static long[][] dijkstraGo(int[][] map, int n, int m, int t) {
        long[][] dist = new long[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], INF);
        dist[0][0] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int r = cur.r, c = cur.c;
            if (cur.dist != dist[r][c]) continue;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;

                int delta = map[nr][nc] - map[r][c]; // 방향성 유지
                int ad = Math.abs(delta);
                if (ad > t) continue;

                long cost = (delta > 0) ? (long) ad * ad : 1L;
                long nd = dist[r][c] + cost;
                if (nd < dist[nr][nc]) {
                    dist[nr][nc] = nd;
                    pq.add(new Node(nr, nc, nd));
                }
            }
        }
        return dist;
    }

    // 각점 -> (0,0) 최소시간을 구하기 위해 "역간선" 비용으로 (0,0)->각점 다익스트라
    static long[][] dijkstraBack(int[][] map, int n, int m, int t) {
        long[][] dist = new long[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], INF);
        dist[0][0] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int r = cur.r, c = cur.c;
            if (cur.dist != dist[r][c]) continue;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;

                // 역간선: (nr,nc) -> (r,c) 의 이동비용을 dist[r][c]에서 nr,nc로 전파
                int delta = map[r][c] - map[nr][nc]; // (nr,nc)->(r,c)의 delta
                int ad = Math.abs(delta);
                if (ad > t) continue;

                long cost = (delta > 0) ? (long) ad * ad : 1L; // 오르막이면 제곱, 아니면 1
                long nd = dist[r][c] + cost;
                if (nd < dist[nr][nc]) {
                    dist[nr][nc] = nd;
                    pq.add(new Node(nr, nc, nd));
                }
            }
        }
        return dist;
    }
}
