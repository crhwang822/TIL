import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());  // 1 <= n <= 100
        double[][] stars = new double[n][2]; // 별 좌표 저장
        double answer = 0;
        int cnt = 0;

        int[] parent = new int[n];
        for(int i = 1; i < n; i++)
            parent[i] = i;

        List<double[]> distance = new ArrayList<>(); //별 사이의 거리 <= 10000

        StringTokenizer st;

        //좌표 저장
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
        }

        //i번째 별과 j번째 별 사이의 거리 저장
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                double d = Math.sqrt(Math.pow(stars[i][0] - stars[j][0],2) + Math.pow(stars[i][1] - stars[j][1], 2));
                distance.add(new double[]{i, j, d});
            }
        }

        //별 사이의 거리를 기준으로 리스트 정렬
        Collections.sort(distance, (o1, o2) -> Double.compare(o1[2], o2[2]));

        for(int i = 0; i < distance.size(); i++) {
            int a = (int)distance.get(i)[0];
            int b = (int)distance.get(i)[1];
            int ap = find(parent, a);
            int bp = find(parent, b);
            if(ap != bp) {
                parent[ap] = bp;
                answer += distance.get(i)[2];
                if(++cnt == n - 1)
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