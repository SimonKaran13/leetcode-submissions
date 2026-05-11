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
        if (intervals.isEmpty()) return 0;

        List<List<Interval>> days = new ArrayList<>();
        int currentDay = 0;

        intervals.sort((i1, i2) -> i1.start == i2.start ? Integer.compare(i2.end, i1.end) : Integer.compare(i1.start, i2.start));

        for (var interval : intervals) {
            insertInDay(days, 0, interval);
        }
        printDays(days);
        return days.size();
    }

    private void insertInDay(List<List<Interval>> days, int day, Interval interval) {
        
        if (day == days.size()) {
            days.add(new ArrayList<>());
        } else if (day > days.size()) {
            throw new RuntimeException();
        }
        
        for (int i = 0; i < days.get(day).size(); i++) {
            Interval current = days.get(day).get(i);
            if (current.start >= interval.end) {
                days.get(day).add(i, interval);
                return;
            }
            if ((interval.end > current.start && interval.start < current.end) || (interval.start <= current.start && interval.end >= current.end)) {
                insertInDay(days, day + 1, interval);
                return;
            }
        }
        
        days.get(day).add(interval);
    }

    private void printDays(List<List<Interval>> days) {
        List<List<String>> toPrint = new ArrayList<>();
        for (var day : days) {
            List<String> dayString = day.stream().map(i -> intervalString(i)).toList();
            toPrint.add(dayString);
        }
        System.out.println(toPrint);
    }

    private String intervalString(Interval interval) {
        return "[" + interval.start + ", " + interval.end + "]";
    }
}
