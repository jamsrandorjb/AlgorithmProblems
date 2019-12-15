package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
* 937. Reorder Data in Log Files
* problem url: https://leetcode.com/problems/reorder-data-in-log-files/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class ReOrderLogFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (String log : reorderLogFiles1(
				new String[] { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" }))
			System.out.println(log);
	}

	public static String[] reorderLogFiles1(String[] logs) {
		List<String> letterList = new LinkedList<>();
		List<String> digList = new LinkedList<>();

		PriorityQueue<String> heap = new PriorityQueue<String>(new Comparator<String>() {
			public int compare(String s1, String s2) {
				s1 = s1.substring(s1.indexOf(" ") + 1) + s1.substring(0, s1.indexOf(" "));
				s2 = s2.substring(s2.indexOf(" ") + 1) + s2.substring(0, s2.indexOf(" "));
				return s1.compareTo(s2);
			}
		});

		for (String log : logs) {
			// check digit log or string log
			if (Character.isDigit(log.charAt(log.indexOf(" ") + 1))) {
				digList.add(log);
				continue;
			}
			heap.offer(log);
		}

		while (!heap.isEmpty())
			letterList.add(heap.poll());

		letterList.addAll(digList);

		return letterList.toArray(new String[letterList.size()]);
	}

	public static String[] reorderLogFiles(String[] logs) {
		ArrayList<String> stringLogs = new ArrayList<String>();
		ArrayList<String> integerLogs = new ArrayList<String>();

		for (int i = 0; i < logs.length; i++) {
			String log = logs[i];
			String firstElementofLog = log.split(" ")[1];
			try {
				Integer.parseInt(firstElementofLog);
				integerLogs.add(log);
			} catch (Exception e) {
				stringLogs.add(log);
			}
		}
		stringLogs.addAll(integerLogs);
		return stringLogs.parallelStream().toArray(String[]::new);
	}
}
