class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int m = 0;
        int n = 0;
        
        for(int i = 0; i < goal.length; i++){
            if(m < cards1.length && cards1[m].equals(goal[i]))
                m++;
            else if(n < cards2.length && cards2[n].equals(goal[i]))
                n++;
            else
                return "No";
        }
        
        return "Yes";
    }
}