import java.util.Arrays;
import java.util.PriorityQueue;

public class question4 {
    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int[] e : intervals) {
            if (heap.size() > 0 && (heap.peek() <= e[0])) {
                heap.poll();
            }
            heap.offer(e[1]);
        }
        return heap.size();
    }

    public static void main(String[] args) {
        int[][] element = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        int ans = minMeetingRooms(element);
        System.out.println(ans);
    }
}
