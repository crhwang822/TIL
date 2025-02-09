class Solution {
    public int solution(int order) {
        int answer = 0;
        String[] strlist = String.valueOf(order).split("");
        for(String str:strlist){
            if(str.matches("[369]"))
                answer++;
        }
        return answer;
    }
}