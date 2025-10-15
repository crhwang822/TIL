import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int x, y, z;
        int xp, yp;
        int[] parent;

        int before, after;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        while (m != 0 || n != 0) {
            pq.clear();
            before = 0;
            after = 0;
            parent = new int[m + 1];
            for (int i = 1; i < parent.length; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                z = Integer.parseInt(st.nextToken());

                pq.add(new int[]{x, y, z});
                before += z;
            }

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                x = cur[0];
                y = cur[1];
                z = cur[2];
                xp = find(x, parent);
                yp = find(y, parent);

                if (xp != yp) {
                    parent[yp] = xp;
                    after += z;
                }

            }

            sb.append(before - after);
            sb.append("\n");

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
        }

        bw.write(sb.toString());

        bw.close();
    }

    public static int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
}

