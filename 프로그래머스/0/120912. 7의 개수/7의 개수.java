import java.lang.StringBuilder;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for(int num:array){
            sb.append(String.valueOf(num));
        }
        answer = sb.toString().length() - sb.toString().replace("7","").length();
        return answer;
    }
}