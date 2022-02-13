import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        return getSubsets(nums,0);
    }
    private List<List<Integer>> getSubsets(int[] nums, int index){
        if(index == nums.length){
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            return ans;
        }
        List<List<Integer>> temp = getSubsets(nums,index+1);
        List<List<Integer>> ans = new ArrayList<>(temp);
        for(List<Integer> list : temp){
            List<Integer> l = new ArrayList<>(list);
            l.add(nums[index]);
            ans.add(l);
        }
        return ans;
    }
}
