import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] arr;
        Queue<Integer> q = new LinkedList<>();
        int[] colors;
        boolean flag;

        for(int testCase = 0; testCase < k; testCase++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            if(V == 2 && E == 1) {
                bw.write("NO\n");
                continue;
            }

            arr = new ArrayList[V + 1];
            for(int i = 1; i < arr.length; i++) {
                arr[i] = new ArrayList<>();
            }

            q.clear();
            flag = true;
            colors = new int[V + 1];

            for(int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[u].add(v);
                arr[v].add(u);
            }

            int cnt = 1;
            int num;
            List<Integer> list;
            for(int i = 1; i < V + 1; i++) {
                //모든 정점에 대해 해당 정점을 아직 방문 안 했으면
                if(colors[i] == 0) {
                    q.add(i);
                    colors[i] = cnt++;
                    while(!q.isEmpty()) {
                        num = q.poll();
                        list = arr[num];

                        for(int neighbor : list) {
                            if(colors[neighbor] == 0) {
                                colors[neighbor] = colors[num] * -1;
                                q.add(neighbor);
                            } else if(colors[neighbor] == colors[num]) {
                                flag = false;
                                break;
                            }
                        }
                        if(!flag) break;
                    }
                }
            }

            if(!flag) {
                bw.write("NO\n");
            } else {
                bw.write("YES\n");
            }
        }

        bw.close();
    }
}