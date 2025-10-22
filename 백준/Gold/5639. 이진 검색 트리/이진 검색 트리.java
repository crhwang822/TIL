import java.io.*;
import java.util.*;

public class Main {

    public static StringBuilder sb;
    public static List<Integer> preorder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st;


        preorder = new ArrayList<>();

        String s;
        while((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            preorder.add(n);
        }

        dfs(0, preorder.size() - 1);

        bw.write(sb.toString());
        bw.close();
    }

    public static void dfs(int s, int e) {
        int root = preorder.get(s);

        int ps = s + 1;
        int pe = e;
        while(ps <= pe) {
            if(preorder.get(ps) < root)
                ps++;
            if(preorder.get(pe) > root)
                pe--;
        }

        if(s + 1 <= pe)
            dfs(s + 1, pe);
        if(ps <= e)
            dfs(ps, e);

        sb.append(root);
        sb.append("\n");
    }

}

