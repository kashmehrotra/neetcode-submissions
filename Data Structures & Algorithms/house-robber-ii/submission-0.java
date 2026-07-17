class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int withLast = 0, withoutLast = 0;
        for (int i=0;i<nums.length-1;i++) {
            int temp = withLast;
            if (withLast < nums[i] + withoutLast) {
                withLast = nums[i] + withoutLast;
            }
            withoutLast = temp;
        }
        int lastMax = Math.max(withLast, withoutLast);
        withLast = 0;
        withoutLast = 0;
        for (int i=1;i<nums.length;i++) {
            int temp = withLast;
            if (withLast < nums[i] + withoutLast) {
                withLast = nums[i] + withoutLast;
            }
            withoutLast = temp;
        }
        return Math.max(lastMax, Math.max(withLast, withoutLast));
    }
}