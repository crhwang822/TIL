import java.lang.Integer;
import java.lang.StringBuilder;

class Solution {
    public String solution(String polynomial) {
        String[] arr = polynomial.replace("- ", "-").replace("+ ", "").split("\\s+");
        
        int x = 0;
        int c = 0;
        
        for (String s : arr) {
            if (s.contains("x")) {
                String coef = s.replace("x", "");
                x += coef.isEmpty() || coef.equals("-") ? Integer.parseInt(coef + "1") : Integer.parseInt(coef);
            } else {
                c += Integer.parseInt(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (x != 0) {
            if (x == 1) sb.append("x");
            else if (x == -1) sb.append("-x");
            else sb.append(x).append("x");
        }

        if (c != 0) {
            if (sb.length() > 0) sb.append(" + ");
            sb.append(c);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
