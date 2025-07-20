import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[st.countTokens()];
        for(int i = 0; i < input.length; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int[] criteria = {1, 1, 2, 2, 2, 8};
        int[] result = new int[input.length];
        for(int i = 0; i < input.length; i++) {
            result[i] = criteria[i] - input[i];
            bw.write(result[i] + " ");
        }
        bw.close();
    }


}