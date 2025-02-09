class Solution {
    public int solution(int hp) {
        int general = hp / 5;
        int soldier = (hp % 5) / 3;
        int work = (hp % 5 % 3) / 1;
        int answer = general + soldier + work;
        return answer;
    }
}