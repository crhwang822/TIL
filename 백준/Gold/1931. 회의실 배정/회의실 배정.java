import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] reservations = new int[n][2];
        for(int i = 0; i < reservations.length; i++){
            String[] temp = br.readLine().split(" ");
            reservations[i][0] = Integer.parseInt(temp[0]);
            reservations[i][1] = Integer.parseInt(temp[1]);
        }
        Arrays.sort(reservations, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        int endTime = 0;
        int answer = 0;
        for(int i = 0; i < reservations.length; i++){
            if(reservations[i][0] >= endTime){
                answer++;
                endTime = reservations[i][1];
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer + "");
        bw.close();

    }

}