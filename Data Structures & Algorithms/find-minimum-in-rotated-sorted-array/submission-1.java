class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        if (nums[0] <= nums[len-1]) {
            return nums[0];
        }
        if (nums[len-1] < nums[len-2]) {
            return nums[len-1];
        }
        int start = 0, end = len-1, mid = (start+end)/2;
        while(!(nums[mid] < nums[mid+1] && nums[mid] < nums[mid-1])) {
            System.out.println("start " + start + ", mid " + mid + ", end " + end);
            if (nums[start] > nums[mid]) {
                end = mid;
            } else {
                start = mid;
            }
            mid = (start+end)/2;
        }
        return nums[mid];
    }
}
