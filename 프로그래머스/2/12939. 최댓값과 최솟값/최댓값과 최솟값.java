class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        int max = Integer.parseInt(nums[0]);
        int min = Integer.parseInt(nums[0]);
        
        for(int i = 1; i < nums.length; i++) {
            int num = Integer.parseInt(nums[i]);
            if(num > max)  {
                max = num;
                continue;
            }
            if(num < min) 
                min = num;
        }
        
        String answer = min + " " + max;
        
        return answer;
    }
}