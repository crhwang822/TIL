import java.io.*;
import java.util.*;

public class Main {

    public static ArrayList<Node>[] tree;
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int v = Integer.parseInt(br.readLine());  // <= 10^5

        tree = new ArrayList[v + 1];
        for(int i = 1; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        int v1, v2, distance;

        for(int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            while((v2 = Integer.parseInt(st.nextToken())) != -1) {
                distance = Integer.parseInt(st.nextToken());  // <= 10^4
                tree[v1].add(new Node(v2, distance));
            }

        }

        int val = dfs(1, 0);
        answer = Math.max(answer, val);

        bw.write(answer + "\n");
        bw.close();
    }

    public static int dfs(int num, int parent) {
        ArrayList<Node> child = tree[num];

        int[] len = new int[child.size()];
        for(int i = 0; i < child.size(); i++) {
            if(child.get(i).num == parent) {
                continue;
            }
            len[i] = dfs(child.get(i).num, num) + child.get(i).distance;
        }

        Arrays.sort(len);

        //만약 num이 루트라면
        if(len.length > 1)
            answer = Math.max(answer, len[len.length - 1] + len[len.length - 2]);

        //num이 루트가 아니라면 최댓값 반환
        return len[len.length - 1];

    }

    public static class Node {
        int num;
        int distance;
        public Node(int node, int distance) {
            this.num = node;
            this.distance = distance;
        }
    }
}

