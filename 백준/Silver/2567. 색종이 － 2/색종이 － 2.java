import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[100][100];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k < 10; k++) {
                    paper[99 - y - j][x + k] = 1;
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(paper[i][j] == 1) {
                    if((j > 0 && paper[i][j - 1] == 0) || j == 0)
                        answer++;
                    if((j < 99 && paper[i][j + 1] == 0) || j == 99)
                        answer++;
                    if((i > 0 && paper[i - 1][j] == 0) || i == 0)
                        answer++;
                    if((i < 99 && paper[i + 1][j] == 0) || i == 99)
                        answer++;
                }
            }
        }

        bw.write(answer + "");
        bw.close();
    }

}