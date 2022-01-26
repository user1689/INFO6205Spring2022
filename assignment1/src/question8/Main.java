package question8;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> pancakeSort(int[] nums) {
        int times = nums.length;
        int target = nums.length - 1;
        List<Integer> res = new ArrayList<>();
        while (times > 0) {
            int count = 1;
            int highIdx = 0;
            while (highIdx < nums.length && nums[highIdx] != times) {
                highIdx += 1;
                count += 1;
            }
            res.add(count);
            res.add(target + 1);
            // reverse nums[highIdx] to first
            swap(0, highIdx, nums);
            // reverse nums[highIdx] to last
            swap(0, target, nums);
            times -= 1;
            target -= 1;
        }
        return res;
    }

    public static void swap(int i, int j, int[] arr) {
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i += 1;
            j -= 1;
        }
    }

    public static void main(String[] args) {
        int[] example = {3, 2, 4, 1};
        List<Integer> res = pancakeSort(example);
        for (int element : res) {
            System.out.println(element);
        }
    }
}
// time complexity O(n^2)
// space complexity O(n)
