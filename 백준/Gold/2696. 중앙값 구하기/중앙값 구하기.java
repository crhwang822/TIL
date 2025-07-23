import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> lowerQ = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> upperQ = new PriorityQueue<>();
            int mid = Integer.parseInt(st.nextToken());
            bw.write((n + 1) / 2 + "\n" + mid + " ");
            for(int i = 1; i < n; i++) {
                if(!st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                if(num >= mid) {
                    upperQ.add(num);
                } else {
                    lowerQ.add(num);
                }

                if(i % 2 == 0) {
                    //두 큐 사이즈 비교
                    if(lowerQ.size() > upperQ.size()) {
                        upperQ.add(mid);
                        mid = lowerQ.poll();
                    } else if(lowerQ.size() < upperQ.size()) {
                        lowerQ.add(mid);
                        mid = upperQ.poll();
                    }

                    bw.write(mid + " ");
                    if((i+2) % 20 == 0)
                        bw.newLine();
                }
            }
            bw.newLine();
        }
        bw.close();
    }
}