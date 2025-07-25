import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int[] lis = new int[n];
        int[] lds = new int[n];

        //lis
        for(int i = 0; i < n; i++)  {
            lis[i] = 1;
            for(int j = 0; j < i; j++) {
                int temp;
                if(a[j] < a[i]) {
                    temp = lis[j] + 1;
                    lis[i] = Math.max(lis[i], temp);
                }
            }
        }

        //lds
        for(int i = n-1; i >= 0; i--) {
            lds[i] = 1;
            for(int j = n-1; j > i; j--) {
                int temp;
                if(a[j] < a[i]) {
                    temp = lds[j] + 1;
                    lds[i] = Math.max(lds[i], temp);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, lis[i] + lds[i] - 1);
        }

        bw.write(ans + "");
        bw.close();
    }
}