package com.interviewprep.leetcode.medium.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstApproach {

	public static void main(String[] args) {

		//int[] nums = {-1,0,1,2,-1,-4};
		int[] nums = {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
		
		FirstApproach fa = new FirstApproach();
		List<List<Integer>> threeSum = fa.threeSum(nums);

		System.out.println(threeSum);

	}



	public List<List<Integer>> threeSum(int[] nums) {

		Set<List<Integer>> threeSum = new HashSet<List<Integer>>();	
		List<Integer> sumList = new ArrayList<Integer>();

		int len = nums.length;

		for(int i=0; i<len-2; i++) {

			int first = nums[i];
			for(int j=i+1; j<len-1; j++) {

				int second = nums[j];
				for(int k=j+1; k<len; k++) {

					int third = nums[k];

					if(first + second + third == 0  ) {

						sumList = new ArrayList<Integer>();
						
						sumList = Arrays.asList(first, second, third);

						// sort list before adding
						Collections.sort(sumList);

						threeSum.add(sumList);
						
					} // endIf
				} 
			} 
		} 


		return new ArrayList<List<Integer>>(threeSum);
	}

}
