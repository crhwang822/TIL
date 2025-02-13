class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        answer = (count * (count+1) / 2) * (long)price;
        answer = answer - money > 0? answer - money : 0;
        return answer;
    }
}