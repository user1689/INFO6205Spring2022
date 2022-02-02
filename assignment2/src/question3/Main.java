package question3;

public class Main {

    public static int findMin(int[] nums) {
        // find min point
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 7, 1, 2, 3};
        int minPoint = findMin(nums);
        System.out.println(minPoint);
    }
}
