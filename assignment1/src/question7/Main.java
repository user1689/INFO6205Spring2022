package question7;

public class Main {
    public static String customSortString(String order, String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[c - 'a'] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char cc = order.charAt(i);
            while (cnt[cc - 'a'] > 0) {
                sb.append(cc);
                cnt[cc - 'a'] -= 1;
            }
        }
        for (int i = 0; i < 26; i++) {
            while (cnt[i] > 0) {
                char ccc = (char) (i + 'a');
                sb.append(ccc);
                cnt[i] -= 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String order = "zcab";
        String s = "aababacdzzz";
        System.out.println(customSortString(order, s));
    }
}
// time complexity O(n)
// space complexity O(n)
