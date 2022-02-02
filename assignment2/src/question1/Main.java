package question1;

public class Main {

    public static int searchInsertPosition(int[] nums, int target) {
        // bisect_left
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7, 11};
        int target = 5;
        int ans = searchInsertPosition(nums, target);
        System.out.println(ans);
    }
}
// time complexity O(logn)
// space complexity O(q)
