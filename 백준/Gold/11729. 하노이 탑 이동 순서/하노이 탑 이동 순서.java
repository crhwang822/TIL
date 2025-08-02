import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        sb.append((int)Math.pow(2, n) - 1);
        sb.append("\n");
        hanoi(n, 1, 3, 2);
        bw.write(sb.toString());
        bw.close();
    }

    public static void hanoi(int n, int from, int to, int other) {
        if(n == 0)
            return;
        hanoi(n - 1, from, other, to);
        sb.append(from);
        sb.append(" ");
        sb.append(to);
        sb.append("\n");
        hanoi(n - 1, other, to, from);
    }
}