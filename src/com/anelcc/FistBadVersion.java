package com.anelcc;

import java.util.ArrayList;
import java.util.List;

/*
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:
Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version.
*/
public class FistBadVersion {
    static List<Boolean> statusVersion = new ArrayList();

    public static void main(String[] args) {
        // write your code here

        statusVersion.add(false);  //1
        statusVersion.add(false);  //2
        statusVersion.add(false);  //3
        statusVersion.add(true); //4
        statusVersion.add(true); //5
        statusVersion.add(true); //6
        statusVersion.add(true); //7
        statusVersion.add(true); //8
        statusVersion.add(true); //9

        firstBadVersion(statusVersion.size());
        System.out.println("firstBadVersion : "+ firstBadVersion(statusVersion.size()));
    }

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean isBadVersion(int version){
        return statusVersion.get(version-1);
    }
}
