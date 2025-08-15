package com.interviewprep.leetcode.medium.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThirdApproach {

	public static void main(String[] args) {

		int[] nums = {-1,0,1,2,-1,-4};  // -4, -1, -1, 0, 1, 2
		//int[] nums = {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
		//int[] nums = {0,-2,2,0,2,-4,5,5,-10};
		//int[] nums = {1,2,-3};

		ThirdApproach ta = new ThirdApproach();
		List<List<Integer>> threeSum = ta.threeSum(nums);

		System.out.println(threeSum);

	}
	
	
	
	
	public List<List<Integer>> threeSum(int[] nums) {

		Set<List<Integer>> threeSum = new HashSet<List<Integer>>();	
		List<Integer> sumList = new ArrayList<Integer>();

		Map<String, Integer> numsSumMap = new HashMap<>();

		int len = nums.length;
		
		// create the 2-D sum matrix
		for(int i=0; i<len; i++) {

			for(int j=0; j<len; j++) {

				if(i!=j) {
					
					String val = i +"," + j;
					numsSumMap.put( val, nums[i] + nums[j]);
				}
			}
		}

		
		// now traverse the input and see if its complement exists in above matrix
		for(int k=0; k<len; k++) {

			int target = nums[k]*-1;
			int third = nums[k];

			if(numsSumMap.containsValue(target)) {

				for(String key: numsSumMap.keySet()) {

					if(numsSumMap.get(key).equals(target)) {

						String val = key;

						String[] valArr = val.split(",");

						int i = Integer.parseInt(valArr[0]);
						int j = Integer.parseInt(valArr[1]);

						int first = nums[i];
						int second = nums[j];

						if(  i != j && j!=k && i!=k ) {

							//sumList = new ArrayList<Integer>();
							
							sumList = Arrays.asList(first, second, third);

							// sort list before adding
							Collections.sort(sumList);

							threeSum.add(sumList);
						} // endIf

					}
				}				

			}
		}

		return new ArrayList<List<Integer>>(threeSum);

	}

}
