import java.util.Scanner;
import java.lang.Integer;
import java.lang.StringBuilder;
import java.lang.Character;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int testCase = 1; testCase <= T; testCase++) {
        	StringBuilder sb = new StringBuilder();
            String encoded = sc.nextLine();
            for(char c : encoded.toCharArray()) {
                int value = 0;
                if(Character.isUpperCase(c))
                    value = c - 'A';
                else if(Character.isLowerCase(c))
                    value = c - 'a' + 26;
                else if(Character.isDigit(c))
                    value = c - '0' + 52;
                else
                    value = c == '+'? 62 : 63;
                sb.append(String.format("%6s", Integer.toString(value, 2)).replace(" ","0"));
            }
            String str = sb.toString();
            sb.setLength(0);
            while(str.length() > 0) {
                sb.append((char)Integer.parseInt(str.substring(0,8),2));
                str = str.substring(8);
            }
            System.out.println("#" + testCase + " " + sb.toString());
        }
    }
}