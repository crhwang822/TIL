
class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        boolean flag = true;
        
        for(String word:dic){
            flag = true;
            for(String s:spell){
                if(!word.contains(s)){
                    flag = false;
                    break;
                }
            }
            if(flag) return 1;
        }
        return answer;
    }
}