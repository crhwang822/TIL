class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int coupon = chicken;
        
        while(coupon >= 10){
            chicken = coupon/10;
            answer += chicken;
            coupon %= 10;
            coupon += chicken;
        }
        
        return answer;
    }
}