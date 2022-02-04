import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int count = 0;
        int maxLen = 0;
        for(int i= 0;i<nums.length;i++){
            int num = nums[i];
            count += (num == 1 ? 1 : -1);
            if(map.containsKey(count)){
                maxLen = Math.max(maxLen, i - map.get(count));
            }else{
                map.put(count,i);
            }
        }
        return maxLen;
    }

}
