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
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int answer = 0;
        int cnt = 0;

        int[] parent = new int[v + 1];
        for(int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        Collections.sort(list, (o1, o2) -> o1[2] - o2[2]);


        for(int i = 0; i < e; i++) {
            int a = list.get(i)[0];
            int b = list.get(i)[1];
            int ap = find(parent, a);
            int bp = find(parent, b);
            if(ap != bp) {
              parent[ap] = bp;
              answer += list.get(i)[2];
              if(++cnt == e - 1)
                  break;
            }
        }

        bw.write(answer + "");
        bw.close();
    }

    public static int find(int[] parent, int x) {
        if(parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}