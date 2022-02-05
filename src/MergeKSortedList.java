public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        /**
         * FIRST APPROACH (NOT OPTIMIZED)
         * ListNode ans = null;
         * for(int i=0;i<lists.length;i++) {
         * ans = mergeSortedList(ans, lists[i]);
         * }
         * return ans;
         * */

        /**
         * SECOND APPROACH (OPTIMIZED)
         * DIVIDE AND CONQUER
         * */
        if(lists.length == 0) return null;
        return mergeKListsUtil(lists,0, lists.length-1);
    }
    private ListNode mergeKListsUtil(ListNode[] lists, int start, int end){
        if(start == end) return lists[start];
        int mid = (start + end)/2;
        ListNode left = mergeKListsUtil(lists,start,mid);
        ListNode right = mergeKListsUtil(lists,mid+1,end);
        return mergeSortedList(left,right);
    }
    private ListNode mergeSortedList(ListNode head1, ListNode head2){
        ListNode ansHead = new ListNode();
        ListNode temp = ansHead;
        while(head1!=null && head2!=null){
            if(head1.val <= head2.val){
                temp.next = head1;
                ListNode node =  head1.next;
                head1.next = null;
                head1 = node;
            }else{
                temp.next = head2;
                ListNode node =  head2.next;
                head2.next = null;
                head2 = node;
            }
            temp = temp.next;
        }
        if(head1 != null){
            temp.next = head1;
        }
        if(head2 != null){
            temp.next = head2;
        }
        return ansHead.next;

    }
}
