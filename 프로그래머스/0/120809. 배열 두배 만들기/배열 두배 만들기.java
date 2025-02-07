class Solution {
    public int[] solution(int[] numbers) {
        int i = 0;
        while(i < numbers.length){
            numbers[i] *= 2;
            i += 1;
        }
        return numbers;
    }
}