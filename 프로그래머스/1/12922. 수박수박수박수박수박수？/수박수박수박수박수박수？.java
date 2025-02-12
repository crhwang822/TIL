import java.lang.StringBuilder;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("수박".repeat(n/2));
        sb.append("수".repeat(n%2));
        return sb.toString();
    }
}