package leetcode.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
* 973. K Closest Points to Origin
* problem url: https://leetcode.com/problems/k-closest-points-to-origin/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class KthClosestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(kClosest(new int[][] {{3, 3}, {5,-1} , {-2, 4}}, 2));
		System.out.println(kClosestAttemp2(new int[][] {{3, 3}, {5,-1} , {-2, 4}}, 2));
	}
	
	public static int[][] kClosest(int[][] points, int K) {
        int pLength = points.length;
        int[] dists = new int[pLength];
        for(int i = 0; i < pLength; i++){
            dists[i] = calcDist(points[i]);
        }
        Arrays.sort(dists);
        int distK = dists[K-1];
        
        int[][] res = new int[K][2];
        int index = 0;
        for(int i = 0; i < pLength; i++){
            if(calcDist(points[i]) <= distK){
                res[index] = points[i];
                index++;
            }
        }
        
        return res;
    }
    
    private static int calcDist(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
    
    public static int[][] kClosestAttemp2(int[][] points, int K) {
        HashMap<Integer, List<int[]>> hMap = new HashMap<>();
        List<Integer> values = new ArrayList<>();
        
        for(int[] point : points){
            int distance = calcDist(point);
            values.add(distance);
            
            if(!hMap.containsKey(distance)){
                List<int[]> lists = new ArrayList<int[]>();
                lists.add(point);
                hMap.put(distance, lists);
                continue;
            }
            
            hMap.get(distance).add(point);
        }
        
        Integer d = kthElement(values, 0, values.size() - 1, K-1);
        List<int[]> resultList = hMap.get(d);
        
        int[][] resultArr = new int[resultList.size()][];
        for(int i = 0; i < resultList.size(); i++){
            resultArr[i] = resultList.get(i);
        }
        
        return resultArr;
    }
    
    private static int kthElement(List<Integer> arr, int low, int high, int k){
        int partition = getPartition(arr, low, high);
        if(partition == k) return arr.get(partition);
        else if(partition < k ){
           return kthElement(arr, partition + 1, high, k); 
        }
        else{
            return  kthElement(arr, low, partition - 1, k);
        }   
    }
    
    private static int getPartition(List<Integer> arr, int low, int high){
        int pivot = arr.get(high); 
        int pivotloc = low; 
        for (int i = low; i <= high; i++) 
        {  
            if(arr.get(i) < pivot) 
            { 
                int temp = arr.get(i); 
                arr.set(i, arr.get(pivotloc)); 
                arr.set(pivotloc, temp); 
                pivotloc++; 
            } 
        } 
           
        int temp = arr.get(high); 
        arr.set(high, arr.get(pivotloc)); 
        arr.set(pivotloc,  temp); 
          
        return pivotloc; 
    }
}
