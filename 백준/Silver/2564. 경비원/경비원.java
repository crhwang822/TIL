import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] wh = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int n = Integer.parseInt(br.readLine());
        int[][] stores = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());
            stores[i] = toArr(wh, dir, pos);
        }

        st = new StringTokenizer(br.readLine());
        int[] xy = toArr(wh, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        int answer = 0;
        int sum = (wh[0] + wh[1]) * 2;
        for(int i = 0; i < n; i++) {
            int[] store = stores[i];
            int d = getDistance(wh, xy[0], xy[1], store[0], store[1]);
            answer += Math.min(d, sum - d);
        }

        bw.write(answer + "");
        bw.close();
    }

    public static int getDistance(int[] wh, int x1, int y1, int x2, int y2) {
        if(Math.abs(y1 - y2) == wh[1] || Math.abs(x1 - x2) == wh[0]) {
            return x1 + x2 + y1 + y2;
        }

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static int[] toArr(int[] wh, int dir, int pos) {
        int x = 0;
        int y = 0;
        switch(dir) {
            case 1:
                x = pos;
                break;
            case 2:
                x = pos;
                y = wh[1];
                break;
            case 3:
                y = pos;
                break;
            case 4:
                x = wh[0];
                y = pos;
                break;
        }
        return new int[]{x, y};
    }
}