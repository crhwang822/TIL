import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<int[]> deque = new ArrayDeque<>();

        int num, start;
        int[] front;
        for(int i = 1; i <= N; i++) {
            num = Integer.parseInt(st.nextToken());
            start = Math.max(1, i - L + 1);

            // num을 deque에 삽입
            while(!deque.isEmpty() && deque.peekLast()[1] > num) {
                deque.removeLast();
            }
            deque.addLast(new int[]{i, num});

            // 출력
            while(deque.peekFirst()[0] < start) {
                deque.removeFirst();
            }

            sb.append(deque.peekFirst()[1]);
            sb.append(" ");
        }

        System.out.println(sb.toString());

    }
}