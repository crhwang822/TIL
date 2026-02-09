import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int max = 0;

        int n = Integer.parseInt(br.readLine());

        int[][] questions = new int[n][2];

        // 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[2];
            arr[0] = Integer.parseInt(st.nextToken()); // 데드라인
            arr[1] = Integer.parseInt(st.nextToken()); // 컵라면 수
            questions[i] = arr;
        }

        // 데드라인 순으로 정렬
        Arrays.sort(questions, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<int[]> maxQ = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //보상이 큰 순으로 정렬
                return o2[1] - o1[1];
            }
        });

        int index = n - 1;
        for(int day = n; day > 0; day--) {
            while(index > -1 && questions[index][0] >= day) {
                maxQ.add(questions[index]);
                index--;
            }

            if(!maxQ.isEmpty())
                max += maxQ.poll()[1];
        }

        bw.write(max + "");
        bw.close();
    }
}