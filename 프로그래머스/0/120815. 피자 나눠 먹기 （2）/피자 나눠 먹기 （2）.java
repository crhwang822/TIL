class Solution {
    public int solution(int n) {
        int answer = 0;
        answer = lcm(6, n) / 6;
        return answer;
    }
    
    public int gcm(int num1, int num2){
        if (num1 % num2 == 0)
            return num2;
        return gcm(num2, num1%num2);
    }
    
    public int lcm(int num1, int num2){
        return (num1 * num2) / gcm(num1,num2);
    }
}