package leetcode;

import java.util.ArrayList;

/*
* Find Pivot Index
* problem url: https://leetcode.com/problems/reorder-data-in-log-files/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class ReOrderLogFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(String log : reorderLogFiles(new String[] {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"}))
			System.out.println(log);
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
