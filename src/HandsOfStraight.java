import java.util.TreeMap;

public class HandsOfStraight {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if((hand.length % groupSize) !=0) return false;
        TreeMap<Integer,Integer> fre = new TreeMap<>();
        for(int num : hand){
            fre.put(num, fre.getOrDefault(num,0)+1);
        }
        while(fre.size() > 0){
            int min = fre.firstKey();
            for(int i=0;i<groupSize;i++){
                if(fre.containsKey(min)){
                    fre.put(min,fre.get(min)-1);
                    if(fre.get(min) == 0){
                        fre.remove(min);
                    }
                }else{
                    return false;
                }
                min++;
            }
        }
        return true;

    }

}
