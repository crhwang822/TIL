class Solution {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        char prev = ' ';
        
        for(char c : s.toCharArray()) {
            if(prev == ' ') {
                sb.append(Character.toUpperCase(c));
            } else 
                sb.append(Character.toLowerCase(c));
            prev = c;
        }
        
        return sb.toString();
    }
}