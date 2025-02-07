class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        //서비스로 받은 음료수 제외
        k -= n/10;
        answer += 12000 * n + 2000 * k;
        return answer;
    }
}