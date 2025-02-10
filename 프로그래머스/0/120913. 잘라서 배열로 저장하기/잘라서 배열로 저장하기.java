import java.lang.Math;

class Solution {
    public String[] solution(String my_str, int n) {
        int len = my_str.length();
        String[] answer = new String[(len+n-1)/n];
        
        int index;
        for(int i = 0; i<len; i+=n){
            index = Math.min(i + n, len);
            answer[i/n] = my_str.substring(i, index);
        }
        
        return answer;
    }
}