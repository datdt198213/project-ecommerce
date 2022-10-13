package com.dangdat.ecommerce.codeThieuNhi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class twoSum {
        public static List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();

            for(int i = 0 ; i < nums.length ; i++){

                for(int j = 0; j < nums.length; j++){
                    if(nums[i] < nums[j]){
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                    }
                }
            }

            Map<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();

            for(int i = 0; i < nums.length- 2; i++){
                for(int j = i + 1 ; j < nums.length- 1; j++){
                    for(int k = j + 1; k < nums.length ; k++){
                        List<Integer> tmp_1 = new ArrayList<Integer>();
                        if(nums[i] + nums[j] + nums[k] == 0)
                        {
                            tmp_1.add(nums[i]);
                            tmp_1.add(nums[j]);
                            tmp_1.add(nums[k]);

                            if(!map.containsKey(tmp_1))
                            {
                                map.put(tmp_1, 0);
                                result.add(tmp_1);
                            }
                        }
                    }
                }
            }

            return result;
        }
    public static void main(String[] args) {
        int [] nums = {-1, 0, 1 ,2 , -1 , -4};

        List<List<Integer>> result = threeSum(nums);
        for(int i = 0; i < result.size(); i++) {
            System.out.print("[");
            for(int j = 0; j < 3; j++) {
                System.out.print(""+result.get(i).get(j) + ",");
            }
            System.out.println("]");
        }
    }
}
