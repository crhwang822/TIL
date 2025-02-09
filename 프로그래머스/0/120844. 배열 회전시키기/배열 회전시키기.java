class Solution {
    public int[] solution(int[] numbers, String direction) {
        int len = numbers.length;
        int[] answer = new int[len];
        
        switch(direction){
            case "left":
                for(int i=0; i<len-1; i++)
                    answer[i] = numbers[i+1];
                answer[len-1] = numbers[0];
                break;
            case "right":
                for(int i=1; i<len; i++)
                    answer[i] = numbers[i-1];
                answer[0] = numbers[len-1];
                break;
        }
        
        return answer;
    }
}