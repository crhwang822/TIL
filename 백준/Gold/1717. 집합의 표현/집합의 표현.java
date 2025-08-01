import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parent = new int[n+1];
        for(int i = 1; i < parent.length; i++)
            parent[i] = i;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int ap = find(parent, a);
            int bp = find(parent, b);

            if(op.equals("0")) {
                parent[bp] = ap;
            } else if(op.equals("1")) {
                if(bp == ap)
                    bw.write("yes\n");
                else
                    bw.write("no\n");
            }

        }
        bw.close();
    }

    public static int find(int[] parent, int x) {
        if(parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}