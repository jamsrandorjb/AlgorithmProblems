package leetcode.treeMap;

import java.util.TreeMap;

/*
* 729. My Calendar I
* problem url: https://leetcode.com/problems/my-calendar-i/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class MyCalendar1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCalendar cal = new MyCalendar();
        System.out.println(cal.book(5,10));
        System.out.println(cal.book(5,10));
        System.out.println(cal.book(10,15));
	}
	
	TreeMap<Integer, Integer> treeMap;

    public static MyCalendar() {
        treeMap = new TreeMap();
    }
    
    public static boolean book(int start, int end) {
        Integer next = treeMap.ceilingKey(start);
        Integer prev = treeMap.floorKey(start);
        
        if((prev == null || treeMap.get(prev) <= start) && (next == null || next >= end)){
            treeMap.put(start, end);
            return true;
        }  
        
        return false;
    }
}