import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int testCase = 1;
        int T = 0;
        int[] parent;
        int u, v, up, vp;
        Set<Integer> set = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        while(n != 0 || m != 0) {

            set.clear();
            cycle.clear();
            parent = new int[n + 1];

            for(int i = 1; i < parent.length; i++) {
                parent[i] = i;
            }


            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());


                up = find(parent, u);
                vp = find(parent, v);

                if(up == vp) {
                    cycle.add(up);
                }

                parent[find(parent, u)] = find(parent, v);
            }

            for(int i = 1; i < parent.length; i++) {
                set.add(find(parent, i));
            }

            for(int o : cycle) {
                set.remove(find(parent, o));
            }


            sb.append("Case ");
            sb.append(testCase++);
            sb.append(": ");
            if(set.isEmpty()) {
                sb.append("No trees.");
            } else if(set.size() == 1) {
                sb.append("There is one tree.");
            } else {
                sb.append("A forest of ");
                sb.append(set.size());
                sb.append(" trees.");
            }

            sb.append("\n");
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
        }


        System.out.print(sb);
    }

    public static int find(int[] parent, int x) {
        if(parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}