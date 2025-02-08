class Solution {
    public int[] solution(int money) {
        int price = 5500;
        int[] answer = {money/price, money%price};
        return answer;
    }
}