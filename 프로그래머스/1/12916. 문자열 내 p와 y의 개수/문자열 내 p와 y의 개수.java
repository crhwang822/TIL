class Solution {
    boolean solution(String s) {
        int len = s.length();
        int pCount = 0;
        int sCount = 0;
        
        s = s.replace("p", "").replace("P", "");
        pCount = len - s.length();
        
        s = s.replace("y", "").replace("Y", "");
        sCount = len - pCount - s.length();
        

        return pCount == sCount;
    }
}