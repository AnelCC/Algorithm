package com.anelcc;
/*
Given a string s and a string t, check if s is subsequence of t.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.



Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false


Constraints:

0 <= s.length <= 100
0 <= t.length <= 10^4
Both strings consists only of lowercase characters.
*/
public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequenceCorrect("abc","ahbgdc")); //true
        System.out.println(isSubsequenceCorrect("axc", "ahbgdc")); //false
    }


    //Simple java solution,o(n) time,o(1) space
    public static boolean isSubsequenceCorrect(String s, String t) {
        if (s == null || t == null) return false;
        if (s.isEmpty()) return true;

        int ps = 0, pt = 0;
        while (pt < t.length()) {
            if (s.charAt(ps) == t.charAt(pt)) {
                ++ps;
                if (ps == s.length()) return true;
            }
            ++pt;
        }

        return false;
    }

    //Two Pointer, Java Solution with O(m+n) time complexity and O(1) space complexity
    public static boolean isSubsequenceBad(String s, String t) {
        int count = 0;
        int countS = 0;
        for (int i=0; i< s.toCharArray().length; i++) {
            while (t.toCharArray()[countS] == s.toCharArray()[i]) {
                countS+=1;
                if (count == countS){
                    return true;
                }
            }
            count+=1;
        }
        return false;
    }

    public boolean isSubsequences(String s, String t) {
        if(s.isEmpty()){
            return true;
        }
        if(t.isEmpty()){
            return false;
        }
        int j=0;
        for(int i=0; i<s.length(); i++){
            while(j<t.length() && s.charAt(i) != t.charAt(j)){
                j++;
            }
            if(j==t.length()){
                return false;
            }
            j++;
        }
        return true;
    }
}
