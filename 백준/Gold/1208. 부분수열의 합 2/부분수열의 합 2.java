import java.io.*;
import java.util.*;

public class Main {

    public static List<Long> a = new ArrayList<>();
    public static List<Long> b = new ArrayList<>();
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        long ans = 0;
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        add(a, n / 2, 0, 0);
        add(b, n, n / 2, 0);

        Collections.sort(a);
        Collections.sort(b);

        int ap = 0;
        int bp = b.size() - 1;

        while(ap < a.size() && bp > -1) {
            long sum = a.get(ap) + b.get(bp);
            if(sum == s) {
                long aCnt = 0;
                long bCnt = 0;
                long aVal = a.get(ap);
                long bVal = b.get(bp);
                while(ap < a.size()  && a.get(ap) == aVal) {
                    aCnt++;
                    ap++;
                }
                while(bp >= 0 && b.get(bp) == bVal) {
                    bCnt++;
                    bp--;
                }
                ans += aCnt * bCnt;
            } else if(sum > s) {
                bp--;
            } else
                ap++;
        }

        if(s == 0)
            ans--;

        sb.append(ans);
        sb.append(" ");
        bw.write(sb.toString());
        bw.close();
    }

    public static void add(List<Long> list, int end, int depth, long val) {
        if(end == depth) {
            list.add(val);
            return;
        }
        add(list, end, depth + 1, val);
        add(list, end, depth + 1, val + (long)arr[depth]);
    }

}
