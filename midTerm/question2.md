##python3
```python3
class Node:
    def __init__(self, val, next):
        self.val = val
        self.next = Node
      
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
```
