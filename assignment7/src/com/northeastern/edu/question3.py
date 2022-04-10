class Solution:
    def maximalPathQuality(self, values: List[int], edges: List[List[int]], maxTime: int) -> int:
        '''
        v = 1000
        e = 4*1000
        sparse graph

        10+10 + 15+15 = 50 > 49 (x)

        '''

        h = [-1] * 4022
        e = [0] * 4022
        ne = [0] * 4022
        times = [0] * 4022
        idx = 0

        def add(a, b, x):
            nonlocal idx
            e[idx] = b
            ne[idx] = h[a]
            times[idx] = x
            h[a] = idx
            idx += 1

        # build graph
        for ee in edges:
            add(ee[0], ee[1], ee[2])
            add(ee[1], ee[0], ee[2])

        # search
        def dfs(u, total, cur_time):
            nonlocal res
            if (cur_time > maxTime):
                return
            if (u == 0):
                res = max(res, total)

            i = h[u]
            while (i != - 1):
                b = e[i]
                tt = times[i]
                if (not visited[b]):
                    visited[b] = 1
                    dfs(b, total + values[b], cur_time+tt)
                    visited[b] = 0
                else:
                    dfs(b, total, cur_time+tt)
                i = ne[i]

        res = 0
        visited = [0] * 4022
        visited[0] = 1
        dfs(0, values[0], 0)
        return res