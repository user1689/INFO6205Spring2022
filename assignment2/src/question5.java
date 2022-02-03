import java.util.*;

public class question5 {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>(){
            public int compare(int[] m, int[] n){
                return m[1] - n[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            if (pq.size() == k) {
                if (pq.peek()[1] < val) {
                    pq.poll();
                    pq.offer(new int[]{key, val});
                }
            } else {
                pq.offer(new int[]{key, val});
            }
        }

        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = pq.poll()[0];
        }
        return ret;

    }

    public static void main(String[] args) {
        int[] example = new int[]{1, 1, 2, 3, 4, 4, 4};
        int[] ans = topKFrequent(example, 3);
        System.out.println(Arrays.toString(ans));
    }
}
