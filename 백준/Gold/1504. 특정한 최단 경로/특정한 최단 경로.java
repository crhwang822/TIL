import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int e;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //정점 개수
        e = Integer.parseInt(st.nextToken()); //간선 개수

        dist = new int[n + 1];

        graph = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++)
            graph[i] = new ArrayList<>();

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[][] ways = new int[][]{{1, v1, v2, n}, {1, v2, v1, n}};
        int[] ans = new int[2];

        for(int i = 0; i < ways.length; i++) {
            for(int j = 0; j < ways[i].length - 1; j++) {
                int temp = dijkstra(ways[i][j], ways[i][j + 1]);
                if(temp == -1) {
                    ans[i] = -1;
                    break;
                }
                ans[i] += temp;
            }
        }

        if(ans[0] == -1 && ans[1] == -1)
            bw.write("-1");
        else if(ans[0] == -1 || ans[1] == -1)
            bw.write(Math.max(ans[0], ans[1]) + "");
        else bw.write(Math.min(ans[0], ans[1]) + "");


        bw.close();
    }

    static int dijkstra(int start, int end) {
        pq.clear();
        pq.add(new int[]{start, 0});
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(dist[cur[0]] < cur[1])
                continue;
            if(cur[0] == end)
                break;
            for(Node n : graph[cur[0]]) {
                int num = n.num;
                if(dist[num] > dist[cur[0]] + n.weight) {
                    dist[num] = dist[cur[0]] + n.weight;
                    pq.add(new int[]{num, dist[num]});
                }
            }
        }

        if(dist[end] == Integer.MAX_VALUE)
            return -1;

        return dist[end];
    }

    static class Node {
        int num;
        int weight;
        Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

}
