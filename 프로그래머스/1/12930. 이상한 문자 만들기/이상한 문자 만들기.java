import java.lang.StringBuilder;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int idx = -1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                idx = -1;
                sb.append(" ");
                continue;
            }
            idx++;
            if(idx % 2 == 0)
                sb.append(String.valueOf(s.charAt(i)).toUpperCase());
            else
                sb.append(String.valueOf(s.charAt(i)).toLowerCase());
        }
        
        answer = sb.toString();
        
        return answer;
    }
}