import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int Ti = 0; Ti < T; Ti++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, String> map = new HashMap<>();
            Map<String, Integer> sizeMap = new HashMap<>();

            for(int i = 0; i < n; i++) {
                String[] arr = br.readLine().split(" ");
                String name = arr[0];
                String other = arr[1];


                if(!map.containsKey(name)) {
                    map.put(name, name);
                    sizeMap.put(name, 1);
                }

                if(!map.containsKey(other)) {
                    map.put(other, other);
                    sizeMap.put(other, 1);
                }

                String nameParent = find(map, name);
                String otherParent = find(map, other);

                if(!nameParent.equals(otherParent)) {
                    map.put(otherParent, nameParent);
                    sizeMap.replace(nameParent, sizeMap.get(nameParent) + sizeMap.get(otherParent));
                }

                bw.write(sizeMap.get(nameParent) + "\n");
            }
        }

        bw.close();
    }

    public static String find(Map<String, String> map, String s) {
        if(!map.get(s).equals(s)) {
            map.put(s, find(map, map.get(s))); // 경로 압축
        }
        return map.get(s);
    }
}
