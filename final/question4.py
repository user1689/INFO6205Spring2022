class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val 
        self.left = left
        self.right = right

class solution:
    def lowestCommonAncestor(self, root, p, q):
        def check(root, p, q):
            if (not root):
                return None
            if (root.val == p.val or root.val == q.val):
                return root

            leftVal = check(root.left, p, q)
            rightVal = check(root.right, p, q)

            if (leftVal and rightVal):
                return root
            elif (leftVal):
                return leftVal
            else:
                return rightVal

        return check(root, p, q)
    
obj = solution()
node1 = TreeNode(0)
node2 = TreeNode(2)
node3 = TreeNode(9)
node4 = TreeNode(10)
node5 = TreeNode(11)
node6 = TreeNode(4)
'''

    1
  /   \ 
2      9
  \   / \ 
  10 4   11

'''
node1.left = node2
node1.right = node3
node2.right = node4 
node3.left = node6 
node3.right = node5
# res = obj.lowestCommonAncestor(node1, node5, node6)
res = obj.lowestCommonAncestor(node1, node2, node3)
print(res.val)

    
