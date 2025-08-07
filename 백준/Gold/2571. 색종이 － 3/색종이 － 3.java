import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] paper = new int[100][100];
        int n = Integer.parseInt(br.readLine());

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

        int[][] next = new int[101][101];
        int[][] down = new int[101][101];
        for(int i = 99; i >= 0; i--) {
            for(int j = 99; j >= 0; j--) {
                if(paper[i][j] == 1) {
                    if(next[i][j+1] == 0)
                        next[i][j] = 1;
                    else if(next[i][j+1] != 0)
                        next[i][j] = next[i][j+1] + 1;
                    if(down[i+1][j] == 0)
                        down[i][j] = 1;
                    else if(down[i+1][j] != 0)
                        down[i][j] = down[i+1][j] + 1;
                }
            }
        }

        int answer = 0;

        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(paper[i][j] == 1) {
                    int h = down[i][j];
                    int w = 1;
                    for(int k = 0; k < next[i][j]; k++) {
                        h = Math.min(h, down[i][j + k]);
                        answer = Math.max(answer, h * (w+k));
                    }
                }
            }
        }

        bw.write(answer + "");
        bw.close();
    }

}