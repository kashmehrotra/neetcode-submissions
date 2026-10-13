class Solution {

    class Interval implements Comparable<Interval> {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Interval other) {
            if (this.start != other.start) {
                return this.start - other.start;
            }
            return this.end - other.end;
        }
    }

    public int[][] merge(int[][] intervals) {
        List<Interval> inters = new ArrayList<>();
        for (int[] interval : intervals) {
            Interval in = new Interval(interval[0], interval[1]);
            inters.add(in);
        }
        // inters.sort(null);
        Collections.sort(inters, (i1, i2) -> {
            if (i1.start == i2.start) return i1.end - i2.end;
            return i1.start - i2.start;
        });

        List<int[]> result = new ArrayList<>();
        int start = inters.get(0).start;
        int end = inters.get(0).end;
        for (int i=1;i<inters.size();i++) {
            if (end >= inters.get(i).start) {
                end = Math.max(end, inters.get(i).end);
            } else {
                result.add(new int[]{start, end});
                start = inters.get(i).start;
                end = Math.max(end, inters.get(i).end);
            }
        }
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);

    }
}
