package com.anelcc.june;
/*
Given an integer, write a function to determine if it is a power of two.

Example 1:
Input: 1
Output: true
Explanation: 20 = 1

Example 2:
Input: 16
Output: true
Explanation: 24 = 16

Example 3:
Input: 218
Output: false
*/
public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(218));
    }

    //O(n) time and space complexity simple solution
    public static boolean isPowerOfTwo(int n) {
        if (n<=0) {
            return true;
        }

        System.out.println(n);
        while (n % 2 == 0 ) {
            n = n/2;
            System.out.println(n);
        }
        return n == 1;
    }

    //O(1)
    public boolean isPowerOfTwoMath(int n) {
        return n>0 && n==Math.pow(2, Math.round(Math.log(n)/Math.log(2)));
    }
}
