class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int num = i; num<j+1; num++){
            String str = num + "";
            for(int index = 0; index<str.length(); index++){
                if (str.charAt(index) - '0' == k)
                    answer++;
            }
        }
        return answer;
    }
}