class UF:
    def __init__(self, n):
        self.size = n
        self.p = [i for i in range(n)]
    def find(self, x):
        if (x != self.p[x]):
            self.p[x] = self.find(self.p[x])
        return self.p[x]
    def union(self, a, b):
        x = self.find(a)
        y = self.find(b)
        if (x != y):
            self.p[x] = self.p[y]
            self.size -= 1
        else:
            return 

class solution:
    def numIslands(self, grid):
        row = len(grid)
        col = len(grid[0])
        uf = UF(row * col)
        cnt_ocean = 0
        for i in range(row):
            for j in range(col):
                if (grid[i][j] == '1'):
                    if (i + 1 < row and grid[i+1][j] == '1'):
                        uf.union(i*row+j, (i+1)*row+j)
                    if (j + 1 < col and grid[i][j + 1] == '1'):
                        uf.union(i*row+j, i*row+(j+1))
                else:
                    cnt_ocean += 1
        return uf.size - cnt_ocean

obj = solution()
grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
grid2 = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
res = obj.numIslands(grid2)
print(res)
