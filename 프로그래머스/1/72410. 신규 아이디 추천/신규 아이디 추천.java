class Solution {
    public String solution(String new_id) {
        if(isValid(new_id))
            return new_id;
        
        String answer = new_id;
        
        do {
            //1. 대문자 치환
            answer = answer.toLowerCase();
            //2. 허용되지 않는 문자 제거
            answer = answer.replaceAll("[^a-z0-9-_.]", "");
            //3. 연속되는 점 제거
            answer = answer.replaceAll("[.]{2,}", ".");
            //4. 하나 이상의 점으로 시작하거나 하나 이상의 점으로 끝나는 경우 제거
            answer = answer.replaceAll("^\\.+|\\.+$", "");
            //5. 빈 문자열일 시 a 대입
            if(answer.equals("")) 
                answer += "a";
            //6. 문자열 길이 초과 시 제거
            if(answer.length() > 15)
                answer = answer.substring(0,15).replaceAll("\\.+$", "");
            //7. 문자열 길이 미달 시 늘이기
            while(answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        } while (!isValid(answer));
        
        
        return answer;
    }
    
    private boolean isValid(String id) {
        
        if(id.length() < 3 || id.length() > 15)
            return false;
        
        if(id.replaceAll("[a-z0-9-_.]", "").length() != 0)
            return false;
        
        if(id.charAt(0) == '.' || id.charAt(id.length() - 1) == '.')
            return false;
        
        return true;
    }
}