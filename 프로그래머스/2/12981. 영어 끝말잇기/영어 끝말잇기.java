import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> usedWords = new HashSet<>();
        
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            
            // 1. 중복 단어 체크
            if (usedWords.contains(currentWord)) {
                return getAnswer(i, n);
            }
            
            // 2. 끝말잇기 규칙 체크 (i > 0일 때만, 첫 번째 단어는 체크 안 함)
            if (i > 0) {
                String previousWord = words[i - 1];
                char lastChar = previousWord.charAt(previousWord.length() - 1);
                char firstChar = currentWord.charAt(0);
                
                if (lastChar != firstChar) {
                    return getAnswer(i, n);
                }
            }
            
            // 3. 단어 사용 기록
            usedWords.add(currentWord);
        }
        
        // 탈락자 없음
        return new int[]{0, 0};
    }
    
    private int[] getAnswer(int index, int n) {
        int person = (index % n) + 1;      // 사람 번호 (1-based)
        int turn = (index / n) + 1;        // 차례 (1-based)
        return new int[]{person, turn};
    }
}