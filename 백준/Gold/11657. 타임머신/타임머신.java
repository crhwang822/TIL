import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Edge> edges = new ArrayList<>();
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[1] = 0;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start, end, weight));
        }

        boolean minusCycle = false;

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < edges.size(); j++) {
                Edge edge = edges.get(j);
                if(dist[edge.start] == Long.MAX_VALUE)
                    continue;
                if(dist[edge.end] > dist[edge.start] + edge.weight) {
                    dist[edge.end] = dist[edge.start] + edge.weight;
                    if(i == N) {
                        minusCycle = true;
                        break;
                    }
                }
            }
            if(minusCycle)
                break;
        }

        if(minusCycle) {
            sb.append("-1");
        } else {
            for(int i = 2; i < dist.length; i++) {
                if(dist[i] == Long.MAX_VALUE)
                    sb.append("-1");
                else sb.append(dist[i]);
                sb.append("\n");
            }
        }


        bw.write(sb.toString().trim());
        bw.close();
    }

    static class Edge {
        int start;
        int end;
        int weight;
        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
