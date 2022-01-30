package question10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static List<String> topKFrequentWords(String[] words, int k) {
        // hash
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // priorityQueue
        PriorityQueue<String> minHeap = new PriorityQueue<>((s1, s2) -> {
            if (map.get(s1).equals(map.get(s2))) {
                return s2.compareTo(s1);
            } else {
                return map.get(s1) - map.get(s2);
            }
        });
        // push element into pq
        for (String s : map.keySet()) {
            minHeap.offer(s);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // build ans
        List<String> res = new ArrayList<>();
        while (minHeap.size() > 0) {
            res.add(minHeap.poll());
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        String[] element1 = {"a", "a", "i", "love", "a", "i", "i", "love"};
//        String a = "a";
//        String b = "b";
//        System.out.println(a.compareTo(b));
//        System.out.println(b.compareTo(a));
        int k = 2;
        List<String> ans = topKFrequentWords(element1, k);
        for (String s : ans) {
            System.out.println(s);
        }
    }
}
// time complexity O(n)
// space complexity O(n)
