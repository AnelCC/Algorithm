package com.anelcc.july;
/*
Given a sorted array arr[] of n elements, write a function to search a given element x in arr[].
A simple approach is to do linear search.The time complexity of above algorithm is O(n).
Another approach to perform the same task is using Binary Search.
 */
public class BinarySearchFindXNumberPosition {

    public static void main(String[] args) {
        System.out.println(FindNumberPosition(new int[]{1,2,3,4,5,6,7,8,9,10}, 6));
    }

    private static int FindNumberPosition(int[] numbers, int numberX) {
        int l = 0;
        int r = numbers.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (numbers[m] == numberX)
                return m;

            // If x greater, ignore left half
            if (numbers[m] < numberX)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return -1;
    }

}
