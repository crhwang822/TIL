class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            String binary = "0" + Long.toString(numbers[i], 2);
            //초기화 수정
            int zeroToOne = -1;
            int oneToZero = -1;
            for(int j = binary.length() - 1; j >= 0; j--) {
                if(binary.charAt(j) == '0') {
                    zeroToOne = j;
                    break;
                }
            }
            for(int j = zeroToOne + 1; j < binary.length(); j++) {
                if(binary.charAt(j) == '1') {
                    oneToZero = j;
                    break;
                }
            }
            
            String[] arr = binary.split("");
            arr[zeroToOne] = "1";
            if(oneToZero != -1)
                arr[oneToZero] = "0";
            binary = String.join("", arr);
            
            answer[i] = Long.valueOf(binary, 2);
        }
        
        return answer;
    }
}