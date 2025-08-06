import java.io.*;
import java.util.*;

public class Main {

    public static int colors[] = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(paper, n, 0, 0);

        bw.write(colors[0] + "\n" + colors[1]);
        bw.close();
    }

    public static void cut(int[][] paper, int len, int x, int y) {

        if(len == 1) {
            colors[paper[x][y]]++;
            return;
        }

        int c = paper[x][y];
        for(int i = x; i < x + len; i++) {
            for(int j = y; j < y + len; j++) {
                if(paper[i][j] != c) {
                    cut(paper, len / 2, x, y);
                    cut(paper, len / 2, x + len / 2, y);
                    cut(paper, len / 2, x, y + len / 2);
                    cut(paper, len / 2, x + len / 2, y + len / 2);
                    return;

                }
            }
        }

        colors[paper[x][y]] ++;
    }
}