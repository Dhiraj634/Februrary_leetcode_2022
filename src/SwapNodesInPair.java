public class SwapNodesInPair {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode ans = new ListNode();
        ListNode tempHead = ans;
        while(head !=null && head.next!=null){
            ListNode next = head.next.next;
            tempHead.next = head.next;
            tempHead.next.next = head;
            head = next;
            tempHead = tempHead.next.next;
        }
        if(head!=null)
        {
            tempHead.next = head;
            tempHead = tempHead.next;
        }
        tempHead.next = null;
        return ans.next;
    }
}
