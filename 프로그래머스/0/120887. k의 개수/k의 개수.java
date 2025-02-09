class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int num = i; num<j+1; num++){
            for(int index = 0; index<String.valueOf(num).length(); index++){
                char c = String.valueOf(num).charAt(index);
                if (String.valueOf(c).equals(String.valueOf(k)))
                    answer++;
            }
        }
        return answer;
    }
}