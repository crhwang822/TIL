import java.lang.StringBuilder;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for(String c : s.split("")){
            if(c.equals(" "))
                sb.append(" ");
            else{
                answer = alphabet.charAt((alphabet.indexOf(c.toLowerCase()) + n) % 26) + "";
                sb.append(c.compareTo("Z") > 0? answer : answer.toUpperCase());                
            }
        }
        answer = sb.toString();
        return answer;
    }
}