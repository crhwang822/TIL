class Solution {
    public String solution(String my_string, int num1, int num2) {
        String[] strlist = my_string.split("");
        String temp = strlist[num2];
        strlist[num2] = strlist[num1];
        strlist[num1] = temp;
        return String.join("",strlist);
    }
}