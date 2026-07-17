/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int MAX = 1_000_000;
        int[] in = new int[MAX+1];
        for (Interval interval: intervals) {
            in[interval.start]++;
            in[interval.end]--;
        }
        int rooms = in[0];
        int currRooms = in[0];
        for (int i=1;i<=MAX;i++) {
            if (in[i] != 0) {
                currRooms += in[i];
            }
            rooms = Math.max(rooms, currRooms);
        }
        return rooms;
    }
}
