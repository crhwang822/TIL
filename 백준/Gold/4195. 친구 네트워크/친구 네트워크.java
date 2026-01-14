import java.io.*;
        import java.util.*;

public class Main {

    static Map<String, String> map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for(int testCase = 0; testCase < T; testCase++) {
            int F = Integer.parseInt(br.readLine()); // <= 100,000
            String name1, name2;
            String start = "";
            map.clear();
            countMap.clear();

            for(int i = 0; i < F; i++) {  //100,000
                st = new StringTokenizer(br.readLine());
                name1 = st.nextToken();
                name2 = st.nextToken();

                if(i == 0) {
                    start = name1;
                }

                if(!map.containsKey(name1)) {
                    map.put(name1, name1);
                    countMap.put(name1, 1);
                }

                if(!map.containsKey(name2)) {
                    map.put(name2, name2);
                    countMap.put(name2, 1);
                }

                if(!find(name1).equals(find(name2))) {
                    int cnt = countMap.get(find(name1)) + countMap.get(find(name2));
                    countMap.replace(find(name1), cnt);
                    countMap.replace(find(name2), cnt);
                    map.replace(find(name2), find(name1));
                }

                bw.write(countMap.get(find(name1)) + "\n");
            }

        }

        bw.close();
    }

    public static String find(String name) {
        if(!map.get(name).equals(name)) {
            map.replace(name, find(map.get(name)));
        }
        return map.get(name);
    }
}