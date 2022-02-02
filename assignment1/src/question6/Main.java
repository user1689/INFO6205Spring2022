package question6;

import java.util.Arrays;

public class Main {
    public static String reorganizeString(String s) {
        if (s.length() < 2) {
            return s;
        }
        int[] cnt = new int[26];
        int maxCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[c - 'a'] += 1;
            maxCnt = Math.max(maxCnt, cnt[c - 'a']);
        }

        if (maxCnt > ((s.length() + 1 ) / 2)) {
            return "";
        }
        char[] reorganzieArr = new char[s.length()];
        int evenIndex = 0;
        int oddIndex = 1;
        int halfLength = s.length() / 2;
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            while (cnt[i] > 0 && cnt[i] <= halfLength && oddIndex < reorganzieArr.length) {
                reorganzieArr[oddIndex] = c;
                cnt[i] -= 1;
                oddIndex += 2;
            }
            while (cnt[i] > 0 && evenIndex < reorganzieArr.length) {
                reorganzieArr[evenIndex] = c;
                cnt[i] -= 1;
                evenIndex += 2;
            }
        }
        return new String(reorganzieArr);
    }

    public static void main(String[] args) {
        String example = "aaazzzab";
        String ans = reorganizeString(example);
        System.out.println(ans);
    }
}
// time complexity O(n)
// space complexity O(n)
