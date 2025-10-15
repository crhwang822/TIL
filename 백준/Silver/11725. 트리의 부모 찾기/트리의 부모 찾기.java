import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] parent = new int[n + 1];
        for (int i = 1; i < parent.length; i++)
            parent[i] = i;

        ArrayList<Integer>[] conn = new ArrayList[n + 1];
        for (int i = 1; i < conn.length; i++)
            conn[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            conn[a].add(b);
            conn[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            int num = q.poll();
            for (int i = 0; i < conn[num].size(); i++) {
                int child = conn[num].get(i);
                if (parent[child] == child && parent[child] != 1) {
                    parent[child] = num;
                    q.add(child);
                }
            }
        }

        //출력
        for (int i = 2; i < parent.length; i++) {
            sb.append(parent[i]);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}

