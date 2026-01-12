import java.io.*;
import java.util.*;

public class Main {

    static String[][] field = new String[12][6];
    static boolean[][] visited = new boolean[12][6];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        for(int i = 0; i < field.length; i++) {
            field[i] = br.readLine().split("");
        }

        boolean flag;
        int answer = -1;

        do {
            answer++;

            //초기화
            flag = false;
            for(int i = 0; i < visited.length; i++)
                Arrays.fill(visited[i], false);

            for(int i = 0; i < field.length; i++) {
                for(int j = 0; j < field[i].length; j++) {
                    if(visited[i][j] || field[i][j].equals(".")) {
                        continue;
                    }

                    visited[i][j] = true;
                    int cnt = dfs(i,j);
                    if(cnt >= 4) {
//                        System.out.println(i + " " + j);
                        flag = true;
                        //삭제 표시
                        mark(i, j);
                    }
                }
            }

            //삭제

            for(int j = 0; j < 6; j++) {
                int r1 = 11;
                while(r1 > 0) {
                    int r2 = r1 - 1;
                    if(field[r1][j].equals(".")) {
                        while(field[r2][j].equals(".") && r2 > 0) r2--;
                        field[r1][j] = field[r2][j];
                        field[r2][j] = ".";
                    }
                    r1--;
                }
            }


        } while(flag);

        bw.write(answer + "");
        bw.close();
    }

    public static int dfs(int r, int c) {
        int cnt = 1;
        if(r > 0 && !visited[r - 1][c] && field[r][c].equals(field[r - 1][c])) {
            visited[r - 1][c] = true;
            cnt += dfs(r - 1, c);
        }

        if(r < 11 && !visited[r + 1][c] && field[r][c].equals(field[r + 1][c])) {
            visited[r + 1][c] = true;
            cnt += dfs(r + 1, c);
        }

        if(c > 0 && !visited[r][c - 1] && field[r][c].equals(field[r][c - 1])) {
            visited[r][c - 1] = true;
            cnt += dfs(r, c - 1);
        }

        if(c < 5 && !visited[r][c + 1] && field[r][c].equals(field[r][c + 1])) {
            visited[r][c + 1] = true;
            cnt += dfs(r, c + 1);
        }
        return cnt;
    }

    public static void mark(int r, int c) {
        String color = field[r][c];
        field[r][c] = ".";

        if(r > 0  && color.equals(field[r - 1][c])) {
            mark(r - 1, c);
        }

        if(r < 11  && color.equals(field[r + 1][c])) {
            mark(r + 1, c);
        }

        if(c > 0 && color.equals(field[r][c - 1])) {
            mark(r, c - 1);
        }

        if(c < 5  && color.equals(field[r][c + 1])) {
            mark(r, c + 1);
        }
    }
}