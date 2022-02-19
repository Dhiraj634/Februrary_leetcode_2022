import java.util.TreeSet;

public class MinimizeDeviationInArray {
    public int minimumDeviation(int[] nums) {

        // Multiplying every odd number by 2 so that we do not have to worry about odd numbers
        // since we do not have to handle a case where we need to multiply it to even,
        // and we can always divide an even so if actually any odd was required it can always be divided by 2
        for(int i=0;i<nums.length;i++){
            nums[i] = nums[i]%2==0 ? nums[i] : nums[i]*2;
        }
        TreeSet<Integer> set = new TreeSet<>((a,b) -> a<=b ? -1 : 1);
        for(int num : nums){
            set.add(num);
        }
        int ans = (int)Math.pow(10,9);
        while(true){
            int min = set.pollFirst();
            int max = set.pollLast();

            ans = Math.min(ans, max- min);
            if(max%2!=0){
                break;
            }else{
                max/=2;
            }
            set.add(max);
            set.add(min);
        }
        return ans;
    }
}
