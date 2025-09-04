import java.io.*;
import java.util.*;

public class Main {
    static int n;  //<=100,000
    static int k;  //<=100,000
    static int[] dist;
    static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //정점 개수
        k = Integer.parseInt(st.nextToken()); //간선 개수
        dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;

        pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        pq.add(new int[]{n, dist[n]});

        int[] cur;
        int pos;
        int time;
        while(!pq.isEmpty()) {
            cur = pq.poll();
            pos = cur[0];
            time = cur[1];

            if(dist[pos] < time)
                continue;

            if(pos == k)
                break;

            if(pos > 0 && dist[pos - 1] > time + 1) {
                dist[pos - 1] = time + 1;
                pq.add(new int[]{pos - 1, dist[pos - 1]});
            }

            if(pos < dist.length - 1 && dist[pos + 1] > time + 1) {
                dist[pos + 1] = time + 1;
                pq.add(new int[]{pos + 1, dist[pos + 1]});
            }


            if(pos < 50001 && dist[pos * 2] > time) {
                dist[pos * 2] = time;
                pq.add(new int[]{pos * 2, dist[pos * 2]});
            }
        }

        bw.write(dist[k] + "");
        bw.close();
    }
}
