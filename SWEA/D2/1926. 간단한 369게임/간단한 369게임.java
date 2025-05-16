import java.util.Scanner;
import java.lang.StringBuilder;

public class Solution {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            String rs = s.replaceAll("[369]", "");
            int diff = s.length() - rs.length();
            if(diff == 0)
                sb.append(i);
            else
                for(int j = 0; j < diff; j++)
	                sb.append("-");
            sb.append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}