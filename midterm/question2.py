class Node:
    def __init__(self, val, next=None):
        self.val = val
        self.next = next
      
class solution:
    def addTwoNumber(self, l1, l2):
        cur1 = l1
        cur2 = l2
        dummy = Node(-1)
        cur = dummy
        add = 0
        while (cur1 or cur2):
            total = 0
            if (cur1):
                total += cur1.val
            if (cur2):
                total += cur2.val
            total += add

            digit = total % 10
            newNode = Node(digit)
            cur.next = newNode
            cur = cur.next
            add = total // 10
            
            if (cur1):
                cur1 = cur1.next
            if (cur2):
                cur2 = cur2.next
                
        if (add > 0):
            cur.next = Node(add)
            
        return dummy.next

obj = solution()
node1 = Node(2, None)
node2 = Node(4, None)
node3 = Node(3, None)

node4 = Node(5, None)
node5 = Node(6, None)
node6 = Node(4, None)
node1.next = node2
node2.next = node3
node4.next = node5
node5.next = node6
l1 = node1
l2 = node4
ans = obj.addTwoNumber(l1, l2)
tmp = ans
while(tmp):
    print(tmp.val)
    tmp = tmp.next