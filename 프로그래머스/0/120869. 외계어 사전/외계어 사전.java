import java.lang.StringBuilder;

class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        
        StringBuilder sb = new StringBuilder();
        sb.append("^");
        
        for(String s:spell){
            sb.append("(?=.*");
            sb.append(s);
            sb.append(")");
        }
        
        sb.append(".*$");
        
        String condition = sb.toString();
        
        for(String word:dic){
            if(word.matches(condition)){
                answer = 1;
                break;
            }
        }
        return answer;
    }
}