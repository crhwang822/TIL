import java.lang.StringBuilder;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<my_string.length(); i++){
            if('a' <= my_string.charAt(i) && my_string.charAt(i) <= 'z')
                sb.append(String.valueOf(my_string.charAt(i)).toUpperCase());
            else 
                sb.append(String.valueOf(my_string.charAt(i)).toLowerCase());
        }
        return sb.toString();
    }
}