package com.anelcc;

import java.util.HashMap;
import java.util.Map;

/*
Given an arbitrary ransom note string and another string containing letters from all the magazines,
write a function that will return true if the ransom note can be constructed from the magazines;
otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true


Constraints:

You may assume that both strings contain only lowercase letters.
*/
public class RansomNote {
    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
        System.out.println(canConstruct("abacda", "abcddcbaaab"));
        System.out.println(canConstruct("abacda", "aabbccdd"));
    }

//  Time Complexity: O(m + n), where m = length of magazine and n = length of ransom note
//  Space Complexity: O(m) where m = length of the magazine
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();

        // looping to check all magazine letter.
        for(int i=0; i < magazine.length(); i++){
            // Increment count for each magazine letter.
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i),0)+1);
        }

        // looping to check all ransomNote letter.
        for (int i=0; i < ransomNote.length(); i++){
            // verify if magazine map contains ransomNote letter Key.
            if (map.containsKey(ransomNote.charAt(i))) {
                //verify if ransomNote Key has more letters if not then return false
                if (map.get(ransomNote.charAt(i)) <= 0) return false;
            } else {
                return false;
            }

            //since each letter in magazine can only be used only once,
            // so if it exists in ransomNote but not in magazine as would be the case if the decremented freq value goes below 0
            map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i))-1);
        }

        return true;
    }
}
