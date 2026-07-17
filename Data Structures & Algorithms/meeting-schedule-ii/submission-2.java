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

 // 0,5 0,8 2,3 5,6

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int MAX = 1_000_000;
        int[] startIn = new int[MAX+1];
        int[] endIn = new int[MAX+1];
        for (Interval interval: intervals) {
            startIn[interval.start]++;
            if (interval.end > 0) {
                endIn[interval.end]++;
            }
            // System.out.println(interval.start + " " + interval.end);
        }
        int rooms = startIn[0] - endIn[0];
        int currRooms = startIn[0] - endIn[0];
        for (int i=1;i<=MAX;i++) {
            if (startIn[i] > 0) {
                currRooms += startIn[i];
                // System.out.println("start " + i + " " + startIn[i] + " " + endIn[i] + " " + currRooms + " " + rooms);
            }
            if (endIn[i] > 0) {
                currRooms -= endIn[i];
                // System.out.println("end " + i + " " + startIn[i] + " " + endIn[i] + " " + currRooms + " " + rooms);
            }
            rooms = Math.max(rooms, currRooms);
        }
        return rooms;
    }
}
