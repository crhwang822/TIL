class Solution {
    public boolean solution(int x) {
        int sum = 0;
        for(int i = 0; i < String.valueOf(x).length(); i++)
            sum += String.valueOf(x).charAt(i) - '0';
        return x % sum == 0;
    }
}