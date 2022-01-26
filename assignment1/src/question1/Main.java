package question1;

import java.util.Arrays;

public class Main {
    public static void sortColors(int[] nums) {
        int ptr1 = 0;
        int ptr2 = nums.length - 1;
        for (int i = 0; i <= ptr2; i++) {
            while (i <= ptr2 && nums[i] == 2) {
                int tmp = nums[i];
                nums[i] = nums[ptr2];
                nums[ptr2] = tmp;
                ptr2 -= 1;
            }
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[ptr1];
                nums[ptr1] = tmp;
                ptr1 += 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] example = {2, 2, 2, 2, 2, 0, 0, 1};
        Main.sortColors(example);
        System.out.println(Arrays.toString(example));
    }
}
// time complexity O(n)
// space complexity O(1)
