import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()) return new ArrayList<>();
        int[] fre = new int[26];
        int[] tempFre = new int[26];
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<p.length();i++){
            fre[p.charAt(i) - 'a']++;
            tempFre[s.charAt(i) - 'a']++;
        }
        int index = p.length(), lp = p.length();
        boolean  isAnagram =checkFre(fre, tempFre,p);
        if(isAnagram)ans.add(0);
        while(index< s.length()){
            tempFre[s.charAt(index-lp) - 'a']--;
            tempFre[s.charAt(index)-'a']++;
            isAnagram =checkFre(fre, tempFre,p);
            if(isAnagram)ans.add(index-lp+1);
            index++;
        }

        return ans;
    }
    private boolean checkFre(int[] fre,int[] tempFre,String p){
        int count = 0;
        for(int i=0;i<p.length();i++){
            int index = p.charAt(i) - 'a';
            if(fre[index]!=tempFre[index]){
                count++;
            }
        }
        return count == 0;
    }
}
