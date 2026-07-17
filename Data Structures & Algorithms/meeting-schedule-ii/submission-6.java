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
        int[] startIn = new int[MAX+1];
        int[] endIn = new int[MAX+1];
        for (Interval interval: intervals) {
            startIn[interval.start]++;
            endIn[interval.end]++;
        }
        int rooms = startIn[0] - endIn[0];
        int currRooms = startIn[0] - endIn[0];
        for (int i=1;i<=MAX;i++) {
            if (startIn[i] > 0) {
                currRooms += startIn[i];
            }
            if (endIn[i] > 0) {
                currRooms -= endIn[i];
            }
            rooms = Math.max(rooms, currRooms);
        }
        return rooms;
    }
}
