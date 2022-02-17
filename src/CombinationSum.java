import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> ans ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        find(candidates,target,0,new ArrayList<>());
        return ans;
    }
    private void find(int[] candidates, int target, int lastIndex, ArrayList<Integer> arr){
        if(target < 0) return;
        if(target == 0){

            ArrayList<Integer> a = new ArrayList<>(arr);
            ans.add(a);
            return;

        }

        for(int i = lastIndex;i<candidates.length;i++){
            if(candidates[i] <= target){
                arr.add(candidates[i]);
                find(candidates, target-candidates[i],i,arr);
                arr.remove(arr.size()-1);
            }
        }
    }
}
