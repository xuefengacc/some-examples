package expdemo.algrithom.sort;

public class MergeSortDemo {
    
	@SuppressWarnings("rawtypes")
	public static Comparable[] mergesort(Comparable[] list) {
		//If list is empty, no need sort
		if(list.length<=1) {
			return list;
		}
		
		//split list into two part
		Comparable[] left = new Comparable[list.length/2];
		Comparable[] right = new Comparable[list.length - left.length];
		System.arraycopy(list, 0, left, 0, left.length);
		System.arraycopy(list,left.length,right,0,right.length);
		
		//sort each part recursively
		//merge both halves together, overwritting to orignal list
		
		merge(left,right,list);
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void merge(Comparable[] left, Comparable[] right, Comparable[] result) {
	    //index position of left list
		int iLeft = 0;
		//index position of right list
		int iRight = 0;
		//index position of result list
		int iMerged = 0;
		//compare the elements of iLeft and iRight
		//move the smaller one to iMerged
		while(iLeft<left.length && iRight<right.length) {
			if(left[iLeft].compareTo(right[iRight])<0) {
				result[iMerged] = left[iLeft];
				iLeft ++;
			} else {
				result[iMerged] = right[iRight];
				iRight ++;
			}	
		}
		//copy remaining elements from both halves
		System.arraycopy(result, 0, left, 0, left.length);
		System.arraycopy(result, left.length, right, 0, result.length - left.length);
		
	}
}
