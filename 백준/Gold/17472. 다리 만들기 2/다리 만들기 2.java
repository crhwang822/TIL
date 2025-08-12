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

        //입력
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 0)
                    map[i][j] = 's';  //sea
                else map[i][j] = 'g';  //ground
            }
        }

        //섬 찾기
        int cnt = 0;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q= new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j]) continue;
                visited[i][j] = true;
                if(map[i][j] == 'g') {
                    q.add(new int[]{i, j});
                    cnt++;
                    while(!q.isEmpty()) {
                        int[] cur = q.poll();
                        map[cur[0]][cur[1]] = (char)('0' + cnt - 1);
                        if(cur[0] > 0 && map[cur[0] - 1][cur[1]] == 'g' && !visited[cur[0] - 1][cur[1]]) {
                            visited[cur[0] - 1][cur[1]] = true;
                            q.add(new int[]{cur[0] - 1, cur[1]});
                        }
                        if(cur[0] < n - 1 && map[cur[0] + 1][cur[1]] == 'g' && !visited[cur[0] + 1][cur[1]]) {
                            visited[cur[0] + 1][cur[1]] = true;
                            q.add(new int[]{cur[0] + 1, cur[1]});
                        }
                        if(cur[1] > 0 && map[cur[0]][cur[1] - 1] == 'g' && !visited[cur[0]][cur[1] - 1]) {
                            visited[cur[0]][cur[1] - 1] = true;
                            q.add(new int[]{cur[0], cur[1] - 1});
                        }
                        if(cur[1] < m - 1 && map[cur[0]][cur[1] + 1] == 'g' && !visited[cur[0]][cur[1] + 1]) {
                            visited[cur[0]][cur[1] + 1] = true;
                            q.add(new int[]{cur[0], cur[1] + 1});
                        }
                    }
                }
            }
        }

        //최단 길이를 갖는 간선 찾기
        int[][] dist = new int[cnt][cnt];
        int[] parent = new int[cnt];

        for(int i = 0; i < cnt; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            parent[i] = i;
        }

        for(int i = 0; i < n; i++) {  //10
            for(int j = 0; j < m; j++) {  //10
                if(map[i][j] != 's') {
                    char prev = map[i][j];
                    int distance = 0;
                    for(int k = j + 1; k < m; k++) {
                        if(map[i][k] == prev)
                            break;
                        if(map[i][k] == 's') {
                            distance++;
                        }
                        if(map[i][k] != 's' && map[i][k] != prev) {
                            if(distance > 1) {
                                dist[prev - '0'][map[i][k] - '0'] = Math.min(distance, dist[prev - '0'][map[i][k] - '0']);
                                dist[map[i][k] - '0'][prev - '0'] = Math.min(distance, dist[map[i][k] - '0'][prev - '0']);
                            }
                            break;
                        }
                    }
                }
            }
        }

        for(int j = 0; j < m; j++) {  //10
            for(int i = 0; i < n; i++) {  //10
                if(map[i][j] != 's') {
                    char prev = map[i][j];
                    int distance = 0;
                    for(int k = i + 1; k < n; k++) {
                        if(map[k][j] == prev)
                            break;
                        if(map[k][j] == 's') {
                            distance++;
                        } else if(map[k][j] != 's' && map[k][j] != prev) {
                            if(distance > 1) {
                                dist[prev - '0'][map[k][j] - '0'] = Math.min(distance, dist[prev - '0'][map[k][j] - '0']);
                                dist[map[k][j] - '0'][prev - '0'] = Math.min(distance, dist[map[k][j] - '0'][prev - '0']);
                            }
                            break;
                        }
                    }
                }
            }
        }

        //섬끼리 연결하기
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < cnt; i++) {
            for(int j = i + 1; j < cnt; j++) {
                if(dist[i][j] == Integer.MAX_VALUE) continue;
                list.add(new int[]{i, j, dist[i][j]});
            }
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int answer = 0;
        for(int i = 0; i < list.size(); i++) {
            int[] cur = list.get(i);
            int p1 = find(parent, cur[0]);
            int p2 = find(parent, cur[1]);
            if(p1 != p2) {
                parent[p1] = p2;
                answer += cur[2];
            }
        }

        //연결 안 된 섬이 있으면 -1 리턴
        for(int i = 0; i < cnt - 1; i++) {
            if(find(parent, i) != find(parent, i + 1)) {
                answer = -1;
                break;
            }
        }

        bw.write(answer + "");
        bw.close();
    }

    public static int find(int[] parent, int x) {
        if(parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}