import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<City>[] graph = new ArrayList[n + 1];
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        int from, to, cost;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            graph[from].add(new City(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        long[] dist = new long[n + 1];
        int[] prev = new int[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;
        prev[start] = -1;

        PriorityQueue<long[]> q = new PriorityQueue<>((a,b)-> Long.compare(a[1],b[1]));
        q.add(new long[]{start, dist[start], -1});

        while(!q.isEmpty()) {
            long[] cur = q.poll();
            int num = (int)cur[0];
            long c = cur[1];
            int p = (int)cur[2];

            if(dist[num] < c) continue;
            prev[num] = p;


            for(City next : graph[num]) {
                if(dist[num] + next.cost < dist[next.num])  {
                    dist[next.num] = dist[num] + next.cost;
                    q.add(new long[]{next.num, dist[next.num], num});
                }
            }
        }

        int index = end;
        List<Integer> path = new ArrayList<>();
        while(index != -1) {
            path.add(index);
            index = prev[index];
        }

        bw.write(dist[end] + "\n");
        bw.write(path.size() + "\n");

        for(int i = path.size() - 1; i >=0; i--) {
            sb.append(path.get(i));
            sb.append(" ");
        }

        bw.write(sb.toString());

        bw.close();
    }

    public static class City {
        int num;
        int cost;
        public City(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }
}

