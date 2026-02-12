import java.io.*;
import java.util.*;


public class Main {

    public static int[] parent;

    public static void main(String[] args) throws IOException{

        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 여초면 1 남초면 -1
        int[] universities = new int[n + 1];
        parent = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++) {
            parent[i] = i;

            String univ = st.nextToken();
            if(univ.equals("W")) {
                universities[i] = 1;
            } else {
                universities[i] = -1;
            }
        }


        // 거리 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int u, v, d;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            pq.add(new int[]{u, v, d});
        }

        // union-find
        int[] e;
        while(!pq.isEmpty()) {
            e = pq.poll();
            u = e[0];
            v = e[1];
            d = e[2];

            // 남초-남초 혹은 여초-여초를 잇는 도로인 경우
            if(universities[u] * universities[v] > 0) {
                continue;
            }

            int up = find(u);
            int vp = find(v);

            if(up != vp) {
                answer += d;
                parent[up] = parent[vp];
            }
        }

        for(int i = 2; i < parent.length; i++) {
            if(find(i) != find(i - 1)) {
                answer = -1;
                break;
            }
        }

        System.out.println(answer);


    }

    public static int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}