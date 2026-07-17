class Solution {
    public int rob(int[] nums) {
        int withLast = 0, woLast = 0;
        for (int i=0;i<nums.length;i++) {
            int temp = withLast;
            withLast = Math.max(withLast, woLast + nums[i]);
            woLast = temp;
        }
        return Math.max(withLast, woLast);
    }
}