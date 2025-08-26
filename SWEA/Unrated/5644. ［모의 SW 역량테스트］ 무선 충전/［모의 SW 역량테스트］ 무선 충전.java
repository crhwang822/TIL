import java.io.*;
import java.util.*;

//SWEA
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        int[] dx = {0, 0, 1, 0, -1};
        int[] dy = {0, -1, 0, 1, 0};

        int[] aMove;
        int[] bMove;
        int[][] chargers;
        int amount;
        PriorityQueue<int[]> apq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        PriorityQueue<int[]> bpq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

        //테스트케이스 시작
        for(int Ti = 1; Ti <= T; Ti++) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());  //이동 시간
            int a = Integer.parseInt(st.nextToken());  //BC의 개수

            //변수 초기화
            aMove = new int[m + 1];
            bMove = new int[m + 1];
            chargers = new int[a][4];
            amount = 0;

            aMove[0] = 0;
            bMove[0] = 0;

            //A의 이동 경로
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= m; i++) {
                aMove[i] = Integer.parseInt(st.nextToken());
            }

            //B의 이동 경로
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= m; i++) {
                bMove[i] = Integer.parseInt(st.nextToken());
            }

            //BC의 정보
            for(int i = 0; i < a; i++) {
                st = new StringTokenizer(br.readLine());
                chargers[i][0] = Integer.parseInt(st.nextToken());
                chargers[i][1] = Integer.parseInt(st.nextToken());
                chargers[i][2] = Integer.parseInt(st.nextToken());
                chargers[i][3] = Integer.parseInt(st.nextToken());
            }

            //시뮬레이션
            int ax = 1;
            int ay = 1;
            int bx = 10;
            int by = 10;
            int sum;
            for(int i = 0; i <= m; i++) { //100
                apq.clear();
                bpq.clear();

                ax += dx[aMove[i]];
                ay += dy[aMove[i]];
                bx += dx[bMove[i]];
                by += dy[bMove[i]];
                sum = 0;

                //a와 b의 현재 위치에서 사용 가능한 충전소 찾기
                for(int j = 0; j < a; j++) {
                    int[] charger = chargers[j];
                    if(Math.abs(charger[0] - ax) + Math.abs(charger[1] - ay) <= charger[2]) {
                        apq.add(new int[]{j, charger[3]});
                    }
                    if(Math.abs(charger[0] - bx) + Math.abs(charger[1] - by) <= charger[2]) {
                        bpq.add(new int[]{j, charger[3]});
                    }
                }

                //둘 다 충전소 범위 내에 있지 않은 경우
                if(apq.isEmpty() && bpq.isEmpty()) {
//                    System.out.println(i);
                    continue;
                }

                //둘 중 하나만 충전소 범위 내에 있는 경우
                if(apq.isEmpty() || bpq.isEmpty()) {
                    if(apq.isEmpty())
                        amount += bpq.poll()[1];
                    else
                        amount += apq.poll()[1];
                    continue;
                }

                //A와 B가 서로 다른 충전소를 이용하는 경우
                if(apq.peek()[0] != bpq.peek()[0]) {
                    amount += (apq.poll()[1] + bpq.poll()[1]);
                    continue;
                }

                sum = bpq.poll()[1];
                int temp = apq.poll()[1];

                if(!bpq.isEmpty())
                    sum = Math.max(sum, bpq.poll()[1] + temp);
                if(!apq.isEmpty())
                    sum = Math.max(sum, apq.poll()[1] + temp);

                amount += sum;
            }

            sb.append("#");
            sb.append(Ti);
            sb.append(" ");
            sb.append(amount);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}
