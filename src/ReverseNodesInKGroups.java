public class ReverseNodesInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<=0) return head;
        int len= 0;
        ListNode tempHead = head;
        while(tempHead !=null){
            len++;
            tempHead = tempHead.next;
        }

        return reverseKGroupsUtil(head,len,k);

    }
    private ListNode reverseKGroupUtilRecursive(ListNode head, int len, int k){
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
        head.next = reverseKGroupUtilRecursive(curr,len-k,k);
        return prev;

    }
    /**
     * This non-recursive approach is derived from the recursive one
     * since in the recursive approach we can see that we require only the last element of the previous group,
     * so we can store that in a variable [here tempAns] in the recursive solution and head as always points to
     * the first element of the group.
     * */
    private  ListNode reverseKGroupsUtil(ListNode head, int len, int k){
        ListNode ans = new ListNode();
        ListNode tempAns = ans;
        while(len >= k){
            ListNode prev = null, next, curr = head;
            int m=0;
            while(m < k){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                m++;
            }
            len-=k;
            tempAns.next = prev;
            tempAns = head;
            head = curr;
        }
        tempAns.next = head;

        return ans.next;
    }
}
