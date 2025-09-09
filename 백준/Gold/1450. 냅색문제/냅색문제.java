import java.io.*;
import java.util.*;

public class Main {

    public static int[] obj;
    public static List<Long> a = new ArrayList<>();
    public static List<Long> b = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int ans = 0;
        obj = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            obj[i] = Integer.parseInt(st.nextToken());
        }

        add(n / 2, 0, 0, a);  // 2 ^ (n / 2)
        add(n, n / 2, 0, b);       // 2 ^ (n / 2)

        Collections.sort(a);
        Collections.sort(b);

        int ap = 0;
        int bp = b.size() - 1;
        while(ap < a.size() && bp >= 0) {
            long sum = a.get(ap) + b.get(bp);
            if(sum > c) {
                bp--;
            }
            else {  //sum <= c
                ans += bp + 1;
                ap++;
            }
        }

        sb.append(ans);
        sb.append(" ");
        bw.write(sb.toString());
        bw.close();
    }

    public static void add(int end, int depth, long val, List<Long> list) {
        if(depth == end) {
            list.add(val);
            return;
        }

        add(end, depth + 1, val, list);
        add(end, depth + 1, val + obj[depth], list);
    }

}
