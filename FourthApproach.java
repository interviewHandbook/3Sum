package com.interviewprep.leetcode.medium.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FourthApproach {

	public static void main(String[] args) {

		//int[] nums = {-1,0,1,2,-1,-4};
		int[] nums = {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
		//int[] nums = {0,-2,2,0,2,-4,5,5,-10};
		//int[] nums = {0,0,0};
		//int[] nums = {1,1, -2};
		
		FourthApproach fa = new FourthApproach();
		List<List<Integer>> threeSum = fa.threeSum(nums);

		System.out.println(threeSum);

	}
	
	public List<List<Integer>> threeSum(int[] nums) {

		Set<List<Integer>> threeSum = new HashSet<List<Integer>>();	
		List<Integer> sumList = new ArrayList<Integer>();

		int len = nums.length;
		Integer[][] numsSumMat = new Integer[len][len];

		for(int i=0; i<len; i++) {

			for(int j=0; j<len; j++) {

				if(i != j) {
					numsSumMat[i][j] =  nums[i] + nums[j] ;
				}
				else {
					numsSumMat[i][j] =  Integer.MAX_VALUE;
				}


			}
		}

		// flatten 2d array
		Integer[] numSumFlatten = new Integer[(len*len) + len];
		int idx = 0;
		for(int i=0; i<len; i++) {

			numSumFlatten[idx++] = i;
			for(int j=0; j<len; j++) {

				numSumFlatten[idx++] = numsSumMat[i][j] ;
			}
		}


		// now traverse and find the complement
		for(int index=0; index<len; index++) {

			int target = nums[index]*-1;
			int third = nums[index];

			int row = 0;
			int col = 0;
			int count = 1;
			
			for(int k=0; k<numSumFlatten.length; k++) {

				if(numSumFlatten[k] == target  && 
						numSumFlatten[k] != Integer.MAX_VALUE  &&
						col != 0 && index != row && index != (col-1) ) {

					int first = nums[row];
					int second = nums[col-1];

					sumList = sumList = Arrays.asList(first, second, third);

					// sort list before adding
					Collections.sort(sumList);

					threeSum.add(sumList);

				}

				// col goes from 0 to len
				if(count == len+1) {

					col = 0;
					row = row+1;
					count = 1;				

				}
				else {
					col++;
					count = count+1;
				}			

			}// endfor
		}

		return new ArrayList<List<Integer>>(threeSum);
	}

}
