import java.util.Collections;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder(my_string);
        return sb.reverse().toString();
    }
}