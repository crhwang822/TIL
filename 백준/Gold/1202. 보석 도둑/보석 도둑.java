import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        //보석 입력 처리
        int[][] gems = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            gems[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        //보석 정렬 -> 무게 오름차순, 무게가 같을 시 가격 내림차순
        Arrays.sort(gems, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });

        //가방 입력 처리
        int[] bags = new int[k];
        for(int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        //가방 오름차순 정렬
        Arrays.sort(bags);

        //용량이 작은 가방부터 탐색
        long totalValue = 0;
        int index = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            }
        });

        for(int i = 0; i < bags.length; i++) {
            while(index < gems.length){
                int[] gem = gems[index];
                if(gem[0] <= bags[i]) {
                    pq.add(gem);
                    index++;
                } else
                    break;
            }

            if(!pq.isEmpty()) {
                totalValue += pq.poll()[1];
            }
        }

        bw.write(totalValue + "");
        bw.close();
    }
}