class Solution {
    public boolean solution(String s) {
        if(s.length() != 4 && s.length() != 6)
            return false;
        s = s.replaceAll("[0-9]", "");
        if(!s.isEmpty())
            return false;
        return true;
    }
}