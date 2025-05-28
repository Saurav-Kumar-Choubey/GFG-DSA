class Solution {
    static char nonRepeatingChar(String s) {
        // code here
        
        HashMap<Character,Integer> mp = new HashMap<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(mp.get(ch)==1) 
            return ch;
        }
        return '$';
    }
}
