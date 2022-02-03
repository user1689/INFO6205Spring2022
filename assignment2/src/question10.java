import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class question10 {

    public static List<List<Integer>>  fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n - 3; i++) {
            if ((i > 0) && (nums[i] == nums[i - 1])) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                if ((j > i + 1) && (nums[j] == nums[j - 1])) {
                    continue;
                }
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    int tmp = nums[i] + nums[j] + nums[left] + nums[right];
                    if (tmp == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while ((left < right) && (nums[left] == nums[left + 1])) {
                            left += 1;
                        }
                        while ((left < right) && (nums[right] == nums[right - 1])) {
                            right -= 1;
                        }
                        left += 1;
                        right -= 1;
                    } else if (tmp > target) {
                        while ((left < right) && (nums[right] == nums[right - 1])) {
                            right -= 1;
                        }
                        right -= 1;
                    } else if (tmp < target) {
                        while ((left < right) && (nums[left] == nums[left + 1])) {
                            left += 1;
                        }
                        left += 1;
                    }

                }

            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] example = new int[]{1, 4, 3, 5, -1, 9, 10, -1};
        int target = 9;
        List<List<Integer>> ans = fourSum(example, target);
        for (List<Integer> a : ans) {
            System.out.println(a);
        }
    }


}
