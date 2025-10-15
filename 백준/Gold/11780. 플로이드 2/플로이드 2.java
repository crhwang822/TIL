import java.io.*;
import java.util.*;

public class Main {

    public static StringBuilder sb;
    public static int[][] dist;
    public static int[][] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int a, b, c;

        dist = new int[n + 1][n + 1];
        path = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            Arrays.fill(path[i], 0);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (dist[a][b] > c) {
                dist[a][b] = c;
            }
        }

        //플로이드
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        if (dist[i][j] > dist[i][k] + dist[k][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                            path[i][j] = k;
                        }
                    }
                }
            }
        }

        //출력
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (dist[i][j] == Integer.MAX_VALUE)
                    sb.append("0");
                else
                    sb.append(dist[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        sb.setLength(0);

//        int cnt;
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < n + 1; j++) {
//                if (dist[i][j] == 0) {
//                    sb.append("0");
//                } else {
//                    sb.append(i);
//                    sb.append(" ");
//                    print(i, j);
//                    sb.append(j);
//
//                    cnt = sb.toString().trim().split(" ").length;
//                    sb.insert(0, " ");
//                    sb.insert(0, cnt);
//                }
//                bw.write(sb.toString());
//                bw.write("\n");
//                sb.setLength(0);
//            }
//        }

        // 경로 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 1) 자기 자신이거나 2) 도달 불가면 0
                if (i == j || dist[i][j] == Integer.MAX_VALUE) {
                    bw.write("0\n");
                    continue;
                }

                // 경로 복원: i -> (중간들) -> j
                List<Integer> route = new ArrayList<>();
                route.add(i);
                collectPath(i, j, route); // path[i][j]에는 '경유지 k'만 들어있다는 전제
                route.add(j);

                // 개수 + 노드 나열
                bw.write(route.size() + " ");
                for (int idx = 0; idx < route.size(); idx++) {
                    if (idx > 0) bw.write(" ");
                    bw.write(String.valueOf(route.get(idx)));
                }
                bw.write("\n");
            }
        }



//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < n + 1; j++) {
//                if (dist[i][j] == Integer.MAX_VALUE)
//                    sb.append("0");
//                else
//                    sb.append(path[i][j]);
//                sb.append(" ");
//            }
//            sb.append("\n");
//        }


        bw.close();
    }

    // 경유지 기반 경로 수집 (재귀)
    static void collectPath(int i, int j, List<Integer> out) {
        int k = path[i][j];
        if (k == 0) return;           // 더 쪼갤 경유지 없음
        collectPath(i, k, out);       // i -> k 사이
        out.add(k);                   // 가운데 경유지
        collectPath(k, j, out);       // k -> j 사이
    }

//    public static void print(int i, int j) {
//        int k = path[i][j];
//
//        if(k == 0)
//            return;
//
//
//        if (path[i][k] != 0)
//            print(i, k);
//
//        sb.append(k);
//        sb.append(" ");
//
//        if (path[k][j] != 0)
//            print(k, j);
//
//    }
}

