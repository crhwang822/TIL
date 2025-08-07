import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] map = new int[r][c];

        for(int i = 0; i < r; i++) {
            String[] arr = br.readLine().split("");
            for(int j = 0; j < c; j++) {
                String s = arr[j];
                if(s.equals("x")) {
                    map[i][j] = -1;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        int answer = 0;
        boolean[][] visited = new boolean[r][c];
        for(int i = 0; i < r; i++) {
            if(dfs(map, visited, i, 0))
                answer++;
        }


        bw.write(answer + "");
        bw.close();
    }

    public static boolean dfs(int[][] map, boolean[][] visited,int r, int c) {
        if(c == map[0].length - 1)
            return true;

        if(r > 0 && map[r-1][c] == 0 && !visited[r-1][c]) {
            visited[r-1][c] = true;
            if(dfs(map, visited, r-1, c + 1))
                return true;
        }

        if(map[r][c] == 0 && !visited[r][c]) {
            visited[r][c] = true;
            if(dfs(map, visited, r, c + 1))
                return true;
        }

        if(r < map.length - 1 && map[r+1][c] == 0) {
            visited[r+1][c] = true;
            return dfs(map, visited, r + 1, c + 1);
        }

        return false;
    }

}