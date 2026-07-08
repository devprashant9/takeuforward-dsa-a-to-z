import java.util.*;

class Twitter {

    private List<int[]> tweets;
    private Set<Integer>[] users;
    private int time;

    public Twitter() {
        users = new HashSet[501];
        for (int i = 0; i < 501; i++)
            users[i] = new HashSet<>();

        tweets = new ArrayList<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweets.add(new int[] { userId, tweetId, time++ });
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();

        for (int i = tweets.size() - 1; i >= 0 && ans.size() < 10; i--) {
            int[] tweet = tweets.get(i);

            int author = tweet[0];
            int tweetId = tweet[1];

            if (author == userId || users[userId].contains(author)) {
                ans.add(tweetId);
            }
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId)
            users[followerId].add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        users[followerId].remove(followeeId);
    }
}