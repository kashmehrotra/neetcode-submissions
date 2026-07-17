class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> setOfNums = new HashSet<>();
        for (int num: nums) {
            setOfNums.add(num);
        }
        for (int i=0;i<=nums.length;i++) {
            if (!setOfNums.contains(i)) {
                return i;
            }
        }
        return 0;
    }
}
