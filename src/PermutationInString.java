public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();

        if(l2<l1) return false;

        int[] fre = new int[26];

        for(int i=0;i<l1;i++){
            int index = s1.charAt(i)-'a';
            fre[index]++;
        }
        int[] runningFre = new int[26];
        for(int i=0;i<l1;i++){
            int index = s2.charAt(i) - 'a';
            runningFre[index]++;
        }
        if(checkFre(fre, runningFre,s1))return true;
        for(int i=l1;i<l2;i++){
            runningFre[s2.charAt(i-l1)-'a']--;
            runningFre[s2.charAt(i)-'a']++;
            if(checkFre(fre,runningFre,s1))return true;
        }
        return false;

    }
    private boolean checkFre(int[] fre,int[] runningFre,String s1){
        for(char ch : s1.toCharArray()){
            if(fre[ch -'a'] != runningFre[ch -'a']){
                return false;
            }
        }
        return true;
    }
}
