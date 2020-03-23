package expdemo.algrithom;

public class BinarySearch {

	//binary search recursively
	static int recurBinarySearch(int arr[], int l, int r, int x){
		if(r>=l) {
			int mid = l + (r-l)/2;
			
			if(arr[mid] == x) {
				return mid;
			}
			
			if(x > arr[mid]) {
				recurBinarySearch(arr, mid+1, r, x);
			}
			
			recurBinarySearch(arr, l, mid-1, x);
		}
		return -1;
	}
	
	//binary search iteratly
	static int iterBinarySearch(int arr[], int x) {
		int l = 0, r = arr.length - 1;
		
		while(l<=r) {
			int mid = l + (r - l)/2;
			
			if(arr[mid] == x) {
				return mid;
			}
			
			if(arr[mid] < x) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		//int res = Arrays.binarySearch(arr, key);
		//int res = Collections.binarySearch(arr, key);
	}
	
}
