package com.anelcc.may;

import java.util.HashMap;
/*
Given an array of size n, find the majority element.
The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:
Input: [3,2,3]
Output: 3

Example 2:
Input: [2,2,1,1,1,2,2]
Output: 2
*/
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
    }

    /*
    We can use a HashMap that maps elements to counts in order
    to count occurrences in linear time by looping over nums.
    Then, we simply return the key with maximum value.
    */
    private static int majorityElement(int[] nums) {
        final int[] majorityElement = {0};
        final int[] majorityElementKey = {0};
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);

        }
        count.forEach((k, v) -> {
            System.out.format("key: %s, value: %d%n", k, v);
            if (majorityElement[0] < v) {
                majorityElement[0] = v;
                majorityElementKey[0] = k;
            }
        });
        return majorityElementKey[0];
    }
/*
Complexity Analysis

Time complexity : O(n)

We iterate over nums once and make a constant time HashMap insertion on each iteration. Therefore, the algorithm runs in O(n)O(n) time.

Space complexity : O(n)

At most, the HashMap can contain [n - (n \ 2)] associations, so it occupies O(n) space.
This is because an arbitrary array of length nn can contain nn distinct values,
but nums is guaranteed to contain a majority element, which will occupy (at minimum) [n/2] + 1 array indices.
Therefore, n - ([n/2] + 1) indices can be occupied by distinct, non-majority elements (plus 1 for the majority element itself),
leaving us with (at most) n - [n/2] distinct elements.*/
}
