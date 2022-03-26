from locale import resetlocale


class TreeNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class solution:
    def constructTree(self, preorder, inorder):

        def dfs(preorderleft, preorderright, inorderleft, inorderright):
            if (preorderleft > preorderright):
                return None
            if (preorderleft == preorderright):
                return TreeNode(preorder[preorderleft])
            
            rootVal = preorder[preorderleft]
            rootIdx = map[rootVal]
            leftSideLength = rootIdx - inorderleft

            root = TreeNode(rootVal)
            root.left = dfs(preorderleft + 1, preorderleft + leftSideLength, inorderleft, rootIdx - 1)
            root.right = dfs(preorderleft + leftSideLength + 1, preorderright, rootIdx + 1, inorderright)

            return root
            
        map = dict()
        for idx, num in enumerate(inorder):
            map[num] = idx
        return dfs(0, len(preorder) - 1, 0, len(inorder) - 1) 

    def dfs(self, root):
        if (not root):
            print("None")
            return 
        
        print(root.val)
        self.dfs(root.left)
        self.dfs(root.right)

obj = solution()
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
res = obj.constructTree(preorder, inorder)
obj.dfs(res)