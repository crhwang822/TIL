class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        
        for(int i = 0; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        
        return answer;
    }
    
    private int lcm(int a, int b) {
        int num = gcd(a,b);
        return num * (a / num) * (b / num);
    }
    
    private int gcd(int a, int b) {
        if(a % b == 0)
            return b;
        return gcd(b, a % b);
    }
}