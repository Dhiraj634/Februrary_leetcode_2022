public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] fre = new int[26];
        for(char ch : s.toCharArray()){
            fre[ch - 'a']++;
        }
        for(char ch :t.toCharArray()){
            if(fre[ch-'a']==0){
                return ch;
            }
            fre[ch-'a']--;
        }
        return '\0';
    }
}
