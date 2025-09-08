import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] indegree = new int[n + 1];
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++)
            graph[i] = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            indegree[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i < n + 1; i++) {
            if(indegree[i] == 0)
                pq.add(i);
        }

        while(!pq.isEmpty()) {
            int num = pq.poll();
            sb.append(num);
            sb.append(" ");
            for(int next : graph[num]) {
                if(--indegree[next] == 0)
                    pq.add(next);
            }
        }

        bw.write(sb.toString());
        bw.close();
    }
}
