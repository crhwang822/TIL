import java.util.Collections;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String solution(String my_string) {
        List<String> strlist = Arrays.asList(my_string.split(""));
        Collections.reverse(strlist);
        return strlist.stream().collect(Collectors.joining());
    }
}