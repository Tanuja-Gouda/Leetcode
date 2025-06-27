class Solution {
    public boolean isAnagram(String s, String t) {
       char[] ch1 = s.toCharArray();
       char[] ch2 = t.toCharArray();
       if(s.length() != t.length()){
        return false;
       }
       Arrays.sort(ch1);
       Arrays.sort(ch2);
       return Arrays.equals(ch1,ch2); 
    }
}