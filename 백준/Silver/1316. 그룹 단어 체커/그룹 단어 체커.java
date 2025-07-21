import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            boolean[] alphabet = new boolean[26];
            String word = br.readLine();
            char prev =' ';
            boolean flag = true;
            for(int j = 0; j < word.length(); j++) {
                char current = word.charAt(j);
                if(prev == current) {
                    continue;
                } else {
                    if(alphabet[current-'a']) {
                        flag = false;
                        break;
                    }
                    alphabet[current-'a'] = true;
                }
                prev = current;
            }
            if(flag) cnt++;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(cnt + "");
        bw.close();
    }
}