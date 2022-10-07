package leetcode.treeMap;

import java.util.TreeMap;

/*
* 732. My Calendar III
* problem url: https://leetcode.com/problems/my-calendar-iii/
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
	
    Map<Integer, Integer> map;
    int max;

    public static MyCalendar() {
        max = 0;
        map = new TreeMap<>();
    }
    
    public static int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        
        int curMax = 0;
        for(int d : map.values()){
            curMax += d;
            max = Math.max(max, curMax);
        }

        return max;
    }
}