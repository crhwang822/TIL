import java.util.Scanner;
import java.lang.StringBuilder;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for(int testCase = 1; testCase <= T; testCase++) {
            
            System.out.println("#" + testCase);
            int n = sc.nextInt();
            
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < n; i++) {
                sc.nextLine();
                String s = sc.next();
                int count = sc.nextInt();
                for(int j = 0; j < count; j++)
                    sb.append(s);
            }
            
            String str = sb.toString();
            while(str.length() > 10) {
                System.out.println(str.substring(0,10));
                str = str.substring(10);
            }
            System.out.println(str);
        }
    }
}