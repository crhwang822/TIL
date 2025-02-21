class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++){
            String b1 = Integer.toString(arr1[i], 2);
            String b2 = Integer.toString(arr2[i], 2);
            
            while(b1.length() != n) b1 = "0" + b1;
            while(b2.length() != n) b2 = "0" + b2;
            
            String str = "";
            for(int j = 0; j < n; j++){
                if(b1.charAt(j) == '1' || b2.charAt(j) == '1')
                    str += "#";
                else
                    str += " ";
            }
            answer[i] = str;
        }
        
        return answer;
    }
}