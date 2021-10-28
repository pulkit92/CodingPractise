package com.socialnetwork;

import java.util.Date;
import java.util.List;

public class Post {
  private long id;
  private String text;
  private String user;
  private long upvote;
  private long downvote;
  private Date date;
  private List<Comment> comments;

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public long getUpvote() {
    return upvote;
  }

  public void setUpvote(long upvote) {
    this.upvote = upvote;
  }

  public long getDownvote() {
    return downvote;
  }

  public void setDownvote(long downvote) {
    this.downvote = downvote;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }


}
