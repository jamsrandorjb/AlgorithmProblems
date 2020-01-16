package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/*
* 380. Insert Delete GetRandom O(1)
* problem url: https://leetcode.com/problems/insert-delete-getrandom-o1/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class RandomizedSet {
	
	HashSet<Integer> hSet;
    ArrayList<Integer> arrayList;
    Random rn;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        hSet = new HashSet<Integer>();
        arrayList = new ArrayList<Integer>();
        rn = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(hSet.contains(val)) return false;
        hSet.add(val);
        arrayList.add(val);
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!hSet.contains(val)) return false;
        hSet.remove(val);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        while(true){
          int randomIndex =  rn.nextInt(arrayList.size());  
          if(hSet.contains(arrayList.get(randomIndex))){
            return arrayList.get(randomIndex);    
          }
        } 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomizedSet obj = new RandomizedSet();
		System.out.println(obj.insert(5));
		System.out.println(obj.insert(5));
		System.out.println(obj.insert(3));
		System.out.println(obj.remove(5));
		System.out.println(obj.remove(10));
		System.out.println(obj.getRandom());
	}
}