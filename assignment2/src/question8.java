import java.util.Arrays;
import java.util.Comparator;

public class question8 {


    public static int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) {
                return 0;
            }

            Arrays.sort(intervals, new Comparator<int[]>() {
                public int compare(int[] m, int[] n) {
                    return m[1] - n[1];
                }
            });

            int n = intervals.length;
            int i = 0;
            int cnt = 0;
            while (i < n) {
                int j = i + 1;
                // count valid
                cnt += 1;
                while (j < n && intervals[j][0] < intervals[i][1]) {
                    j += 1;
                }
                i = j;
            }
            return n - cnt;

        }


    public static void main(String[] args) {
        int[][] example = new int[][]{{1, 4}, {2, 5}, {3, 4}, {1, 3}};
        int res = eraseOverlapIntervals(example);
        System.out.println(res);
    }
}
