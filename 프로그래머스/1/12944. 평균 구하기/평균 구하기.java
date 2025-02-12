class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for(int elem : arr){
            answer += elem;
        }
        answer /= arr.length;
        return answer;
    }
}