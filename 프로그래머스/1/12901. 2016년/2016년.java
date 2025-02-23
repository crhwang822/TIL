class Solution {
    public String solution(int a, int b) {
        int[] day = {-1, 31, 29, 31, 30, 31, 30, 
                      31, 31, 30, 31, 30, 31};
        String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", 
                         "WED", "THU"};
        
        for(int i = 0; i <= a - 1; i++)
            b += day[i];
        
        return week[b % 7];
    }
}