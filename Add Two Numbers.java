You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // better
    public ListNode addTwoNumbers(ListNode l1,ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        
        int carry = 0;
        for(ListNode i = l1, j = l2; i != null || j != null;) {
            int sum = carry;
            
            sum += (i == null ? 0 : i.val);
            sum += (j == null ? 0: j.val);
            
            head.next = new ListNode(sum % 10);
            carry = sum / 10;
            
            head = head.next;
            
            i = i == null ? null : i.next;
            j = j == null ? null : j.next;
        }
        
        if (carry == 1) {
            head.next = new ListNode(1);
        }
        return dummy.next;
    }
    
    // original
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            head.next = new ListNode(val);
            
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            int sum = l1.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            head.next = new ListNode(val);
            
            head = head.next;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            int sum = l2.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            head.next = new ListNode(val);
            
            head = head.next;
            l2 = l2.next;
        }
        
        if (carry == 1) {
            head.next = new ListNode(1);
        }
        
        return dummy.next;
    }
}
