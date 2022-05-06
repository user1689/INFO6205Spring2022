class solution:
    def compressString(self, s):
        i = 0
        j = 0
        n = len(s)
        res = ""
        while (i < n):
            cnt = 0
            while (j < n and s[j] == s[i]):
                cnt += 1
                j += 1
            res += s[i]
            res += str(cnt)
            i = j

        return res if len(res) < len(s) else s

obj = solution()
example = "aabcccccaaa"
example2 = "ab"
example3 = "abcdefg"
res = obj.compressString(example3)
print(res)