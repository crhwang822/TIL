import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[10][10];

        if(n <= 10) {
            bw.write(n + "");
            bw.close();
            System.exit(0);
        }

        for(int i = 0; i < arr.length; i++)
            arr[0][i] = 1;

        int cnt = 9;
        boolean flag = false;
        int i = 0;
        int j = 0;

        for(i = 1; i < arr.length; i++) {
            for(j = 0; j < arr[i].length; j++) {
                if(i > j)
                    arr[i][j] = 0;
                else {
                    for(int k = 0; k < j; k++)
                        arr[i][j] += arr[i-1][k];
                }
                if(cnt + arr[i][j] >= n) {
                    flag = true;
                    break;
                }
                cnt += arr[i][j];
            }
            if(flag)
                break;
        }

        String answer = "";

        if(i == 10)
            answer = "-1";
        else {
            int remain = n - cnt;
            StringBuilder sb = new StringBuilder();
            sb.append(j);
            i--;
            while(i >= 0) {
                int temp = 0;
                for(int a = 0; a < j; a++) {
                    if (temp + arr[i][a] >= remain) {
                        sb.append(a);
                        break;
                    }
                    temp += arr[i][a];
                }
                i--;
                remain -= temp;
            }
            answer = sb.toString();
        }

        bw.write(answer);
        bw.close();

    }
}