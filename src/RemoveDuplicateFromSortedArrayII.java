import java.util.HashMap;

public class RemoveDuplicateFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int p1 = 0, p2 = 0;
        while(p2 < nums.length){
            int fre = map.getOrDefault(nums[p2],0);
            if(fre < 2){
                nums[p1] = nums[p2];
                map.put(nums[p2], fre+1);
                p1++;
            }
            p2++;
        }
        return p1;
    }
}
