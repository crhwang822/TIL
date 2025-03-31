import java.lang.*;

class Solution {
    
    public int solution(int[] ingredient) {
        int answer = 0;
        int need = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < ingredient.length; i++) { 
            sb.append(ingredient[i]);
            
            if(sb.length() < 4)
                continue;
            
            if(sb.substring(sb.length() - 4).equals("1231")) {
                answer++;
                sb.delete(sb.length() - 4, sb.length());
            }
            
        }
        
        return answer;
    }
}