class Solution {
    public int solution(int n, int a, int b) {
        int round = 1;
        
        while (true) {
            // a와 b가 만나는 조건: (a+1)/2 == (b+1)/2 가 같아질 때
            if ((a + 1) / 2 == (b + 1) / 2) {
                return round;
            }
            
            // 다음 라운드 번호 계산
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            round++;
        }
    }
}