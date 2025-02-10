import java.lang.Integer;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] arr = my_string.split(" ");
        boolean flag = true;
        
        for(String str:arr){
            if(str.equals("+"))
                flag = true;
            else if(str.equals("-"))
                flag = false;
            else{
                int num = Integer.parseInt(str);
                answer = flag? answer+num:answer-num;
            }
        }
        return answer;
    }
}