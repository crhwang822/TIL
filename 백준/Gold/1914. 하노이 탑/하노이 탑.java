import java.io.*;
import java.math.BigInteger;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        //n이 100일 경우 long의 범위를 벗어남
        BigInteger num = new BigInteger("2");
        BigInteger result = num.pow(n).subtract(new BigInteger("1"));
        sb.append(result);

        if(n <= 20) {
            sb.append("\n");
            hanoi(n, 1, 3, 2);
        }

        bw.write(sb.toString().trim());
        bw.close();
    }

    public static void hanoi(int target, int from, int to, int other) {
        if(target == 0)
            return;

        hanoi(target - 1, from, other, to);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(target - 1, other, to, from);
    }

}
