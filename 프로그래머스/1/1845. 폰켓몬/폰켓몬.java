import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        List<Integer> type = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            if(!type.contains(nums[i]))
                type.add(nums[i]);
        }
        
        answer = type.size() < nums.length / 2? type.size() : nums.length / 2;
        
        return answer;
    }
}