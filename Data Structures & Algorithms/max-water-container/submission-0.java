class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        for (int i=0,j=heights.length-1;i<j;) {
            max = Math.max(max, Math.min(heights[i], heights[j])*(j-i));
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
