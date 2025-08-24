package Algorithms;

//sorting in ascending order
public class Sort {

	// swapping adjacents as such in iteration one val is intended to sort that is
	// the max in the array is pushed to the end
	public void bubble(int[] list) {
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list.length - i - 1; j++) {
				if (list[j + 1] < list[j]) {
					int temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
				}
			}
		}
	}

	// finds the max and swaps where swapping only once after finding the max as
	// such n iterations happens
	public void selection(int list[]) {
		for (int i = 0; i < list.length; i++) {
			int max_index = 0;
			for (int j = 1; j < list.length - i; j++) {
				if (list[max_index] < list[j]) {
					max_index = j;
				}
			}
			int temp = list[max_index];
			list[max_index] = list[list.length - i - 1];
			list[list.length - i - 1] = temp;
		}
	}

	// the given array assumed to have sorted and unsorted regions;
	// where intially only the first element is considered to be in the sorted
	// region.
	// in each iteration one element from unsorted region is inserted in sorted
	// region at approprate index
	// by shifting the items until we find the small item than the "item that we
	// tend to sort"
	public void insertion(int list[]) {
		for (int i = 1; i < list.length; i++) {
			int k = i - 1;
			int curr = list[i];
			while (k >= 0 && curr < list[k]) {
				list[k + 1] = list[k];
				k--;
			}
			list[k + 1] = curr;
		}
	}

	// merge sort helper: regular, using auxillary space
	private void merge(int list[], int start, int end, int mid) {
		int l1 = mid - start;
		int l2 = end - mid;
		int a[] = new int[l1 + 1];
		int b[] = new int[l2];

		for (int i = 0; i <= l1; i++) {
			a[i] = list[start + i];
		}
		for (int j = 0; j < l2; j++) {
			b[j] = list[mid + 1 + j];
		}
		int i = 0, j = 0, k = start;
		while (i < a.length && j < b.length) {
			if (a[i] <= b[j]) {
				list[k] = a[i];
				i++;
			} else {
				list[k] = b[j];
				j++;
			}
			k++;
		}

		while (i < a.length) {
			list[k] = a[i];
			i++;
			k++;
		}

		while (j < b.length) {
			list[k] = b[j];
			j++;
			k++;
		}

	}
    
	//always nlogn runtime but usually needs auxillary space
	// stable sorting: order is preserved
	public void merge_sort(int list[], int start, int end) {
		if (start >= end) {
			return;
		}
		int mid = start + (end - start) / 2;

		merge_sort(list, start, mid);
		merge_sort(list, mid + 1, end);
		merge(list, start, end, mid);
	}
    
	//sliding technique: last element is chosen as pivot
	//the slider increments only when it found the element that is smaller then pivot and swaps.
	private int partition_with_sliding(int list[], int start, int end){
        int pivot = list[end];
        //tracks the last element in the subset that lesser than pivot
		int slider = start-1;
        int i =start;
	    while(i < end){
			if(list[i]<=pivot)
			{						   
                slider++;
				int temp = list[slider];
				list[slider]=list[i];
				list[i]=temp;
			}
			i++;
		}
		slider++;
		int temp = list[slider];
		list[slider]=list[i];
		list[i]=temp;

		return slider;
	}

	
	/**
	 * No sorting of pivot 
	 * traverse from both ends; switches when element greater than 
	 * pivot found in first half and smaller element than pivot found in later half.
	 * pivot is the first element in the list
	 * element at the returned index may not be the correct one to at; i.e., not sorted position.
	 * @param list
	 * @param start
	 * @param end
	 * @return partition index: the right pointer that seperates the smaller and greater divisions
	 */
	private int partition_with_2pointer(int list[], int start, int end){
		int pivot = list[start];
		int i=start,j=end;
		while(true){
			while(list[i] < pivot){
				i++;
			}
			while(list[j]> pivot){
				j--;
			}
			if(i >= j){
				//inherantly breaks the loop
				return j;
			}
			int temp=list[i];
			list[i]= list[j];
			list[j]=temp;
		}		
	}



	// in-place sorting; no need of auxillary space. Order is not maintained, not stable. 
	//Runtime: average and best case is nlogn where as worst case is n^2
	//Choose the pivot; usually, highest,start, mid or end index
	//Divide the list into two in such way that one half is all elements smaller tha pivot whereas the other half is greater or equal.
	//Swap the pivot with the large half first index in sliding techinque where just smaller set is tracked.
	public void quick_sort(int list[],int start, int end) {
		if(end <= start){
			return;
		}
		int pivot = partition_with_sliding(list,start,end);
		quick_sort(list, start, pivot-1);
		quick_sort(list, pivot+1, end);		
	}

	public void quick_sort_2pointer(int list[], int start, int end){
		if(start >= end){
			return;          
		}

		int pivot =partition_with_2pointer(list, start, end);
		quick_sort_2pointer(list, start, pivot);
		quick_sort_2pointer(list, pivot+1, end);
	}

	// test
	public static void main(String args[]) {
		Sort sort = new Sort();

		int[] list = { 3, 2, 1, 5 };
		// sort.bubble(list);
		// sort.selection(list);
		// sort.insertion(list);
		//sort.merge_sort(list, 0, 3);
		//sort.quick_sort(list, 0, 3);
		sort.quick_sort_2pointer(list, 0, 3);
		for (int num : list) {
			System.out.print(num + ", ");
		}
	}
}
