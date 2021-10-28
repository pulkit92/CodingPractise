package com.socialnetwork;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;


public class SocialNetwork {
  Set<String> userList = new HashSet<String>();
  HashMap<String, Set<String>> userFollowing;
  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
  AtomicLong noOfPosts = new AtomicLong(0);
  Set<Post> posts;

  public SocialNetwork() {
    userFollowing = new HashMap<String, Set<String>>();
    posts = new TreeSet<Post>(new PostComparator());

  }

  public String signup(String name) {
    if (userList.contains("name")) {
      return "user already added";
    } else {
      userList.add(name);
      return "user creation success";

    }
  }

  public List<Post> login(String userName) {
    if (!userList.contains("name")) {
      return null;
    }
    userList.add(userName);
    return showNewsFeed(userName);


  }

  public List<Post> showNewsFeed(String userName) {
    if (!userList.contains(userName)) {
      return null;
    }
    Set<String> followers = userFollowing.get(userName);
    List<Post> feed = new ArrayList<Post>();
    Set<Post> remfeed = new HashSet<Post>();
    if (followers!=null && followers.size() > 0) {
      for (Post post : posts) {
        if (followers.contains(post.getUser())) {
          feed.add(post);
          remfeed.add(post);

        }
      }

      for (Post post : posts) {
        if (!remfeed.contains(post)) {
          feed.add(post);

        }
      }
      return feed;

    }
    List<Post> withoutfollowerfeed = new ArrayList<Post>();
    for (Post post : posts) {
      withoutfollowerfeed.add(post);
    }

    return withoutfollowerfeed;

  }

  public String post(String feed, String userName) {
    Post newPost = new Post();
    Date date = new Date();
    newPost.setDate(date);
    newPost.setUpvote(0);
    newPost.setDownvote(0);
    newPost.setUser(userName);
    newPost.setText(feed);
    newPost.setComments(new ArrayList<Comment>());
    newPost.setId(noOfPosts.incrementAndGet());
    posts.add(newPost);
    return "sucess";
  }

  public String follow(String userName, String following) {

    if (userFollowing.containsKey(following)) {
      Set<String> foloower = userFollowing.get(following);
      foloower.add(userName);
      userFollowing.put(following, foloower);
    } else {
      Set<String> foloower = new HashSet<String>();
      foloower.add(userName);
      userFollowing.put(following, foloower);

    }
    return "succes";
  }
}
