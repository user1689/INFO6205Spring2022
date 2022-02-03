import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class question7 {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int idx = 0;
        int n = intervals.length;
        while (idx < n && (intervals[idx][1] < newInterval[0])) {
            res.add(intervals[idx]);
            idx += 1;
        }

        while (idx < n && (intervals[idx][0] <= newInterval[1])) {
            newInterval[0] = Math.min(intervals[idx][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[idx][1], newInterval[1]);
            idx += 1;
        }
        res.add(new int[]{newInterval[0], newInterval[1]});

        while (idx < n && (intervals[idx][0]) > newInterval[0]) {
            res.add(intervals[idx]);
            idx += 1;
        }

        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;


    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] nums2 = new int[]{4, 8};
        int[][] res = insert(nums, nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
