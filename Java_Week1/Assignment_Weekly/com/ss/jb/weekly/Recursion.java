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
        if (start >= nums.length) {
            return (target == 0);
        }

        if (start !=0 ) {
            int count = 0;
            int i = start;
            while (i < nums.length && nums[start] == nums[i]) {
                count++;
                i++;
            }

            //choose all adjacent identical--i took off the (-1) from count
            if (groupSumClump(i, nums, target - ((count) * nums[start]))) return true;

            //choose none
            if (groupSumClump(i, nums, target)) return true;
            return false;
        }
        else {

        //choose
            if(groupSumClump(start+1, nums, target-nums[start])) return true;

        //dont choose
            if(groupSumClump(start+1, nums, target)) return true;

            return false;
        }
    }
}
