import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        String bomb = br.readLine();


        Stack<int[]> stack = new Stack<>();
        char c;
        int[] before;

        for(int i = 0; i < input.length(); i++) {
            c = input.charAt(i);

            if(bomb.indexOf(c) == 0) {
                stack.push(new int[]{0, 1, i});
            } else if(bomb.indexOf(c) != -1 && !stack.isEmpty()) {
                    before = stack.peek();
                    if(bomb.indexOf(c) == before[0] + 1) {
                        stack.push(new int[]{bomb.indexOf(c), before[1] + 1, i});
                    } else {
                        stack.push(new int[]{bomb.indexOf(c), 0, i});
                    }
            } else {
                stack.push(new int[]{bomb.indexOf(c), 0, i});
            }
            ;
            if(!stack.isEmpty() && stack.peek()[1] == bomb.length()) {
                for(int j = 0; j < bomb.length(); j++){
                    stack.pop();
                }
            }
        }


        if(stack.isEmpty()) {
            sb.append("FRULA");
        } else {
            while(!stack.isEmpty()) {
                sb.append(input.charAt(stack.pop()[2]));
            }
            sb.reverse();
        }

        System.out.print(sb);
    }
}