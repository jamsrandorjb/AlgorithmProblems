package leetcode.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/*
* 355. Design Twitter
* problem url: https://leetcode.com/problems/design-twitter/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class Twitter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Twitter obj = new Twitter();
		obj.postTweet(1, 5);
		List<Integer> param_2 = obj.getNewsFeed(1);
		System.out.println(param_2);
		obj.follow(1, 3);
		obj.unfollow(1, 2);
	}

	/**
	 * Your Twitter object will be instantiated and called as such: Twitter obj =
	 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
	 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
	 * obj.unfollow(followerId,followeeId);
	 */

	// Custom Tweet class with comparable function
	// we will use it for the Heap
	static class Tweet implements Comparable<Tweet> {
		int tweetId;
		int postTimeStamp;

		public Tweet(int tweetId, int postTimeStamp) {
			this.tweetId = tweetId;
			this.postTimeStamp = postTimeStamp;
		}

		public int getPostTimeStamp() {
			return postTimeStamp;
		}

		@Override
		public int compareTo(Tweet other) {
			return postTimeStamp - other.getPostTimeStamp();
		}
	}

	HashMap<Integer, Set<Integer>> users;
	HashMap<Integer, PriorityQueue<Tweet>> tweets;
	private int postCnt;
	private int recentQuantity;

	/** Initialize your data structure here. */
	public Twitter() {
		users = new HashMap<>();
		tweets = new HashMap<>();
		postCnt = 0;
		recentQuantity = 10;
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		PriorityQueue<Tweet> tweetsPriorityQueue = tweets.get(userId);
		if (tweetsPriorityQueue == null) {
			tweetsPriorityQueue = new PriorityQueue<>();
			tweetsPriorityQueue.add(new Tweet(tweetId, ++postCnt));
			tweets.put(userId, tweetsPriorityQueue);
			return;
		}

		tweetsPriorityQueue.add(new Tweet(tweetId, ++postCnt));
		if (tweetsPriorityQueue.size() > recentQuantity) {
			tweetsPriorityQueue.poll();
		}
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
	 * the news feed must be posted by users who the user followed or by the user
	 * herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		// getting the followers and the user itself
		Set<Integer> followers = users.get(userId);

		// if the user doesn't have any followers we will return his own tweets
		if (followers == null)
			followers = new HashSet<>();
		followers.add(userId);

		PriorityQueue<Tweet> lastTenTweets = new PriorityQueue<>();

		for (int userID : followers) {
			PriorityQueue<Tweet> tweetsPriorityQueue = tweets.get(userID);
			if (tweetsPriorityQueue == null)
				continue;
			for (Tweet tweet : tweetsPriorityQueue) {
				lastTenTweets.add(tweet);
				if (lastTenTweets.size() > recentQuantity)
					lastTenTweets.poll();
			}
		}

		List<Integer> retList = new ArrayList<>(recentQuantity);
		while (!lastTenTweets.isEmpty()) {
			retList.add(lastTenTweets.poll().tweetId);
		}

		Collections.reverse(retList);

		return retList;
	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		if (users.containsKey(followerId)) {
			if (!users.get(followerId).contains(followeeId))
				users.get(followerId).add(followeeId);

			return;
		}

		HashSet<Integer> hSet = new HashSet<>();
		hSet.add(followeeId);
		users.put(followerId, hSet);
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		if (!users.containsKey(followerId))
			return;
		if (!users.get(followerId).contains(followeeId))
			return;
		users.get(followerId).remove(followeeId);
	}
}
