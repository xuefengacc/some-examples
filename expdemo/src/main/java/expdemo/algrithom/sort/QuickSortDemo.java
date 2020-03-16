package expdemo.algrithom.sort;

public class QuickSortDemo {

	
	public static void quickSort(int array[], int left, int right) {
		//check if empty 
		if(array.length==0 || array==null) {
			return;
		}
		//stop recusivily when finished
		if(left>=right) {
			return;
		}
		//select the pivot
		int middle = left+(right-left)/2;
		int pivot = array[middle];
		//make sure all element left of pivot smaller than pivot, and same for right
		int i=left, j=right;
		while(i<=j) {
			while(array[i]<pivot) {
				i ++;
			}
			while(array[j]>pivot) {
				j --;
			}
			if(i<=j) {
				swap(array, i, j);
				i ++;
				j --;
			}
		}
		//sort sub array
		if(i<right) {
			quickSort(array,i,right);
		}
		if(j>left) {
			quickSort(array,left,j);
		}
		
	}
	
	public static void swap(int array[], int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
}
