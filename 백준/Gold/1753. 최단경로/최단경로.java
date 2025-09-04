import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        int[] dist = new int[v + 1];
        ArrayList<Node>[] graph = new ArrayList[v + 1];
        for(int i = 1; i < v + 1; i++) { //v <= 20,000
            graph[i] = new ArrayList<>();
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);

        for(int i = 0; i < e; i++) { //e <= 300,000
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, w));
        }

        dist[k] = 0;
        pq.add(new int[]{k, 0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(dist[cur[0]] < cur[1])
                continue;
            for(Node n : graph[cur[0]]) {
                int num = n.num;
                if(dist[num] > dist[cur[0]] + n.weight) {
                    dist[num] = dist[cur[0]] + n.weight;
                    pq.add(new int[]{num, dist[num]});
                }
            }
        }

        for(int i = 1; i < dist.length; i++) { //v <= 20,000
            if(dist[i] == Integer.MAX_VALUE) {
                sb.append("INF");
            } else sb.append(dist[i]);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
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
