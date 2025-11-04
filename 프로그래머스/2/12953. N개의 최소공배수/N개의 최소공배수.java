class Solution {
    public int solution(int[] arr) {
        int result = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            int a = result;
            int b = arr[i];
            
            // GCD 계산 (유클리드 호제법 인라인)
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            int gcd = a;
            
            // LCM 계산
            result = result * arr[i] / gcd;
        }
        
        return result;
    }
}