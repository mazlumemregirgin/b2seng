package leetcode.contains_duplicates;

import java.util.HashSet;

public class Solution {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> my_set = new HashSet<>();

        boolean is_include= false;
        for (int num: nums){

            if(!my_set.add(num)){
                is_include = true;
            }
        }
        return is_include;
    }
}

// add() eğer setin içinde eklediğmimz yoksa fonksiyon true dönüyor
// setin içinde varsa false dönüyor