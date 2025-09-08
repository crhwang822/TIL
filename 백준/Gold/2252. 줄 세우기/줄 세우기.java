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
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[n + 1];
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            indegree[b] = indegree[b] + 1;
            list[a].add(b);
        }

        for(int i = 1; i < n + 1; i++) {
            if(indegree[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty()) {
            int num = q.poll();
            sb.append(num);
            sb.append(" ");
            for(int i = 0; i < list[num].size(); i++) {
                int next = list[num].get(i);
                if(--indegree[next] == 0)
                    q.add(next);
            }
        }

        bw.write(sb.toString());
        bw.close();
    }
}
