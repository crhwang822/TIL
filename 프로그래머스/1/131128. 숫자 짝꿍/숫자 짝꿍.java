import java.lang.Math;
import java.util.Arrays;
import java.lang.StringBuilder;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < 10; i++){
            String n = String.valueOf(i);
            int xCount = X.length() - X.replace(n, "").length();
            int yCount = Y.length() - Y.replace(n, "").length();
            int count = Math.min(xCount, yCount);
            sb.append(n.repeat(count));
        }
        
        if(sb.length() == 0)
            return "-1";
        
        char[] arr = sb.toString().toCharArray();
        Arrays.sort(arr);
        
        if(arr[arr.length - 1] == '0')
            return "0";
        
        sb = new StringBuilder(new String(arr)).reverse();
        
        return sb.toString();
    }
}