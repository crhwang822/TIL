class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int start = 0;
        
        if(num%2==0){
            start = (total - (num*num)/2 + num/2) / num;

        }
        else{
            start = total/num - num/2;
        }
        
        for(int i=0; i<num; i++)
            answer[i] = start + i;
        
        return answer;
    }
}