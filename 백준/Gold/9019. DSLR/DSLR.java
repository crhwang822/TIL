import java.io.*;
import java.util.*;

public class Main {

    public static int[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[10001];
        int[] prevNum = new int[10001];
        char[] prevOp = new char[10001];
        Queue<Integer> q = new LinkedList<>();

        for(int Ti = 0; Ti < T; Ti++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Arrays.fill(visited, false);
            Arrays.fill(prevNum, -1);
            Arrays.fill(prevOp, '0');
            visited[a] = true;
            q.clear();

            q.add(a);

            while(!q.isEmpty()) {

                int num = q.poll();
                int newNum = 0;

                if(num == b) break;


                //D
                newNum = (num * 2) % 10000;
                if(!visited[newNum]) {
                    prevOp[newNum] = 'D';
                    prevNum[newNum] = num;
                    visited[newNum] = true;
                    q.add(newNum);
                }

                //S
                newNum = num - 1 < 0? 9999: num - 1;
                if(!visited[newNum]) {
                    prevOp[newNum] = 'S';
                    prevNum[newNum] = num;
                    visited[newNum] = true;
                    q.add(newNum);
                }

                //L
                newNum = ((num * 10) + num / 1000) % 10000;
                if(!visited[newNum]) {
                    prevOp[newNum] = 'L';
                    prevNum[newNum] = num;
                    visited[newNum] = true;
                    q.add(newNum);
                }

                //R
                newNum = ((num / 10) + (num % 10) * 1000);
                if(!visited[newNum]) {
                    prevOp[newNum] = 'R';
                    prevNum[newNum] = num;
                    visited[newNum] = true;
                    q.add(newNum);
                }
            }

            while(true) {
                if(b == a) break;

                sb.append(prevOp[b]);

                b = prevNum[b];
            }

            bw.write(sb.reverse().toString());
            bw.write("\n");
            sb.setLength(0);
        }


        bw.write(sb.toString());
        bw.close();
    }



}