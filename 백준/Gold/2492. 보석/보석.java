import java.io.*;
import java.util.*;

public class Main {

    public static int answer = 0;
    public static int xi = -1;
    public static int yi = -1;

    public static void main(String[] args) throws FileNotFoundException, IOException {
//		System.setIn(new FileInputStream("Test4.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] points = new int[t][2];

        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            points[i][0] = c;
            points[i][1] = r;
        }

        //x, y 정렬
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });


        for(int s = 0; s < t; s++) {
            int x = points[s][0];
            int y = points[s][1];
            int e = s;
            for(int j = s + 1; j < t; j++) {
                if(points[j][0] <= x + k) {
                    e++;
                }

            }

            for(int j = s; j <= e; j++) {
                int temp = 0;
                for(int l = s; l <= e; l++) {
                    if(points[j][1] <= points[l][1] && points[j][1] + k >= points[l][1]) {
                        temp++;
                    }
                }
                if(temp > answer) {
                    answer = temp;
                    xi = s;
                    yi = j;
                }
            }
        }


        int ansX = Math.min(n - k, points[xi][0]);
        int ansY = Math.min(m, points[yi][1]  + k);
        bw.write(ansX + " " + ansY + "\n");
        bw.write(answer + "");
        bw.close();

    }

}