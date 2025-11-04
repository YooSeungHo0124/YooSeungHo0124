class Solution {
    public int solution(int n) {
        // n의 2진수에서 1의 개수
        int bitCount = Integer.bitCount(n);
        
        // n보다 큰 수 중에서 1의 개수가 같은 가장 작은 수 찾기
        int next = n + 1;
        while (Integer.bitCount(next) != bitCount) {
            next++;
        }
        
        return next;
    }
}