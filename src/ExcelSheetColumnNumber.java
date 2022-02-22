public class ExcelSheetColumnNumber {
    /**
     * It is like finding number system having with base 26 rather than
     * binary with base 2 and decimal with base 10
     * */
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        int len = 1;
        for(int i=columnTitle.length()-1;i>=0;i--){
            int num = columnTitle.charAt(i) - 'A' + 1;
            ans += (num) * len;
            len*=26;
        }
        return ans;
    }
}
