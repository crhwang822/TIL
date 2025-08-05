import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, int[][]> map = new HashMap<>();
        for(int i = 0; i <= 20; i++) {
            map.put(i, new int[21][21]);
        }

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        while(a != -1 || b != -1 || c != -1) {

            int answer = w(map, a, b, c);
            bw.write("w(" + a + ", " + b + ", " + c + ") = " + answer + "\n"); ;

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }

        bw.close();

    }

    public static int w(Map<Integer, int[][]> map,int a, int b, int c) {
        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if(a > 20 || b > 20 || c > 20) {
            if(map.get(20)[20][20] == 0) map.get(20)[20][20] = w(map,20,20,20);
            return map.get(20)[20][20];
        } else if(a < b && b < c) {
            if(map.get(a)[b][c] == 0) {
                if (map.get(a)[b][c - 1] == 0) map.get(a)[b][c - 1] = w(map, a, b, c - 1);
                if (map.get(a)[b - 1][c - 1] == 0) map.get(a)[b - 1][c - 1] = w(map, a, b - 1, c - 1);
                if (map.get(a)[b - 1][c] == 0) map.get(a)[b - 1][c] = w(map, a, b - 1, c);
                map.get(a)[b][c] = map.get(a)[b][c - 1] + map.get(a)[b - 1][c - 1] - map.get(a)[b - 1][c];
            }
            return map.get(a)[b][c];
        } else {
            if(map.get(a)[b][c] == 0) {
                if (map.get(a-1)[b][c - 1] == 0) map.get(a - 1)[b][c - 1] = w(map, a - 1, b, c - 1);
                if (map.get(a-1)[b - 1][c] == 0) map.get(a - 1)[b - 1][c] = w(map, a - 1, b - 1, c);
                if (map.get(a-1)[b][c] == 0) map.get(a - 1)[b][c] = w(map, a - 1, b, c);
                if (map.get(a-1)[b - 1][c - 1] == 0) map.get(a - 1)[b - 1][c - 1] = w(map, a - 1, b - 1, c - 1);
                map.get(a)[b][c] = map.get(a - 1)[b][c - 1] + map.get(a - 1)[b - 1][c] + map.get(a - 1)[b][c] - map.get(a - 1)[b - 1][c - 1];
            }
            return map.get(a)[b][c];
        }
    }
}