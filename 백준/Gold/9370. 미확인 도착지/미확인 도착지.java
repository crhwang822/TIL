import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int t;

    static int s;
    static int g;
    static int h;

    static int[] goals;
    static boolean[] isMin;
    static List<Integer> answer = new ArrayList<>();
    static ArrayList<Node>[] graph;

    static int[] dist;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());



        for(int Ti = 0; Ti < T; Ti++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            answer.clear();
            goals = new int[t];
            isMin = new boolean[t];
            dist = new int[n + 1];
            graph = new ArrayList[n + 1];
            for(int i = 1; i < n + 1; i++)
                graph[i] = new ArrayList<>();

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph[a].add(new Node(b,d));
                graph[b].add(new Node(a,d));
            }

            for(int i = 0; i < t; i++) {
                goals[i] = Integer.parseInt(br.readLine());
            }

            for(int i = 0; i < t; i++) {
                int goal = goals[i];
                int minD = dijkstra(s, goal);
                int sg = dijkstra(s, g);
                int gh = dijkstra(g, h);
                int he = dijkstra(h, goal);
                if(minD ==  sg + gh + he && sg != -1 && he != -1) {
                    isMin[i] = true;
                    continue;
                }
                int sh = dijkstra(s, h);
                int ge = dijkstra(g, goal);
                if (minD ==  + sh + gh + ge && sh != -1 && ge != -1) {
                    isMin[i] = true;
                }
            }

            for(int i = 0; i < isMin.length; i++) {
                if(isMin[i]) {
                    answer.add(goals[i]);
                }
            }

            Collections.sort(answer);
            for(int ans : answer) {
                sb.append(ans);
                sb.append(" ");
            }
            sb.append("\n");
        }


        bw.write(sb.toString());
        bw.close();
    }

    static int dijkstra(int start, int end) {
        pq.clear();
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new int[]{start, dist[start]});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(cur[1] < dist[cur[0]])
                continue;
            if(cur[0] == end)
                break;
            for(Node n : graph[cur[0]]) {
                if(dist[n.num] > dist[cur[0]] + n.weight) {
                    dist[n.num] = dist[cur[0]] + n.weight;
                    pq.add(new int[]{n.num, dist[n.num]});
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
