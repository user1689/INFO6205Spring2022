package question3;

public class Main {
    public static int hIndex(int[] citations) {
        int n = citations.length;
        int[] cnt = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] > n) {
                cnt[n] += 1;
            } else {
                cnt[citations[i]] += 1;
            }
        }
        int tmp = 0;
        for (int i = n; i >= 0; i--) {
            tmp += cnt[i];
            if (tmp >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] element1 = new int[]{3, 0, 6, 1, 5};
        int res = hIndex(element1);
        System.out.println(res);
    }
}
// time complexity O(n)
// space complexity O(n)
