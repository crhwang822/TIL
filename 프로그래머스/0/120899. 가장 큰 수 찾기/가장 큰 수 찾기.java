class Solution {
    public int[] solution(int[] array) {
        int maxIndex = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] > array[maxIndex])
                maxIndex = i;
        }
        int[] answer = {array[maxIndex], maxIndex};
        return answer;
    }
}