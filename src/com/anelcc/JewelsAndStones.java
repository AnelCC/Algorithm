package com.anelcc;

import java.util.HashSet;

/*
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive,
so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.
*/
public class JewelsAndStones {

    /*
    Assuming that string J has m characters and string S has n characters,
    the time complexity is O(m + n).
    Time complexity of set(J) is O(m).
    Then traverse characters of string S, time complexity is O(n).
    For each character, we check whether it exists in the set J, time complexity is O(1).
    Therefore, time complexity is O(m + n * 1) = O(m + n).
    */
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }

    //J = "aA", S = "aAAbbbb"
    public static int numJewelsInStones(String J, String S) {
        HashSet<Character> jewels = new HashSet<>();
        int numJewels = 0;

        for (char c: J.toCharArray()) {
            System.out.println("Anel::: "+ c );
            jewels.add(c);
        }

        for (char c: S.toCharArray()) {
            if(jewels.contains(c)){
                numJewels++;
            }
        }

        return numJewels;
    }
}
