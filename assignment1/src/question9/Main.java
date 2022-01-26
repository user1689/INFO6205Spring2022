package question9;

import java.util.*;

public class Main {
    public static int[] frequencySort(int[] nums) {
        // hashTable
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // sort
        List<Map.Entry<Integer, Integer>> tmp = new ArrayList<>(map.entrySet());
        Collections.sort(tmp, (a1, a2) -> a1.getValue().equals(a2.getValue()) ? a2.getKey() - a1.getKey() : a1.getValue() - a2.getValue());

        int[] res = new int[nums.length];
        int idx = 0;
        for (int i = 0; i < tmp.size(); i++) {
            for (int j = 0; j < tmp.get(i).getValue(); j++) {
                res[idx++] = tmp.get(i).getKey();
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] element1 = new int[]{1, 9, 1 ,1, 1, 2, 2, 2, 2, 3, 4, 4, 5, 2};
        int[] ans = frequencySort(element1);
        System.out.println(Arrays.toString(ans));
    }
}
