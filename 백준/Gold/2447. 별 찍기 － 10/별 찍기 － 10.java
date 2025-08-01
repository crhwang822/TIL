import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        String result = print(n);
        bw.write(result);
        bw.close();
    }

    public static String print(int n) {
        if(n == 1) return "*";
        String str = print(n / 3);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n / 3; i++) {
            sb.append(" ");
        }

        String t = sb.toString();
        sb.setLength(0);

        String[] arr = str.split("\n");
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < 3; j++) {
                sb.append(arr[i]);
            }
            sb.append("\n");
        }


        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < 3; j++) {
                if(j != 1)
                    sb.append(arr[i]);
                else {
                    sb.append(t);
                }
            }

            sb.append("\n");
        }


        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < 3; j++) {
                sb.append(arr[i]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}