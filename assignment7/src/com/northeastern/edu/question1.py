"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        '''
        bfs
        map
        '''

        if (not node):
            return node
        dic = dict()
        queue = deque()
        queue.append(node)
        clone = Node(node.val)
        dic[node] = clone
        while (queue):
            cur = queue.popleft()
            for child in cur.neighbors:
                if (child not in dic):
                    cc = Node(child.val)
                    dic[child] = cc
                    queue.append(child)
                # clone.neighbors.append(node.neighbors.child)
                dic[cur].neighbors.append(dic[child])
        return dic[node]



