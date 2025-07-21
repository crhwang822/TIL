import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.replace("c=", "A")
                .replace("c-", "A")
                .replace("dz=", "A")
                .replace("d-", "A")
                .replace("lj", "A")
                .replace("nj", "A")
                .replace("s=", "A")
                .replace("z=", "A");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(str.length() + "");
        bw.close();
    }
}