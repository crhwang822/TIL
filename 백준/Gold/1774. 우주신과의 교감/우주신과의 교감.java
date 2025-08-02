import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] pos = new int[n+1][2];
        List<double[]> distance = new ArrayList<>();

        int[] parent = new int[n+1];
        for(int i = 1; i < parent.length; i++)
            parent[i] = i;

        for(int i = 1; i < pos.length; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(parent, a, b);
        }

        for(int i = 1; i < pos.length; i++) {
            for(int j = i + 1; j < pos.length; j++) {
                double d = Math.sqrt(Math.pow(pos[i][0] - pos[j][0], 2) + Math.pow(pos[i][1] - pos[j][1], 2));
                distance.add(new double[]{i, j, d});
            }
        }

        Collections.sort(distance, (o1, o2) -> Double.compare(o1[2], o2[2]));

        double answer = 0;
        for(int i = 0; i < distance.size(); i++) {
            int a = (int)distance.get(i)[0];
            int b = (int)distance.get(i)[1];
            if(union(parent, a, b)) {
                answer += distance.get(i)[2];
            }
        }


            bw.write(String.format("%.2f", answer));
        bw.close();
    }

    public static boolean union(int[] parent, int a, int b) {
        int ap = find(parent, a);
        int bp = find(parent, b);
        if(ap != bp) {
            parent[ap] = bp;
            return true;
        }
        return false;
    }

    public static int find(int[] parent, int x) {
        if(parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}