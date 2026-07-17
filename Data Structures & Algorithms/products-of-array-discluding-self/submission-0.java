class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        int product = 1;
        for (int i=1;i<len;i++) {
            product *= nums[i-1];
            left[i] = product;
        }
        for (int i=0;i<len;i++) {
            System.out.println(left[i]);
        }
        System.out.println();
        product = 1;
        for (int i=len-2;i>=0;i--) {
            product *= nums[i+1];
            right[i] = product;
        }
        for (int i=0;i<len;i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}  
