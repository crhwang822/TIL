class Solution {
    public int solution(int num, int k) {
        String str = num + "";
        int index = str.indexOf(k+"");
        return index==-1? index:index+1;
    }
}