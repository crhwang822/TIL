import java.io.*;
        import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] lines = new int[n][2];

        int x, y;
        for(int i = 0; i < n; i++) {  //10^6
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            lines[i] = new int[]{x, y};
        }

        Arrays.sort(lines, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        long answer = lines[0][1] - lines[0][0];
        for(int i = 1; i < lines.length; i++) {
            if(lines[i][0] <= lines[i - 1][1]) {
                lines[i][1] = Math.max(lines[i][1], lines[i - 1][1]);
                answer += lines[i][1] - lines[i - 1][1];
            } else if(lines[i][0] > lines[i - 1][1]) {
                answer += lines[i][1] - lines[i][0];
            }
        }

        bw.write(answer + "");



        bw.close();

    }
}