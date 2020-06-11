package com.anelcc.june;

public class SearchInsertPosition {

    /*
    Given a sorted array and a target value, return the index if the target is found.
    If not, return the index where it would be if it were inserted in order.

    You may assume no duplicates in the array.

    Example 1:
    Input: [1,3,5,6], 5
    Output: 2

    Example 2:
    Input: [1,3,5,6], 2
    Output: 1

    Example 3:
    Input: [1,3,5,6], 7
    Output: 4

    Example 4:
    Input: [1,3,5,6], 0
    Output: 0
    */
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
    }

    public static int searchInsert(int[] nums, int target) {
        int index = 0;
        int lowIndex = 0;
        int highIndex = nums.length-1;

        if (target < nums[0]) {
            return index;
        }

        if (target > nums[highIndex]) {
            return highIndex+1;
        }

        while (lowIndex <= highIndex) {
            int midIndex = lowIndex + (highIndex - lowIndex) / 2;
            if (target == nums[midIndex]){
                return midIndex;
            } else if (target > nums[midIndex]){
                lowIndex = midIndex+1;
            } else {
                highIndex = midIndex-1;
            }
        }
        return lowIndex;
    }
}
