import java.io.*;
import java.util.*;

//SWEA
public class Solution {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        double price;
        int n;
        double e;
        int[][] islands;
        List<double[]> edges = new ArrayList<>();

        //테스트케이스 시작
        for(int Ti = 1; Ti <= T; Ti++) {
            price = 0;
            n = Integer.parseInt(br.readLine());
            islands = new int[n][2];
            parent = new int[n];
            edges.clear();

            //입력
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                islands[i][0] = Integer.parseInt(st.nextToken());
                parent[i] = i;
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                islands[i][1] = Integer.parseInt(st.nextToken());
            }

            e = Double.parseDouble(br.readLine());

            //모든 간선의 비용 구하기
            for(int i = 0; i < n - 1; i++) {
                for(int j = i + 1; j < n; j++) {
                    double l = Math.sqrt(Math.pow(islands[i][0] - islands[j][0], 2) + Math.pow(islands[i][1] - islands[j][1], 2));
                    edges.add(new double[]{i, j, e * Math.pow(l, 2)});
                }
            }

            //간선을 오름차순으로 정렬
            Collections.sort(edges, (o1, o2) -> Double.compare(o1[2], o2[2]));

            //섬 연결 (union-find)
            for(int i = 0; i < edges.size(); i++) {
                double[] edge = edges.get(i);
                int a = (int)edge[0];
                int b = (int)edge[1];

                int ap = find(a);
                int bp = find(b);

                if(ap != bp) {
                    if(a < b)
                        parent[ap] = bp;
                    else
                        parent[bp] = ap;
                    price += edge[2];
                }
            }

            //출력
            sb.append("#");
            sb.append(Ti);
            sb.append(" ");
            //소수 첫째 자리에서 반올림
            long ans = Math.round(price);
            sb.append(ans);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

    public static int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
