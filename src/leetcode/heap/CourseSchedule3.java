package leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
* 630. Course Schedule III
* problem url: https://leetcode.com/problems/course-schedule-iii/
* leetcode profile url: https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class CourseSchedule3 {
	public static void main(String[] args) {

		System.out.println(scheduleCourse(new int[][] { { 1, 0 }, { 2, 1 }, { 2, 3 }, { 3, 2 } }));
		System.out.println(scheduleCourse(new int[][] { { 1, 0 } }));
		System.out.println(scheduleCourse(new int[][] { { 1, 0 }, { 0, 1 } }));
		System.out.println(scheduleCourse(new int[][] { { 100, 200 }, { 200, 1300 }, { 1000, 1250 }, { 2000, 3200 } }));

	}

	public static int scheduleCourse(int[][] courses) {
		Arrays.sort(courses, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
		PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> (b - a));
		int time = 0;
		for (int[] course : courses) {
			time += course[0];
			heap.offer(course[0]);
			if (time > course[1]) {
				time -= heap.poll();
			}
		}

		return heap.size();
	}
}