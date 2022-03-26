class solution:
    def mergeInterval(self, intervals):
        stack = []
        for i in range(0, len(intervals)):
            curLeft = intervals[i][0]
            curRight = intervals[i][1]
            if (stack and stack[-1][1] < curLeft):
                stack.append([curLeft, curRight])
                continue
            while (stack and stack[-1][0] <= curRight):
                left, right = stack.pop()
                curLeft = min(left, curLeft)
                curRight = max(right, curRight)
            stack.append([curLeft, curRight])
        return stack

obj = solution()
intervals = [[1,3],[2,6],[8,10],[15,18]]
intervals2 = [[1,4],[4,5]]
ans = obj.mergeInterval(intervals2)
print(ans)
                
