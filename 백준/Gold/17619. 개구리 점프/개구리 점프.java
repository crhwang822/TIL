import java.io.*;
import java.util.*;

public class Main {

    static int[] connected;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int x1, x2, y;
        int[][] trees = new int[n + 1][4];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            trees[i][0] = i;
            trees[i][1] = x1;
            trees[i][2] = x2;
            trees[i][3] = y;
        }

        Arrays.sort(trees, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //x1 기준 정렬
                if(o1[1] == o2[1]) {
                    return o1[2] - o2[2];
                }
                return o1[1] - o2[1];

            }
        });

        int[] connected = new int[n + 1];
        for(int i = 1; i < connected.length; i++) {
            connected[i] = i;
        }

        for(int i = 1; i < trees.length - 1; i++) {
            if(trees[i][2] >= trees[i + 1][1]) {
                connected[trees[i+1][0]] = trees[i][0];
                trees[i + 1][0] = trees[i][0];
                if (trees[i][2] > trees[i + 1][2])
                    trees[i + 1][2] = trees[i][2];
            }
        }

        int a, b;
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(connected[a] == connected[b]) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }

        bw.close();
    }

    public static int find(int x) {
        if(connected[x] != x) {
            connected[x] = find(connected[x]);
        }
        return connected[x];
    }
}