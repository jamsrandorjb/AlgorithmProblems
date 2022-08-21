package leetcode.greedy;


/*
 * 936. Stamping The Sequence
 * problem url: https://leetcode.com/problems/stamping-the-sequence/
 * leetcode profile url: https://leetcode.com/jamsrandorj/
 * solved by jama
 */
public class StampingTheSequence {
	public static void main(String[] args) {
		System.out.println(movesToStamp("abc", "ababc"));
	}

	static class Node {
        Set<Integer> made, todo;
        Node(Set<Integer> m, Set<Integer> t) {
            made = m;
            todo = t;
        }
    }
    
    public static int[] movesToStamp(String stamp, String target) {
        int M = stamp.length();
        int N = target.length();
        Queue<Integer> queue = new ArrayDeque();
        boolean[] done = new boolean[N];
        Stack<Integer> ans = new Stack<>();
        List<Node> A = new ArrayList<>();
        
        for(int i = 0; i <= N-M; i++) {
            Set<Integer> made = new HashSet<>();
            Set<Integer> todo = new HashSet<>();
            for(int j = 0; j < M; j++) {
                if(target.charAt(i+j) == stamp.charAt(j))
                {
                    made.add(i+j);
                }
                else
                {
                    todo.add(i+j);
                }
            }
            
            A.add(new Node(made, todo));
            if(todo.isEmpty())
            {
                ans.push(i);
                for(int j = i; j < i + M; j++) {
                    if(!done[j])
                    {
                        queue.add(j);
                        done[j] = true;
                    }
                }
            }
        }
        
        while(!queue.isEmpty()) {
            int i = queue.poll();
            for(int j = Math.max(0, i - M + 1); j <= Math.min(N-M, i); j++) {
                if(A.get(j).todo.contains(i))
                {
                    A.get(j).todo.remove(i);
                    if(A.get(j).todo.isEmpty()){
                        ans.push(j);
                        for(int m : A.get(j).made) {
                            if(!done[m])
                            {
                                queue.add(m);
                                done[m] = true;
                            }
                        }
                    }
                }
            }
        }
        
        for(boolean b : done) {
            if(!b) return new int[0];
        }
        
        int[] res = new int[ans.size()];
        int i = 0;
        
        while(!ans.isEmpty())
        {
            res[i++] = ans.pop();
        }
        
        return res;
        
    }
}
