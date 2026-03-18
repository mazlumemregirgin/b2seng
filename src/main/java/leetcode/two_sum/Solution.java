package leetcode.two_sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {


    public int[] twoSum(int[] nums, int target) {
        // burada brute force amele işi yapıyorum her indexi tek tek dolaşıp ikili şekilde topluyorum.
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }


    public int[] twoSumWithHashMap(int[] nums, int target) {
        // hashmap yapısı kurdum.
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // aradığımız diğer sayıyı bu şekilde buluyoruz.

            // Eğer aradığımız sayı Map'te varsa, soru bitti
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Yoksa, bu sayıyı ve indeksini ileride lazım olur diye Map'e ekliyorum
            map.put(nums[i], i);
        }
        return new int[] {};
    }

}
