import java.util.*;

public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        HashSet<String> added = new HashSet<>();
        int count = 0;
        if(k==0){
            for(int num:map.keySet()){
                if(map.get(num)>1){
                    count++;
                }
            }
        }else{
            for(int num : nums){
                if(map.containsKey(num+k)){
                    String pair = num + ","+(num+k);
                    if(!added.contains(pair)){
                        added.add(pair);
                        count++;
                    }
                }
                if(map.containsKey(num-k)){
                    String pair = (num-k) + ","+num;
                    if(!added.contains(pair)){
                        added.add(pair);
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
