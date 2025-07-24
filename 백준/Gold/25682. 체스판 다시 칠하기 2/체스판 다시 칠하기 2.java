import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] board = new String[n];
        int[][] bTable = new int[n+1][m+1];
        int[][] wTable = new int[n+1][m+1];

        for(int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }

        char[] color = new char[]{'B','W'};
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < m+1; j++) {
                if(board[i-1].charAt(j-1) != color[(i+j) % 2])
                    bTable[i][j]++;
                else wTable[i][j]++;
                bTable[i][j] += bTable[i-1][j] + bTable[i][j-1] - bTable[i-1][j-1];
                wTable[i][j] += wTable[i-1][j] + wTable[i][j-1] - wTable[i-1][j-1];
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int i = 0; i <= n - k; i++) {
            for(int j = 0; j <= m - k; j++) {
                int b = bTable[i + k][j + k] - bTable[i+k][j] - bTable[i][j+k] + bTable[i][j];
                int w = wTable[i + k][j + k] - wTable[i+k][j] - wTable[i][j+k] + wTable[i][j];
                int temp = Math.min(b, w);
                answer = Math.min(temp, answer);
            }
        }

        bw.write(answer + "");
        bw.close();

    }

}