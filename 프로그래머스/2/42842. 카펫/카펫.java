class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        // 가로 길이를 total부터 3까지 감소시키며 검사
        for (int width = total; width >= 3; width--) {
            // 세로 길이 계산
            if (total % width == 0) {
                int height = total / width;
                
                // 노란색 영역 검증: (가로-2) × (세로-2) = yellow
                if ((width - 2) * (height - 2) == yellow) {
                    // 가로가 세로보다 길거나 같아야 함
                    return new int[] {width, height};
                }
            }
        }
        
        return new int[] {}; // 이론상 도달하지 않음
    }
}