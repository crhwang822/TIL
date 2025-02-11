class Solution {
    public int solution(String A, String B) {
        for(int i=0; i<A.length(); i++){
            if((B.substring(i,B.length()) + B.substring(0,i)).equals(A))
                return i;
        }
        return -1;
    }
}