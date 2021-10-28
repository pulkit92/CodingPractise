package com.socialnetwork;

import java.util.Comparator;

public class PostComparator implements Comparator<Post> {
  public int compare(Post o1, Post o2) {
    long score1 = o1.getUpvote() - o1.getDownvote();
    long score2 = o2.getUpvote() - o2.getDownvote();
    if (score1 == score2) {
      if (o1.getComments().size() == o2.getComments().size()) {
        if (o1.getDate().before(o2.getDate())) {
          return 1;
        } else {
          return -1;
        }
      }
      return o1.getComments().size() > o2.getComments().size() ? 1 : -1;
    } else if (score1 > score2) {
      return 1;
    }
    return -1;
  }
}
