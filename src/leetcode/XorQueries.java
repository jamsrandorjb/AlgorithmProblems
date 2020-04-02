package leetcode;

/*
 * 5304. XOR Queries of a Subarray
 * problem url: https://leetcode.com/problems/xor-queries-of-a-subarray/
 * leetcode profile url: https://leetcode.com/jamsrandorj/ 
 * solved by jama
 */
public class XorQueries {
	public static void main(String[] args) {
		System.out.println(xorQueries(new int[] {1,3,4,8}, new int[][] {{0,1},{1,2},{0,3},{3,3}} ));
	}

	public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int[] query = queries[i];
            int xorCalculated = arr[query[0]] ^ arr[query[1]];
            if(query[0] == query[1]) xorCalculated = arr[query[0]];
            
            for(int j = query[0]+1; j <= query[1]-1; j++){
                xorCalculated = xorCalculated ^ arr[j];
            }
            
            result[i] = xorCalculated;
        }
        
        return result;
    }
}