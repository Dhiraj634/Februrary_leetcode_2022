import java.util.Arrays;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });
        int index = 0;int count = 0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] >= intervals[index][0] && intervals[i][1]<=intervals[index][1]){
                count++;
            }else{
                index = i;
            }
        }
        return intervals.length - count;
    }
}
