class Solution {
    public boolean isAnagram(String s, String t) {
    //    char[] ch1 = s.toCharArray();
    //    char[] ch2 = t.toCharArray();
    //    Arrays.sort(ch1);
    //    Arrays.sort(ch2);
    //    return Arrays.equals(ch1,ch2); 

    if(s.length() != t.length())
    {
        return false;
    }

    int[] count = new int[26];

    for(int i=0;i<s.length();i++){
        count[s.charAt(i) - 'a']++;
        count[t.charAt(i) - 'a']--;
    }

    for(int c: count){
        if(c != 0){
            return false;
        }
    }

    return true;
    }
}