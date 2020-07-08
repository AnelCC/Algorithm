package com.anelcc.june;

/*
Given an array with n objects colored red, white or white,
sort them in-place so that objects of the same color are adjacent,
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's,
then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?

 */
public class SortColors {
    private static final int RED = 0;
    private static final int WHITE = 1;
    private static final int BLUE = 2;

    public static void main(String[] args) {

        System.out.print("Result: ");
        for (int number :getSortColors(new int[]{2,0,2,1,1,0})) {
            System.out.print(+number+" ");
        }
    }

    //we need three pointer: medium, height and low
    private static int[] getSortColors(int[] nums) {
        int medium = 0;
        int height = nums.length-1;
        int low = 0;
        int temporal;

        while (medium <= height) {
            switch (nums[medium]) {
                case RED: {
                    temporal = nums[low];
                    //swipe low and medium
                    nums[low] = nums[medium];
                    nums[medium] = temporal;
                    low++;
                    medium++;
                    break;
                }
                case WHITE: {
                    medium++;
                    break;
                }
                case BLUE: {
                    temporal = nums[medium];
                    nums[medium] = nums[height]; //swipe low and medium
                    nums[height] = temporal;

                    height--; //we save at end the height number so we reduce the size of the height
                    break;
                }
            }
        }
        return nums;
    }
}
