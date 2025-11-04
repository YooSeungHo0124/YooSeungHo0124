class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int num = Integer.parseInt(nums[i]);  
            if (min > num) {
                min = num;
            }
            if (max < num) {
                max = num;
            }
        }

        return min + " " + max;
    }
}
