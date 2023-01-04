package com.uday.practise.ps.array;

import java.util.HashMap;
import java.util.Map;

class TargetSum {

    public static void main(String[] args) {
        TargetSum m = new TargetSum();

        int[] arr = {4,1,2,3,5,6,4,7,9,10,0, 6,4};
        m.twoSum(arr, 10);
    }
    public void twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                System.out.println("(" + nums[map.get(target-nums[i])] + "," + nums[i] + ")");
            } else {
                map.put(nums[i], i);
            }
        }
    }


}