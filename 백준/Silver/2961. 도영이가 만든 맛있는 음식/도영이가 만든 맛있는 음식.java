import java.io.*;
import java.util.*;

public class Main {

    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] flavour = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            flavour[i][0] = Integer.parseInt(st.nextToken());
            flavour[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, flavour, 1, 0);

        bw.write(answer + "");
        bw.close();
    }

    public static void dfs(int depth, int[][] flavour, int sour, int bitter) {
        if(depth == flavour.length) {
            if(!(sour == 1 && bitter == 0))
                answer = Math.min(answer, Math.abs(sour - bitter));
            return;
        }
        dfs(depth + 1, flavour, sour * flavour[depth][0], bitter + flavour[depth][1]);
        dfs(depth + 1, flavour, sour, bitter);
    }

}