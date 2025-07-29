import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        ArrayList<Integer> list = new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()) {
            if('0' <= c && c <= '9') {
                sb.append(c);
            } else {
                if(sb.length() > 0) {
                    list.add(Integer.parseInt(sb.toString()));
                    sb.setLength(0);
                }
                sb.append(c);
            }
        }
        list.add(Integer.parseInt(sb.toString()));

        int ans = list.get(0);
        boolean flag = false;
        for(int i = 1; i < list.size(); i++) {
            int num = list.get(i);
            if(num < 0) {
                flag = true;
                ans += num;
            } else if(flag && num > 0) {
                ans -= num;
            } else ans += num;
        }

        bw.write(ans+"");
        bw.close();
    }
}
