import java.util.Arrays;
import java.util.PriorityQueue;

public class question4 {
    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int[] interval : intervals) {
            if (heap.size() > 0 && (heap.peek() <= interval[0])) {
                heap.poll();
            }
            heap.offer(interval[1]);
        }
        return heap.size();
    }

    public static void main(String[] args) {
        int[][] element = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        int[][] element2 = {{7,10},{2,4}};
        int ans = minMeetingRooms(element2);
        System.out.println(ans);
    }
}
