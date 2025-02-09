class Solution {
    public String solution(int age) {
        String str = String.valueOf(age);
        int diff = 'a' - '0';
        
        String answer = "";
        for(int i=0; i<str.length(); i++)
            answer += (char) ((int)str.charAt(i) + diff);
        
        return answer;

    }
}