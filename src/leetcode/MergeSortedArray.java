package leetcode;

/*
* Merge Two Sorted Array
* problem url: https://leetcode.com/problems/merge-sorted-array/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class MergeSortedArray {
	public static void main(String[] args) {
		int[] array1 = new int[] {1,2,3,0,0,0};
		int[] array2 = new int[] {2,5,6};
		merge(array1, 3, array2, 3);
		for(int i = 0; i < array1.length; i++) {
			System.out.println(array1[i]);
		}
	}
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] tempMergeList = new int[nums1.length];
		int counterMergeList = 0;
		int counter1 = 0;
		int counter2 = 0;
        
        for(; counter1 < m && counter2 < n; ){
            if(nums1[counter1] > nums2[counter2]){
            	tempMergeList[counterMergeList] = nums2[counter2];
                counter2++;
            }
            else
            {
            	tempMergeList[counterMergeList] = nums1[counter1];
                counter1++;
            }
            counterMergeList++;
        }
        
        while(counter1 < m){
        	tempMergeList[counterMergeList] = nums1[counter1];
            counter1++;
            counterMergeList++;
        }
        
        while(counter2 < n){
        	tempMergeList[counterMergeList] = nums2[counter2];
            counter2++;
            counterMergeList++;
        }
        
        for(int i = 0; i < tempMergeList.length; i++){
            nums1[i] = tempMergeList[i];
        }
    }
}