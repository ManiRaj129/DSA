package Algorithms;

//sorting in ascending order
public class Sort
{
	
  //swapping adjacents as such in iteration one val is intended to sort that is the max in the array is pushed to the end 
  public void bubble(int[] list) {
	  for(int i=0;i<list.length;i++) {
		  for(int j=0;j<list.length-i-1;j++) {
			  if(list[j+1]<list[j]) {
				  int temp= list[j];
				  list[j]=list[j+1];
				  list[j+1]=temp;
			  }
		  }
	  }
  }
  // finds the max and swaps where swapping only once after finding the max as such n iterations happens
  public void selection(int list[]) {
	  for(int i=0;i<list.length;i++) {
		  int max_index=0;
		  for(int j=1;j<list.length-i;j++) {
			  if(list[max_index]<list[j]) {
				  max_index=j;
			  }
		  }
		  int temp=list[max_index];
		  list[max_index]=list[list.length-i-1];
		  list[list.length-i-1]=temp;		  
	  }
  }
  
  //the given array assumed to have sorted and unsorted regions;
  //where intially only the first element is considered to be in the sorted region.
  //in each iteration one element from unsorted region is inserted in sorted region at approprate index
  //by shifting the items until we find the small item than the "item that we tend to sort"
  public void insertion(int list[]) {
	for(int i=1;i<list.length;i++) {
		int k=i-1;
		int curr=list[i];
		while(k>=0 && curr<list[k]) {
			list[k+1]=list[k];
			k--;
		}
		list[k+1]=curr;
	}
  }
  
  public void merge() {
	  
  }
  
  public void quick() {
	  
  }
  
  
  
 //test
  public static void main(String args[]) {
	  Sort sort=new Sort();
	  
	  int[] list= {3,2,1,5};
	  //sort.bubble(list);
	  //sort.selection(list);
	  sort.insertion(list);
	  for(int num: list) {
		  System.out.print(num+", ");
	  }
  }
}
