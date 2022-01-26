package question4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for (int num : nums1) {
            s1.add(num);
        }
        for (int num : nums2) {
            s2.add(num);
        }

        int[] res = intersectionSet(s1, s2);
        return res;
    }

    public static int[] intersectionSet(Set<Integer> s1, Set<Integer> s2) {
        if (s1.size() > s2.size()) {
            return intersectionSet(s2, s1);
        }
        Set<Integer> tmp = new HashSet<>();
        for (int ss : s1) {
            if (s2.contains(ss)) {
                tmp.add(ss);
            }
        }
        int[] res = new int[tmp.size()];
        int i = 0;
        for (int ss : tmp) {
            res[i++] = ss;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 2, 2, 2, 3};
        int[] nums2 = {6, 7, 4, 2, 4, 5, 7, 7, 2, 3, 1};
        int[] res = intersection(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
}

// time complexity O(n)
// space complexity O(n)
