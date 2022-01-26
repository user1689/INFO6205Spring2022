package question5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int idx = binarySearch(arr, x, 0, n - 1);
        int i = idx - 1;
        int j = idx;
        if (j < 0) {
            j = 0;
        }
        List<Integer> res = new ArrayList<>();
        int count = k;
        while (count > 0) {
            if (i >= 0 && j < n) {
                if ((Math.abs(arr[i]) - x) > (Math.abs(arr[j] - x))) {
                    res.add(arr[j++]);
                } else {
                    res.add(arr[i--]);
                }
            } else if (i < 0) {
                res.add(arr[j++]);
            } else if (j > n) {
                res.add(arr[i--]);
            }
            count -= 1;
        }
        return res;
    }

    public static int binarySearch(int[] arr, int x, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] element = new int[]{1, 2, 3, 4, 5};
        int k = 4;
        int x = -1;
        List<Integer> res = findClosestElements(element, k, x);
        for (int e : res) {
            System.out.println(e);
        }
    }
}
// time complexity O(logn)
// space complexity O(n)
