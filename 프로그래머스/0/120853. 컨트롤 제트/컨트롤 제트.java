class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] arr = s.split(" ");
        int val = 0;
        for(String str:arr){
            if(str.equals("Z"))
                answer -= val;
            else{
                val = Integer.parseInt(str);
                answer += val;
            }
        }
        return answer;
    }
}