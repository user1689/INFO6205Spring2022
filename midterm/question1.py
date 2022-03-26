class solution:
    def question1(self, nums, lower, upper):
        if (lower == upper):
            return []
        if (nums[-1] < lower):
            return ["%s->%s" %(lower, upper)]
        if (nums[0] > upper):
            return ["%s->%s" %(lower, upper)]

        ss = set(nums)
        tmp = []
        for num in range(lower, upper+1):
            if (num not in ss):
                tmp.append(num)
        res = []

        i = 0
        while (i < len(tmp)):
            prev = i
            while (i < len(tmp) - 1 and tmp[i] + 1 == tmp[i + 1]):
                i += 1
            if (prev == i):
                res.append("%s" %tmp[i])
            else:
                res.append("%s->%s" %(tmp[prev], tmp[i]))
            i += 1
        return res

obj = solution()
nums = [0,1,3,50,75]
lower = 0
upper = 99
res = obj.question1(nums, lower, upper)
print(res)
