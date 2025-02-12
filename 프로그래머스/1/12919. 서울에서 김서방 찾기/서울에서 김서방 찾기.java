class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        String s = String.join(" ", seoul);
        s = s.substring(0, s.indexOf("Kim"));
        int x = s.length() - s.replace(" ", "").length();
        answer = "김서방은 " + x + "에 있다";
        return answer;
    }
}