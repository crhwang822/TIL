class Solution {
    public int solution(String before, String after) {
        for (int i = 0; i < after.length(); i++){
            before = before.replaceFirst(String.valueOf(after.charAt(i)),"");
        }
        int answer = before.isEmpty()? 1:0;
        return answer;
    }
}