class Twitter {
    private int tweetCount = 0;

    private Map<Integer, PriorityQueue<Tweet>> feeds = new HashMap<>();

    private Map<Integer, Set<Integer>> followers = new HashMap();

    private Map<Integer, Set<Integer>> followed = new HashMap();

    private Map<Integer, List<Tweet>> tweets = new HashMap();

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!feeds.containsKey(userId)) {
            createFeed(userId);
        }
        if (!followers.containsKey(userId)) {
            createFollowers(userId);
        }
        
        Tweet tweet = new Tweet(userId, tweetId, tweetCount++);
        List<Tweet> userTweets = tweets.getOrDefault(userId, new ArrayList<>());
        userTweets.add(tweet);
        tweets.put(userId, userTweets);

        Set<Integer> follows = followers.get(userId);
        for (int user : follows) {
            var feed = feeds.get(user);
            feed.add(tweet);

            // Only keep the 10 most recent tweets;
            while (feed.size() > 10) {
                feed.poll();
            }
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        var feed = feeds.get(userId);

        List<Integer> result = new ArrayList<>();
        return feed.stream()
                   .sorted((t1, t2) -> Integer.compare(t2.tweetNumber, t1.tweetNumber))
                   .map(tweet -> tweet.tweetId)
                   .toList();
    }
    
    public void follow(int followerId, int followeeId) {
        if (!followers.containsKey(followeeId)) {
            createFollowers(followeeId);
        }
        
        if (!followed.containsKey(followerId)) {
            createFollowedList(followerId);
        }
        if (followed.get(followerId).contains(followeeId)) {
            // Already follows the person
            return;
        }

        // Save followed
        followed.get(followerId).add(followeeId);
        // Save follow
        followers.get(followeeId).add(followerId);


        if (!tweets.containsKey(followeeId)) {
            tweets.put(followeeId, new ArrayList<>());
        }

        if (!feeds.containsKey(followerId)) {
            createFeed(followerId);
        }

        // Update feed
        List<Tweet> followeeTweets = tweets.get(followeeId);
        var feed = feeds.get(followerId);
        for (Tweet tweet : followeeTweets) {
            feed.add(tweet);

            // Only keep the 10 most recent tweets;
            while (feed.size() > 10) {
                feed.poll();
            }
        }

       
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            // Can't unfollow yourself
            return;
        }
        if (!followed.get(followerId).contains(followeeId)) {
            // Not following, skip
            return;
        }

        // Unfollow
        followers.get(followeeId).remove(followerId);
        followed.get(followerId).remove(followeeId);

        // Recalculate feed
        // 1. Empty Feed
        createFeed(followerId);
        var feed = feeds.get(followerId);
        // 2. Get all followed people
        Set<Integer> followedUsers = followed.get(followerId);
        for (int userId : followedUsers) {
            // 3. Refill feed with followedUsers' tweets
            List<Tweet> followedTweets = tweets.getOrDefault(userId, List.of());

            if (followedTweets.isEmpty()) {
                System.out.println("Empty tweet list for UserId " + userId);
            }
            
            for (Tweet tweet : followedTweets) {
                feed.add(tweet);
                // Only keep the 10 most recent tweets;
                while (feed.size() > 10) {
                    feed.poll();
                }
            }
        }
    }

    private void createFeed(int userId) {
        PriorityQueue<Tweet> heap = new PriorityQueue<>((t1, t2) -> Integer.compare(t1.tweetNumber, t2.tweetNumber));
        feeds.put(userId, heap);
    }

    private void createFollowers(int userId) {
        Set<Integer> followersSet = new HashSet<>();
        followersSet.add(userId);
        followers.put(userId, followersSet);
    }

    private void createFollowedList(int userId) {
        Set<Integer> followedSet = new HashSet<>();
        followedSet.add(userId);
        followed.put(userId, followedSet);
    }

    static class Tweet {
        public int userId;
        public int tweetId;
        public int tweetNumber;

        public Tweet(int userId, int tweetId, int tweetNumber) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.tweetNumber = tweetNumber;
        }
    }
}
