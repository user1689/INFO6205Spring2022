package question2;

public class Main {
    public static int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[mid ^ 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] example = new int[]{1, 1, 2, 3, 3, 4, 4};
        int ans = singleNonDuplicate(example);
        System.out.println(ans);
    }
}
