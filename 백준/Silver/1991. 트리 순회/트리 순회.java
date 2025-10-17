import org.w3c.dom.Node;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static Map<Integer, String> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        tree = new HashMap<>();
        map.put("A", 1);
        tree.put(1, "A");

        for (int i = 1; i <= n; i++) {
            String[] str = br.readLine().split(" ");
            int parent = map.get(str[0]);
            int left = parent * 2;
            int right = parent * 2 + 1;

            tree.put(left, str[1]);
            tree.put(right, str[2]);

            if (!str[1].equals(".")) {
                map.put(str[1], left);
            }
            if (!str[2].equals(".")) {
                map.put(str[2], right);
            }
        }


        //전위 순회
        List<String> result = new ArrayList<>();
        preOrder(result, 1);
        for(int i = 0; i < result.size(); i++)
            sb.append(result.get(i));
        sb.append("\n");
        result.clear();

        //중위 순회
        inOrder(result, 1);
        for(int i = 0; i < result.size(); i++)
            sb.append(result.get(i));
        sb.append("\n");
        result.clear();

        //후위 순회
        postOrder(result, 1);
        for(int i = 0; i < result.size(); i++)
            sb.append(result.get(i));
        sb.append("\n");

        bw.write(sb.toString());
        bw.close();
    }

    public static void preOrder(List<String> list, int num) {
        list.add(tree.get(num));
        if(!tree.get(num * 2).equals("."))
            preOrder(list, num * 2);
        if(!tree.get(num * 2 + 1).equals("."))
            preOrder(list, num * 2 + 1);
    }

    public static void inOrder(List<String> list, int num) {
        if(!tree.get(num * 2).equals("."))
            inOrder(list, num * 2);
        list.add(tree.get(num));
        if(!tree.get(num * 2 + 1).equals("."))
            inOrder(list, num * 2 + 1);
    }

    public static void postOrder(List<String> list, int num) {

        if(!tree.get(num * 2).equals("."))
            postOrder(list, num * 2);
        if(!tree.get(num * 2 + 1).equals("."))
            postOrder(list, num * 2  + 1);
        list.add(tree.get(num));
    }

}

