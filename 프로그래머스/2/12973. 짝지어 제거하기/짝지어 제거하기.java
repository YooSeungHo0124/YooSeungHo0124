class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            int len = sb.length();
            
            if (len > 0 && sb.charAt(len - 1) == current) {
                // 짝을 찾으면 제거
                sb.deleteCharAt(len - 1);
            } else {
                // 짝이 아니면 추가
                sb.append(current);
            }
        }
        
        return sb.length() == 0 ? 1 : 0;
    }
}