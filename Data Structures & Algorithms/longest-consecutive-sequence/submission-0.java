class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        for (int num : nums) {
            elements.add(num);
        }
        int longestEver = 0;
        for (int ele : nums) {
            int longest = 1;
            int point = ele;
            while(elements.contains(--point)) {
                longest++;
                elements.remove(point);
            }
            point = ele;
            while(elements.contains(++point)) {
                longest++;
                elements.remove(point);
            }
            elements.remove(ele);
            longestEver = Math.max(longestEver, longest);
        }
        return longestEver;
    }
}