public class CountTotalSetBits {
    static int countBits(int N){
        if(N == 0)
            return 0;
        int msb = getMostSignificantBit(N);
        // Counting all bits less than current msb
        int less = msb * (1 << (msb-1));
        // Now count all the msb bits after the nearest multiple of 2 less than N
        int msbOnes = N - (1 <<(msb)) + 1;
        // Mow remove those MSb and now you are left with num from 0 to N-(1<<msb)
        int repeatN = N - (1 <<(msb));
        return less + msbOnes + countBits(repeatN);
    }
    private static int getMostSignificantBit(int num){
        int count = 0;
        while(num !=0){
            count++;
            num>>=1;
        }
        count = count-1;
        return count;
    }
}
