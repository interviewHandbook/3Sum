package com.interviewprep.leetcode.medium.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecondApproach {

	public static void main(String[] args) {
		
		
		//int[] nums = {-1,0,1,2,-1,-4};
		int[] nums = {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
		//int[] nums = {0,-2,2,0,2,-4,5,5,-10};
		
		SecondApproach fa = new SecondApproach();
		List<List<Integer>> threeSum = fa.threeSum(nums);
		
		System.out.println(threeSum);
	}
	
	
	public List<List<Integer>> threeSum(int[] nums) {

		Set<List<Integer>> threeSum = new HashSet<List<Integer>>();	
		List<Integer> sumList = new ArrayList<Integer>();
			
		Arrays.sort(nums);
		
		int len = nums.length;			

		for(int i=0; i<len-2; i++) {
			
			// skip duplicates
			if(i>0 && nums[i] == nums[i-1]) 
				continue;

			int first = nums[i];
			Set<Integer> numsSet = new HashSet<>();
			
			for(int j=i+1; j<len; j++) {

				int second = nums[j];
				
				// target val
				int third = (first+second)*-1;
								
				// check if target exists in map
				if(numsSet.contains(third)) {

					sumList = new ArrayList<Integer>();
					
					sumList.add(first);
					sumList.add(second);
					sumList.add(third);

					// sort list before adding
					Collections.sort(sumList);
					threeSum.add(sumList);

				
				}
				numsSet.add(nums[j]);

			} 
		} 

		return new ArrayList<List<Integer>>(threeSum);
	
		
	}

}
