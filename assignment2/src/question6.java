import java.util.Arrays;

public class question6 {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0x3f3f3f3f;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && (nums[i] == nums[i - 1])) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    left += 1;
                } else if (sum > target){
                    right -= 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] example = {9, 1, 2, 3, 3, 4, 5};
        int target = 3;
        int res = threeSumClosest(example, target);
    }
}
