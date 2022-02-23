import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int totalTask = difficulty.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        // Using map to store the maximum profit for same difficulty
        for(int i=0;i<totalTask;i++){
            map.putIfAbsent(difficulty[i],0);
            if(map.get(difficulty[i]) < profit[i])
                map.put(difficulty[i],profit[i]);
        }
        int[][] tasks = new int[map.size()][2];
        int i = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            tasks[i][0] = entry.getKey();
            tasks[i][1] = entry.getValue();
            i++;
        }
        int ans = 0;
        // Sorting based on difficulty in ascending order
        Arrays.sort(tasks, (task1,task2)->task1[0] - task2[0]);
        int max = tasks[0][1];
        //Storing maximum profit among all the difficulty less than equal to current one
        for(i=0;i<tasks.length;i++){
            if(tasks[i][1] <= max){
                tasks[i][1] = max;
            }else{
                max = tasks[i][1];
            }

        }
        for(int person : worker){
            int index = greatestNumberLessThanKey(tasks,person);
            if(index < 0) continue;
            int tempPr = tasks[index][1];
            ans+=tempPr;
        }
        return ans;

    }
    // get the index of the greatest number less tyhan the key
    private int greatestNumberLessThanKey(int[][] tasks, int key){
        int start = 0, end = tasks.length-1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(tasks[mid][0] == key){
                return mid;
            }else if(tasks[mid][0] > key){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return end;

    }
}
