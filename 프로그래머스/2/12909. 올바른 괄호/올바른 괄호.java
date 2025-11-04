class Solution {
    boolean solution(String s) {
        int cnt = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }
            
            // 중간에 닫는 괄호가 더 많아지면 바로 false
            if (cnt < 0) {
                return false;
            }
        }
        
        // 최종적으로 열린 괄호가 모두 닫혔는지 확인
        return cnt == 0;
    }
}