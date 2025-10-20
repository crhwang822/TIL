import java.io.*;
import java.util.*;

public class Main {

    public static Node[] tree;
    public static Map<Integer, Integer> inorderMap;
    public static List<Integer> postorder;

    public static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 10,000

        tree = new Node[n + 1];
        for(int i = 0; i < tree.length; i++)
            tree[i] = new Node();

        inorderMap = new HashMap<>();
        postorder = new ArrayList<>();

        postorder.add(0);

        st = new StringTokenizer(br.readLine());
        int temp;
        for(int i = 0; i < n; i++) {
            temp = Integer.parseInt(st.nextToken());
            inorderMap.put(temp, i + 1);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            postorder.add(Integer.parseInt(st.nextToken()));
        }

        dfs(1, n, 1, n);

        preorder(postorder.get(postorder.size() - 1));

        bw.write(sb.toString());
        bw.close();
    }

    public static void dfs(int s, int e,  int is, int ie) {
        int root = postorder.get(e);

        if(s == e || e < 1) {
            return;
        }

        int index = inorderMap.get(root);  //inorder 리스트에서 루트의 위치
        int leftCnt = index - is;
        int rightCnt = ie - index;

        if(leftCnt > 0) {
            tree[root].setLeft(postorder.get(s + leftCnt - 1));
            dfs(s, s + leftCnt - 1, is, index - 1);
        }
        if(rightCnt > 0) {
            tree[root].setRight(postorder.get(e - 1));
            dfs(s + leftCnt, e - 1, index + 1, ie);
        }
    }

    //출력
    public static void preorder(int num) {
        sb.append(num);
        sb.append(" ");
        if(tree[num].left != -1)
            preorder(tree[num].left);
        if(tree[num].right != -1)
            preorder(tree[num].right);
    }

    public static class Node {
        int left;
        int right;

        public Node() {
            this.left = -1;
            this.right = -1;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public void setRight(int right) {
            this.right = right;
        }
    }

}

