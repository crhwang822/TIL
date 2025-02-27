import java.lang.Math;

class Solution {
    
    static int answer = 0;
    
    public int solution(int[] nums) {
        
        boolean[] selected = new boolean[nums.length];
        comb(nums, selected, 0, 3);

        return answer;
    }
    
    public int isPrime(int n){
        if(n % 2 == 0) return 0;
        for(int i = 3; i < n; i += 2){
            if(n % i == 0)
                return 0;
        }
        return 1;
    }
    
    public void comb(int[] nums, boolean[] selected, int start, int r){
        if(r == 0){
            int sum = 0;
            for(int i = 0; i < selected.length; i++)
                if(selected[i])
                   sum += nums[i]; 
            answer += isPrime(sum);
        } else {
            for(int i = start; i < nums.length; i++){
                selected[i] = true;
                comb(nums, selected, i + 1, r - 1);
                selected[i] = false;
            }
        }
    }
}