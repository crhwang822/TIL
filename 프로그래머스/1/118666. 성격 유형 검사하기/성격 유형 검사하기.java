class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] result = new int[4];
        String[] type = {"RT", "CF", "JM", "AN"};
        
        for(int i = 0; i < survey.length; i++) {
            int score = choices[i] - 4;
            if(survey[i].contains("R")) {
                result[0] += survey[i].indexOf("R") == 0? score : score * -1;
            }
            if(survey[i].contains("C")) {
                result[1] += survey[i].indexOf("C") == 0? score : score * -1;
            }
            if(survey[i].contains("J")) {
                result[2] += survey[i].indexOf("J") == 0? score : score * -1;
            }
            if(survey[i].contains("A")) {
                result[3] += survey[i].indexOf("A") == 0? score : score * -1;
            }
        }
        
        for(int i = 0; i < result.length; i++) {
            if(result[i] == 0) 
                answer += type[i].charAt(0);
            else 
                answer += type[i].charAt(result[i]<0? 0 : 1);
        }
        
        return answer;
    }
}