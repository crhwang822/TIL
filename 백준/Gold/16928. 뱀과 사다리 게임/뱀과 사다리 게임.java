import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> event = new HashMap<>();

        // 사다리
        int x, y;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            event.put(x, y);
        }

        // 뱀
        int u, v;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            event.put(u, v);
        }

        // int[]{주사위 굴린 횟수, 현재 위치}
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        pq.add(new int[]{0, 1});
        int[] cur;
        int cnt, pos, next, res;
        int answer = 0;

        int[] arr = new int[101];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[1] = 0;
        arr[0] = -1;

        while(!pq.isEmpty()) {
            cur = pq.poll();
            cnt = cur[0];
            pos = cur[1];

            if(pos == 100) {
                answer = cnt;
                break;
            }

            //주사위 굴리기
            for(int i = 1; i < 7; i++) {
                next = pos + i;

                if(next > 100)
                    break;

                if(event.containsKey(next)) {
                    res = event.get(next);
                    if(arr[res] > cnt + 1) {
                        arr[res] = cnt + 1;
                        pq.add(new int[]{cnt + 1, res});
                    }
                } else {
                    if(arr[next] > cnt + 1) {
                        arr[next] = cnt + 1;
                        pq.add(new int[]{cnt + 1, next});
                    }
                }
            }
        }
        System.out.println(answer);
    }
}