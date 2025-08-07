import java.io.*;
import java.util.*;

public class Main {

    public static int answer = Integer.MAX_VALUE;
    public static int[] people;
    public static Map<Integer, int[]> map = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        people = new int[n];
        for(int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> total = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int[] arr = new int[size];
            for(int j = 0; j < size; j++) {
                arr[j] = Integer.parseInt(st.nextToken()) - 1;
            }
            map.put(i, arr);
            total.add(i);
        }

        divide(0, new ArrayList<>(), total);

        if(answer == Integer.MAX_VALUE)
            answer = -1;

        bw.write(answer + "");
        bw.close();
    }

    public static void divide(int idx, List<Integer> red, List<Integer> blue) {
        if(idx == people.length) {
            if(!red.isEmpty() && !blue.isEmpty() && check(red) && check(blue))
                update(red);
            return;
        }
        red.add(idx);
        blue.remove(blue.indexOf(idx));
        divide(idx + 1, red, blue);
        red.remove(red.size() - 1);
        blue.add(idx);
        divide(idx + 1, red, blue);
    }

    public static boolean check(List<Integer> list) {
        List<Integer> q = new ArrayList<>();
        boolean[] visited = new boolean[people.length];

        q.add(list.get(0));
        visited[list.get(0)] = true;

        int cnt = 0;
        
        while(!q.isEmpty()) {
            int cur = q.get(0);
            if(list.contains(cur)) {
                cnt++;
                int[] neighbor = map.get(cur);
                for(int i = 0; i < neighbor.length; i++) {
                    if(!visited[neighbor[i]]) {
                        visited[neighbor[i]] = true;
                        q.add(neighbor[i]);
                    }
                }
            }
            q.remove(0);
        }

        if(cnt == list.size())
            return true;

        return false;
    }

    public static void update(List<Integer> list) {
        int a = 0;
        int b = 0;
        for(int i = 0; i < people.length; i++) {
            if(list.contains(i))
                a += people[i];
            else b += people[i];
        }
        answer = Math.min(answer, Math.abs(a-b));
    }


}