package com.ankit.practice.problems;

import java.util.HashMap;
import java.util.Map;

public class SolutionTwoSum {

    Map<Integer,Integer> sumMap = new HashMap<Integer,Integer>();
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for(int i =0 ; i < nums.length; i++){
            
            if(sumMap.containsKey(nums[i])){
                arr[0] = sumMap.get(nums[i]);
                arr[1] = i;
            } else {
                int reqSum = target - nums[i];
                
                sumMap.put(reqSum,i);
                
            }
            
        }
        
        return arr;
    }
}