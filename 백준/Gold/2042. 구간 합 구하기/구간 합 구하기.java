import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] arr = new long[n+1];
//        int h = (int)Math.ceil(Math.log(n) / Math.log(2));
        tree = new long[4 * n];

        for(int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(arr, 1, 1, n);

        for(int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(op == 1) {
                long c = Long.parseLong(st.nextToken());
                update(1, 1, n, b, c);
            } else {
                int c = Integer.parseInt(st.nextToken());
                sb.append(query(1, 1, n, b, c));
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
    }

    public static long update(int node, int start, int end, int index, long value) {
        if(index > end || index < start) {
            return tree[node];
        } else if (start == index && end == index) {
            tree[node] = value;
        } else {
            int mid = (start + end) / 2;
            tree[node] = update(node * 2, start, mid, index, value) + update(node * 2 + 1, mid + 1, end, index, value);
        }
        return tree[node];
    }

    public static long query(int node, int start, int end, int left, int right) {
        if(left > end || right < start) {
            return 0;
        } else if(left <= start && end <= right) {
            return tree[node];
        } else {
            int mid = (start + end) / 2;
            return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);
        }
    }

    public static long init(long[] arr, int node, int start, int end) {
        if(start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            tree[node] = init(arr, node * 2, start, mid) + init(arr, node * 2 + 1, mid + 1, end);
        }
        return tree[node];
    }
}