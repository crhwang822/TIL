import java.util.List;
import java.util.ArrayList;

class Solution {
    boolean solution(String s) {
        List<String> list = new ArrayList<>();
        int i = 0;
        
        if(s.length() % 2 == 1) 
            return false;

        for(String str : s.split("")) {
            if(str.equals("(")) {
                list.add("(");
                i++;
            } else {
                if(i > 0 && list.get(i - 1).equals("(")) {
                    list.remove(i-1);
                    i--;
                }
                else return false;
            }
        }
        
        if(i > 0)
            return false;

        return true;
    }
}