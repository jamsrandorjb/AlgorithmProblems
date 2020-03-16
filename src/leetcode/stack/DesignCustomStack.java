package leetcode.stack;

import java.util.LinkedList;
import java.util.List;

/*
* 1381. Design a Stack With Increment Operation
* problem url: https://leetcode.com/problems/design-a-stack-with-increment-operation/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class DesignCustomStack {
	public static void main(String[] args) {
		DesignCustomStack stack = new DesignCustomStack(3);
		stack.push(1);
		System.out.println(stack.pop());
		stack.increment(1, 100);
	}

	List<Integer> customStack;
	int size;

	public DesignCustomStack(int maxSize) {
		this.size = maxSize;
		this.customStack = new LinkedList<>();
	}

	public void push(int x) {
		if (customStack.size() >= size)
			return;
		customStack.add(x);
	}

	public int pop() {
		if (customStack.isEmpty())
			return -1;
		return customStack.remove(customStack.size() - 1);
	}

	public void increment(int k, int val) {
		for (int i = 0; i < Math.min(customStack.size(), k); i++) {
			customStack.set(i, val + customStack.get(i));
		}
	}
}