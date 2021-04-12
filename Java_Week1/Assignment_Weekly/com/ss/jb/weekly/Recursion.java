package com.ss.jb.weekly;

public class Recursion {

    // checks to see if the sum of the integers in the array add up to the target
    // if there are numbers in the array that are adjacent and identical value,
    // they must either all be used, or all excluded

    /**
     *
     * @param start the starting index to check
     * @param nums int[]
     * @param target the target sum being checked
     * @return true/false if the values of the int[] equal the target or not
     */
    public boolean groupSumClump(int start, int[] nums, int target) {
        // this case ends the recursion and checks if empty array is given
        if (start >= nums.length) {
            return (target == 0);
        }

        int sum = nums[start];
        int count = 1;
        for (int i = start + 1; i< nums.length; i++) {
            if (nums[i] == nums[start]) {
                sum += nums[i];
                count++;
            }
        }
        return groupSumClump(start + count, nums, target - sum)
                || groupSumClump(start + count, nums, target);

    }
}
