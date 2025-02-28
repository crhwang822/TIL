import java.lang.StringBuilder;

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int current = 0;
        int x = 0;
        int y = 0;
        
        while(current < s.length()){
            do{
                if(s.charAt(current) == s.charAt(start))
                    x++;
                else
                    y++;
                sb.append(s.charAt(current++));
            } while(x != y && current < s.length());
            sb.append(" ");
            start = current;
        }
        
        int answer = sb.toString().length() - sb.toString().replace(" ","").length();
        
        return answer;
    }
}