package interviewQA;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
* Microsoft | OA 2019 | Meeting Rooms II
* problem url: https://leetcode.com/problems/meeting-rooms-ii/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
*/

public class Microsoft_MeetingRooms2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minMeetingRooms(new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } }));
		System.out.println(minMeetingRooms(new int[][] { { 7, 10 }, { 2, 4 } }));
	}

	private static int minMeetingRooms(int[][] meetings) {
		Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		minHeap.offer(meetings[0]);
		for (int i = 1; i < meetings.length; i++) {
			int[] current = meetings[i];
			int[] earliest = minHeap.poll();
			if (current[0] >= earliest[1]) {
				earliest[1] = current[1];
			} else {
				minHeap.offer(current);
			}
			minHeap.offer(earliest);
		}

		return minHeap.size();
	}
}
