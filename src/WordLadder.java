import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        wordList.add(0,beginWord);
        for(int i=0;i<wordList.size();i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i< wordList.size() ;i++){
            for(int j=i+1;j<wordList.size();j++){
                if(compareString(wordList.get(i), wordList.get(j))){
                    map.get(i).add(j);
                    map.get(j).add(i);
                }
            }
        }
        int[] level = new int[wordList.size()];
        boolean[] added = new boolean[wordList.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        level[0] = 1;
        added[0]=true;

        while(queue.size() > 0){
            int node = queue.poll();
            for(int nextNode : map.get(node)){
                if(!added[nextNode]){
                    level[nextNode] = level[node] + 1;
                    queue.add(nextNode);
                    added[nextNode] = true;
                    if(endWord.equals(wordList.get(nextNode))){
                        return level[nextNode];
                    }
                }
            }
        }
        return 0;
    }
    private boolean compareString(String s1, String s2){
        int count = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
            }
        }
        return count==1;
    }
}
