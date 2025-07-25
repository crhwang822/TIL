import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Integer> primeNums = findPrimes(n);

        int s = 0;
        int e = 0;
        int sum = 0;
        int cnt = 0;

        while(s < primeNums.size()) {
            if(sum < n && e < primeNums.size()) {
                sum += primeNums.get(e);
                e++;
            } else {
                if(sum == n)
                    cnt++;
                sum -= primeNums.get(s);
                s++;

            }
        }

        bw.write(cnt + "");
        bw.close();

    }

    public static List<Integer> findPrimes(int n) {
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(!visited[i]) {
                for(int j = i * i; j <= n; j += i) {
                    visited[j] = true;
                }
            }
        }
        for(int i = 2; i < visited.length; i++) {
            if(!visited[i])
                list.add(i);
        }
        return list;
    }
}