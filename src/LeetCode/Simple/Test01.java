package LeetCode.Simple;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例：
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Test01 {
    public int[] twoSum(int[] nums,int target) {
        int[] indexs = new int[2];
        for (int i = 0; i < nums.length ; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] + nums[j] == target){
                    indexs[0] = i;
                    indexs[1] = j;
                }
            }
        }
        return indexs;
    }
    public static void main(String args[]){

    }


}
