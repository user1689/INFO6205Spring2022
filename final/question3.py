from collections import defaultdict

class solution:
    def groupAnagrams(self, strs):
        map = defaultdict(list)
        for word in strs:
            cnt = [0] * 26
            for char in word:
                cnt[ord(char) - ord('a')] += 1
            map[tuple(cnt)].append(word)
        return list(map.values())

obj = solution()
s = ["eat","tea","tan","ate","nat","bat"]
s2 = [""]
s3 = ["a"]
res = obj.groupAnagrams(s3)
print(res)
