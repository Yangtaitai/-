Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
class Solution {
    public void deleteNode(ListNode node) {   
        node.val = node.next.val;       // 1 -> 2 -> 4 -> 4 
        node.next = node.next.next;     // 1 -> 2 -> 4
    }
}

// since we can not find the prev node, so we can copy the value after the deleted node and then delete duplicated node.
