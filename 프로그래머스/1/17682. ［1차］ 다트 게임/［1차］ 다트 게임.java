import java.lang.Math;
import java.lang.Integer;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int current = -1;
        int[] nums = new int[3];
        String[] numStr = dartResult.replaceAll("[^0-9]+"," ").split(" ");
        String[] ops = dartResult.replaceAll("[0-9]+","").split("");
        
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(numStr[i]);
        }
        
        for(int i = 0; i < ops.length; i++){
            switch(ops[i]){
                case "S":
                    nums[++current] = nums[current];
                    break;
                case "D":
                    nums[++current] = (int)Math.pow(nums[current], 2);
                    break;
                case "T":
                    nums[++current] = (int)Math.pow(nums[current], 3);
                    break;
                case "*":
                    if(current > 0)
                        nums[current - 1] *= 2;
                    nums[current] *= 2;
                    break;
                case "#":
                    nums[current] *= -1;
                    break;
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            answer += nums[i];
        }
        
        return answer;
    }
}