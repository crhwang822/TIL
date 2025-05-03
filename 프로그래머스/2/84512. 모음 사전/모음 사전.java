import java.lang.Math;

class Solution {
    public int solution(String word) {
        int answer = 0;
        String alphabet = "AEIOU";
        
        for(int i = 0; i < word.length(); i++) {
            String w = String.valueOf(word.charAt(i));
            int index = alphabet.indexOf(w);
            int sum = 0;
            for(int j = 0; j < 5 - i; j++) {
                sum += Math.pow(5, j);
            }
            answer += index * sum + 1;
        }
        return answer;
    }
}