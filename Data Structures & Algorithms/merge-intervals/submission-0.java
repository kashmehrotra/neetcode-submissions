class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        result.add(intervals[0]);
        for (int i=1;i<intervals.length;i++) {
            int[] last = result.get(result.size()-1);
            if (intervals[i][0] <= last[1]) {
                result.remove(last);
                result.add(new int[]{Math.min(last[0], intervals[i][0]), Math.max(last[1], intervals[i][1])});
            } else {
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}