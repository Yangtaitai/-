
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // better method
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
         return mergeList(lists,0,lists.length - 1);
    }
    
    public ListNode mergeList(ListNode[] list, int start, int end) {
        if (start == end) {
            return list[start];
        } else if (start < end) {
            int mid = start + (end - start) / 2;
            ListNode first = mergeList(list,start,mid);
            ListNode second = mergeList(list,mid + 1, end);
            return mergeTwo(first,second);
        } else {
            return null;
        }
    }
    
    // return merged node
    public ListNode mergeTwo(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        node.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
    
    // earlier version method.
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        ListNode merge = new ListNode(0);
        int i = 1;
        ListNode temp = mergeTwo(lists[0],null);
        merge.next = temp;  // incase there [[1]]; it will not enter the while loop
        
        while(i < lists.length) {
            merge.next = mergeTwo(temp,lists[i]);
            temp = merge.next;  // where i wrong before
            i++;
        }
        return merge.next;
    }
}
