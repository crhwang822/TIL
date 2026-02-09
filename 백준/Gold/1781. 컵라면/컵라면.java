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

        PriorityQueue<Integer> minQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //보상이 작은 순으로 정렬
                return o1 - o2;
            }
        });

        int[] question;
        for(int i = 0; i < n; i++) {
            question = questions[i];
            if(minQ.size() < question[0]) {
                minQ.add(question[1]);
            } else {
                if(minQ.peek() < question[1]) {
                    minQ.poll();
                    minQ.add(question[1]);
                }
            }
        }

        while(!minQ.isEmpty()) {
            max += minQ.poll();
        }


        bw.write(max + "");
        bw.close();
    }
}