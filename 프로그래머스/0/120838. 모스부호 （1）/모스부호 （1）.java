import java.lang.StringBuilder;
import java.util.List;

class Solution {
    public String solution(String letter) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        List<String> morseList = List.of(morse);
        
        //매핑
        StringBuilder sb = new StringBuilder();
        String[] strlist = letter.split(" ");
        for(String str:strlist)
            sb.append((char)(morseList.indexOf(str) + (int)'a'));
        
        return sb.toString();
    }
}