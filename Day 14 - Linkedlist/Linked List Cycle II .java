public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head,fast=head;
        
        while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
          if (slow == fast) {
            break;
          }
        }
        
        if(fast==null || fast.next==null){
            return null;
        }
        
        slow=head;
        while(slow!=fast){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;  
    }
}