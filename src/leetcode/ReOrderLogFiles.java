package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
* Find Pivot Index
* problem url: https://leetcode.com/problems/reorder-data-in-log-files/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class ReOrderLogFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(String log : reorderLogFiles1(new String[] {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"}))
			System.out.println(log);
	}
	public static String[] reorderLogFiles1(String[] logs) {
        PriorityQueue<String> heap = new PriorityQueue<String>(new Comparator<String>(){
            public int compare(String s1, String s2){
                String firstElementofLog1 = s1.split(" ")[1];
                String firstElementofLog2 = s2.split(" ")[1];
                try{
                    //both of the items are number
                    int item1 = Integer.parseInt(firstElementofLog1);
                    int item2 = Integer.parseInt(firstElementofLog2);
                    return item2 - item1;
                }
                catch(Exception e){
                    try{
                       //item1 is number only 
                       int item1 = Integer.parseInt(firstElementofLog1); 
                       return 1;
                    }
                    catch(Exception e1){
                        try{
                           //item2 is number only
                           int item2 = Integer.parseInt(firstElementofLog2);
                           return -1;  
                        }
                        catch(Exception e2){
                            //both logs are string
                            return firstElementofLog1.compareTo(firstElementofLog2);
                        }
                    }
                }
            }
        });
        
        
        for(int i = 0; i < logs.length; i++ ){
            heap.offer(logs[i]);
        }
        
        for(int i = 0; i < logs.length; i++)
        {
            logs[i] = heap.poll();
        }
        
        return logs;
    }
	
	
	public static String[] reorderLogFiles(String[] logs) {
        ArrayList<String> stringLogs = new ArrayList<String>();
        ArrayList<String> integerLogs = new ArrayList<String>();
        
        for(int i = 0; i < logs.length; i++ ){
            String log = logs[i];
            String firstElementofLog = log.split(" ")[1];
            try{
                Integer.parseInt(firstElementofLog);    
                integerLogs.add(log);
            }
            catch(Exception e){
                stringLogs.add(log);
            }
        }
        stringLogs.addAll(integerLogs);
        return stringLogs.parallelStream().toArray(String[]::new);
    }
}
