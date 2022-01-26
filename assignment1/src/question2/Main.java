package question2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> majorityElement(int[] nums) {
        int vote1 = 0;
        int vote2 = 0;
        int element1 = 0;
        int element2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && element1 == num) {
                vote1 += 1;
            } else if (vote2 > 0 && element2 == num) {
                vote2 += 1;
            } else if (vote1 == 0) {   // change element1
                element1 = num;
                vote1 += 1;
            } else if (vote2 == 0) {   // change element2
                element2 = num;
                vote2 += 1;
            } else {
                vote1 -= 1;
                vote2 -= 1;
            }
        }
        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            if (num == element1) {
                count1 += 1;
            } else if (num == element2) {
                count2 += 1;
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        if (vote1 > 0 && count1 > nums.length / 3) {
            res.add(element1);
        }
        if (vote2 > 0 && count2 > nums.length / 3) {
            res.add(element2);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] element = {1, 2, 3, 3, 2, 3, 3};
        int[] element2 = {3, 3, 4};
        int[] element3 = new int[]{1, 2};
        List<Integer> actual = Main.majorityElement(element3);
        for (int tmp : actual) {
            System.out.println(tmp);
        }
    }
}
// time complexity O(n)
// space complexity O(1)
