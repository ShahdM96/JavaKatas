package katas.exercises;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {

    /**
     *
     * Given an array of integers and a sliding window size, your task is to find the maximum value
     * in the window at each position as the window slides from left to right.
     *
     * For example, given the array [1, 3, -1, -3, 5, 3, 6, 7] and window size 3:
     * The output should be [3, 3, 5, 5, 6, 7].
     *
     * @param nums the array of integers
     * @param k the size of the sliding window
     * @return a list of the maximum values in each window
     */
    public static List<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Integer> output = new ArrayList<>();
        if(nums.length == 0) return output ;
        int max = nums[0];
        for(int i=0; i<k; i++){
            if(nums[i] > max) max = nums[i];
        }
        output.add(max);
        for(int i=k; i<nums.length; i++){
            if(nums[i] > max) max = nums[i];
            output.add(max);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        List<Integer> result = maxSlidingWindow(nums, k);
        System.out.println("Sliding window maximums: " + result);
    }
}

