public class SwapNodesInPair {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode ans = new ListNode();
        ListNode tempHead = ans,odd = head,even = head.next;
        while(odd !=null && even!=null){
            ListNode nextOdd = even.next;

            tempHead.next = even;
            tempHead.next.next = odd;

            if(nextOdd != null) {
                even = nextOdd.next;
            }else{
                even = null;
            }

            odd = nextOdd;
            tempHead = tempHead.next.next;
        }
        if(odd != null){
            tempHead.next = odd;
            tempHead=tempHead.next;
        }
        tempHead.next = null;
        return ans.next;
    }
}
