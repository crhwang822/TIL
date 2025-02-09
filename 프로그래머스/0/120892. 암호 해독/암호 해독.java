import java.lang.StringBuilder;

class Solution {
    public String solution(String cipher, int code) {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=cipher.length()/code; i++){
            sb.append(String.valueOf(cipher.charAt(i*code-1)));
        }
        return sb.toString();
    }
}