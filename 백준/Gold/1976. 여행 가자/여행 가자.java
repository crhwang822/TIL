import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean flag = true;

        int[] parent = new int[n];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i; j++) {
                int isConnected = Integer.parseInt(st.nextToken());
                int iParent = find(parent, i);
                int jParent = find(parent, j);
                if(isConnected == 1 &&  iParent != jParent) {
                    parent[iParent] = jParent;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] visit = new int[m];

        for(int i = 0; i < m; i++) {
            visit[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        for(int i = 0; i < visit.length - 1; i++) {
            if(find(parent, visit[i]) != find(parent, visit[i+1])) {
                flag = false;
                break;
            }
        }

        if(flag)
            bw.write("YES\n");
        else bw.write("NO\n");

        bw.close();
    }

    public static int find(int[] parent, int x) {
        if(parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

}
