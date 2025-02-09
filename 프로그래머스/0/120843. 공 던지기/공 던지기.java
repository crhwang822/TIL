class Solution {
    public int solution(int[] numbers, int k) {
        int index = -2;
        for(int i=0; i<k; i++){
            if(index > numbers.length - 3)
                index -= numbers.length - 2;
            else 
                index += 2;
        }
        return numbers[index];
    }
}