import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int num;
        int start;
        for(int i = 1; i <= N; i++) {
            num = Integer.parseInt(st.nextToken());
            pq.add(new int[]{i, num});
            start = Math.max(1, i - L + 1);

            while(pq.peek()[0] < start) {
                pq.poll();
            }

            sb.append(pq.peek()[1]);
            sb.append(" ");
        }

        System.out.println(sb.toString());

    }
}