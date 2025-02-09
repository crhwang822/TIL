import java.lang.StringBuilder;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        String[] strlist = my_string.split("");
        for(String elem:strlist){
            if(!sb.toString().contains(elem))
                sb.append(elem);
        }
        
        return sb.toString();
    }
}