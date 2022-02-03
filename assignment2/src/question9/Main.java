package question9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        int i = 0;
        int j = 0;
        int n1 = firstList.length;
        int n2 = secondList.length;
        List<int[]> res = new ArrayList<>();
        while (i < n1 && j < n2) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);

            if (start <= end) {
                res.add(new int[]{start, end});
            }

            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        int[][] ans = new int[res.size()][2];
        int k = 0;
        for (int[] element : res) {
            ans[k++] = element;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] firstList = {{1, 2}, {3, 4}, {10, 15}};
        int[][] secondList = {{2, 5}, {7, 8}, {14, 20}};
        int[][] ans = intervalIntersection(firstList, secondList);
    }
}
