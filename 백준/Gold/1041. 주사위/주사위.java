import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dice = new int[6];
        int index = 0;
        while(st.hasMoreTokens()) {
            dice[index++] = Integer.parseInt(st.nextToken());
        }

        if(n == 1) {
            int sum = 0;
            int max = 0;
            for(int i = 0; i < dice.length; i++) {
                sum += dice[i];
                max = Math.max(max, dice[i]);
            }
            sum -= max;
            bw.write(sum+"");
            bw.close();
            System.exit(0);
        }

        int[] min = findMin(dice);

        long totalSide = 5 * n * n;

        long answer = (4 * min[2]) + (8 * n - 12) * min[1] + (totalSide - 12 - (16 * n - 24)) * min[0];

        //출력
        bw.write(answer + "");
        bw.close();
    }

    public static int[] findMin(int[] arr) {
        int threeSideSum = 0;
        int twoSideSum = Integer.MAX_VALUE;
        int oneSideSum = Integer.MAX_VALUE;

        for(int i = 0; i < 3; i++) {
            threeSideSum += Math.min(arr[i], arr[5 - i]);
        }
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(i + j == 5)
                    continue;
                twoSideSum = Math.min(twoSideSum, arr[i] + arr[j]);
            }
        }
        for(int i = 0; i < arr.length; i++)
            oneSideSum = Math.min(oneSideSum, arr[i]);
        int[] min = new int[] {oneSideSum, twoSideSum, threeSideSum};

        return min;
    }
}