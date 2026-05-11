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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.isEmpty()) return true;
        intervals.sort((i1, i2) -> i1.start == i2.start ? Integer.compare(i2.end, i1.end) : Integer.compare(i1.start, i2.start));

        int prevEnd = intervals.get(0).end;
        for (Interval interval : intervals.subList(1, intervals.size())) {
            if (interval.start < prevEnd) { 
                return false;
            }
            else {
                prevEnd = interval.end;
            }
        }

        return true;
    }
}
