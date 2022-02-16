public class ReverseNodesInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<=0) return head;
        int len= 0;
        ListNode tempHead = head;
        while(tempHead !=null){
            len++;
            tempHead = tempHead.next;
        }
        return reverseKGroupUtil(head,len,k);

    }
    private ListNode reverseKGroupUtil(ListNode head, int len, int k){
        if(len < k || head == null){
            return head;
        }
        ListNode prev = null, next, curr = head;
        int m=0;
        while(m < k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            m++;
        }
        head.next = reverseKGroupUtil(curr,len-k,k);
        return prev;

    }
}
