import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] video = new int[n][n];
        for(int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for(int j = 0; j < n; j++) {
                video[i][j] = Integer.parseInt(temp[j]);
            }
        }

        String str = func(video, 0, 0, n);

        bw.write(str);
        bw.close();
    }

    public static String func(int[][] video, int r, int c, int len) {
        int prev = video[r][c];
        boolean flag = false;
        for(int i = r; i < r + len; i++) {
            for(int j = c; j < c + len; j++) {
                if(prev != video[i][j]) {
                    flag = true;
                    break;
                }
                prev = video[i][j];
            }
            if(flag)
                break;
        }

        String str = "";
        if(flag) {
            str += "(";
            str += func(video, r, c, len/2);
            str += func(video, r, c + len/2, len/2);
            str += func(video, r + len/2, c, len/2);
            str += func(video, r + len/2, c + len/2, len/2);
            str += ")";
        } else
            str += prev;

        return str;
    }
}
