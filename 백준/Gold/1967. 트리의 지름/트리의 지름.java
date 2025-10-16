import org.w3c.dom.Node;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static int answer = 0;
    public static ArrayList<Node>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        int p, c, w;
        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            tree[p].add(new Node(c, w));
        }

        dfs(1);


        bw.write(answer + "\n");
        bw.close();
    }

    public static int dfs(int num) {
        ArrayList<Node> child = tree[num];
        int[] len = new int[child.size() + 1];

        for(int i = 0; i < child.size(); i++) {
            len[i] = dfs(child.get(i).num) + child.get(i).weight;
        }

        Arrays.sort(len);

        //num이 루트인 경우
        if(len.length > 1) {
            answer = Math.max(answer, len[len.length - 1] + len[len.length - 2]);
        }

        //num이 루트가 아닌 경우
        return len[len.length - 1];
    }

    public static class Node {
        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
}

