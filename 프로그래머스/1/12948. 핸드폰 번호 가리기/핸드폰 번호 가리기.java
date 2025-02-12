import java.lang.StringBuilder;

class Solution {
    public String solution(String phone_number) {
        int len = phone_number.length();
        StringBuilder sb = new StringBuilder();
        sb.append("*".repeat(len - 4));
        sb.append(phone_number.substring(len - 4, len));
        return sb.toString();
    }
}