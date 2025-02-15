import java.lang.Integer;

class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String even = "";
        String odd = "";
        
        for(int num : num_list){
            if(num % 2 == 0)
                even += num;
            else
                odd += num;
        }
        
        answer = Integer.parseInt(odd) + Integer.parseInt(even);
        
        return answer;
    }
}