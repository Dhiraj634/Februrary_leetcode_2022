public class AddDigits {
    public int addDigits(int num) {
        if (num ==0)return 0;
        int val = num %9;
        return val == 0 ? 9 : val;
    }
    /**
     * Another Approach
     * public int addDigits(int num) {
     *   while(num/10 !=0){
     *      int sum =0;
     *      while(num !=0){
     *          sum+=(num%10);
     *          num/=10;
     *      }
     *      num=sum;
     *    }
     *    return num;
     * }
     *
     * */
}
