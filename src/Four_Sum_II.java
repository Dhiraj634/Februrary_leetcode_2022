import java.util.HashMap;

public class Four_Sum_II {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num4 : nums4){
            for(int num3 : nums3){
                map.put(num3+num4,map.getOrDefault(num3+num4,0)+1);
            }
        }
        int count = 0;
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int sum = (-num1 - num2);
                if(map.containsKey(sum)){
                    count+= map.get(sum);
                }
            }
        }
        return count;
    }
}
