class Solution {
    public int[] solution(String s) {
        
        // 0개수 세기
        int cntZero=0;
        
        // 반복 횟수 세기
        int iter=0;
        
        while ( !s.equals("1") ) {
            int cnt =0;
            for (char c : s.toCharArray()) {
                if ( c == '1') cnt++;
                else cntZero++;
            }

            // 1개수 -> 2진법한 새로운 String
            s = Integer.toBinaryString(cnt);
            
            iter++;
        
        }
        return new int[] {iter, cntZero};
        
        
    }
}