class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] nums = Integer.toString(n, k).replaceAll("[0]+"," ").split(" ");
        
        if(nums.length == 0)
            return answer;
        
        for(String num : nums) {
            answer += isPrime(Long.parseLong(num));
        }
        return answer;
    }
    
    public int isPrime(long n) {
        if(n == 2)
            return 1;
        if(n % 2 == 0 || n == 1)
            return 0;
        for(long i = 3; i <= Math.sqrt(n); i += 2) {
            if(n % i == 0)
                return 0;
        }
        return 1;
    }
}