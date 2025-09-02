import java.io.*;
import java.util.*;

//SWEA
public class Solution {

    public static int N;
    public static int[][] s;
    public static int diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        boolean[] visited;

        //테스트케이스 시작
        for(int Ti = 1; Ti <= T; Ti++) {
            N = Integer.parseInt(br.readLine());

            //초기화
            s = new int[N][N];
            diff = Integer.MAX_VALUE;
            visited = new boolean[N];

            //시너지 입력 받기
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    s[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //음식 맛 계산 : n * (n - 1) <= 2^8 <= 10^3
            combination(N / 2, 0, visited);

            //출력
            sb.append("#");
            sb.append(Ti);
            sb.append(" ");
            sb.append(diff);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

    public static void combination(int r, int depth, boolean[] visited) {
        if(r == 0) {
            //visited로 차이 계산
            diff = Math.min(diff, computeDiff(visited));
            return;
        }
        if(depth == N) {
            return;
        }
        visited[depth] = true;
        combination(r - 1, depth + 1, visited);
        visited[depth] = false;
        combination(r, depth + 1, visited);
    }

    public static int computeDiff(boolean[] visited) {
        int[] food = new int[N / 2];
        int[] other = new int[N / 2];
        int fi = 0;
        int oi = 0;
        for(int i = 0; i < visited.length; i++) {
            if(visited[i])
                food[fi++] = i;
            else other[oi++] = i;
        }
        fi = 0;
        oi = 0;
        for(int i = 0; i < food.length; i++) {
            for(int j = 0; j < food.length; j++) {
                fi += s[food[i]][food[j]];
                oi += s[other[i]][other[j]];
            }
        }
        return Math.abs(fi - oi);
    }

}
