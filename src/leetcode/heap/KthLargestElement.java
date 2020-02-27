package leetcode.heap;

/*
* 215. Kth Largest Element in an Array
* problem url: https://leetcode.com/problems/kth-largest-element-in-an-array/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class KthLargestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findKthLargest(new int[] {1, 2, 4, 6, 3, 3}, 1));
	}
	
	public static int findKthLargest(int[] nums, int k) {
        return kthElement(nums, 0, nums.length-1, nums.length - k);    
    }
    
    private static int kthElement(int[] arr, int low, int high, int k){
        int partition = getPartition(arr, low, high);
        
        if(partition == k) return arr[partition];
        else if(partition < k ) return kthElement(arr, partition + 1, high, k); 
        else return  kthElement(arr, low, partition - 1, k);
    }
    
    private static int getPartition(int[] arr, int low, int high){
        int pivot = arr[high]; 
        int pivotloc = low; 
        for (int i = low; i <= high; i++) 
        {  
            if(arr[i] < pivot) 
            { 
                int temp = arr[i]; 
                arr[i] =  arr[pivotloc]; 
                arr[pivotloc] = temp; 
                pivotloc++; 
            } 
        } 
           
        int temp = arr[high]; 
        arr[high] = arr[pivotloc]; 
        arr[pivotloc] =  temp; 
          
        return pivotloc; 
    }
}
