package com.interviewprep.leetcode.medium.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FifthApproach {

	public static void main(String[] args) {
		
		//int[] nums = {-1,0,1,2,-1,-4};   //-4, -1, -1, 0, 1, 2
		int[] nums = {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
		//int[] nums = {0,-2,2,0,2,-4,5,5,-10};
		//int[] nums = {-2,0,0,1,-1,2};  // -2, -1, 0, 0, 1, 2
		//int[] nums = {0,0,0,0}; 
		//int[] nums = {-1,0,1,0};   // -1, 0, 0, 1
		//int[] nums = {-2,0,1,1,2} ;  // -2, 0, 1, 1, 2
		//int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};  // 
		//int[] nums = {-1, -1, 0, 0, 1, 1, 1};
		
		FifthApproach fa = new FifthApproach();
		List<List<Integer>> threeSum = fa.threeSum(nums);

		System.out.println(threeSum);

	}
	
	
	
	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> threeSum = new ArrayList<List<Integer>>();	

		Arrays.sort(nums);

		int len = nums.length;

		for(int i=0; i<len-2; i++) {

			// skip duplicates
			if(i>0 && nums[i] == nums[i-1]) {
				continue;
			}

			int left = i+1;
			int right = nums.length-1;

			while(left < right) {

				int sum = nums[i] + nums[left] + nums[right];

				if(sum == 0) {

					threeSum.add(Arrays.asList(nums[i] , nums[left] , nums[right]));

					// skip duplicates
					while (left < right && nums[right] == nums[right - 1]) right--;
					while (left < right && nums[left] == nums[left + 1]) left++; 

					left++;
					right--;

				} //endif
				else if(sum < 0) {

					left++;
				}
				else if(sum > 0) {

					right--;
				}

			} // endwhile

		}// end outer for loop

		return threeSum;

	}		

}
