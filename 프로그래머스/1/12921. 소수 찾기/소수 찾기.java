import java.lang.Math;

class Solution {
    public int solution(int n) {
        int answer = 1;  //2는 무조건 포함
        
        for(int i = 2; i <= n; i++){
            if(i % 2 == 0) //2를 제외한 짝수는 포함 X
                continue;
            answer += isPrime(i);
        }
        
        return answer;
    }
    
    public int isPrime(int n){
        for(int i = 3; i <= Math.sqrt(n); i++){
            if(n % i == 0)
                return 0;
        }
        return 1;
    }
}