import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        int h = Integer.parseInt(a[0]);
        int m = Integer.parseInt(a[1]);
        int c = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum = m + c;
        m = sum % 60;
        h += (sum / 60);
        h %= 24;

        bw.write(h + " " + m);
        bw.close();
    }
}