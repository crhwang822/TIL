import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        boolean[][] matrix;
        int[] indegree;
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        for(int Ti = 0; Ti < T; Ti++) {
            int n = Integer.parseInt(br.readLine());

            int[] last = new int[n + 1];
            indegree = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i < last.length; i++) {
                last[i] = Integer.parseInt(st.nextToken());
                indegree[last[i]] = i - 1;
            }

            matrix = new boolean[n + 1][n + 1];
            for(int i = 1; i < last.length - 1; i++) {
                for(int j = i + 1; j < last.length; j++)
                    matrix[last[i]][last[j]] = true;
            }

            int m = Integer.parseInt(br.readLine());
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(matrix[a][b]) {
                    matrix[a][b] = false;
                    matrix[b][a] = true;
                    indegree[b]--;
                    indegree[a]++;
                } else {
                    matrix[a][b] = true;
                    matrix[b][a] = false;
                    indegree[a]--;
                    indegree[b]++;
                }
            }

            for(int i = 1; i < indegree.length; i++) {
                if(indegree[i] == 0) {
                    q.add(i);
                }
            }

            boolean ambiguous = false;
            boolean isInvalid = false;

            //위상정렬
            for(int i = 0; i < n; i++) {
                if(q.isEmpty()) {
                    isInvalid = true;
                    break;
                }

                if(q.size() > 1)
                    ambiguous = true;

                int num = q.poll();
                result.add(num);
                for(int j = 1; j < n + 1; j++) {
                    if(!matrix[num][j])
                        continue;
                    if(--indegree[j] == 0) {
                        q.add(j);
                    }
                }
            }

            //결과
            if(isInvalid) {
                sb.append("IMPOSSIBLE\n");
            } else if(ambiguous) {
                sb.append("?\n");
            } else {
                for(int i = 0; i < n; i++) {
                    sb.append(result.poll());
                    sb.append(" ");
                }
                sb.append("\n");
            }


            bw.write(sb.toString());
            sb.setLength(0);
            q.clear();
            result.clear();
        }
        bw.close();
    }
}
