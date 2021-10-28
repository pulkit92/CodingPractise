package com.socialnetwork;

public class SocialNetworkLauncher {
  public static void main(String args[]) {
    SocialNetwork socialNetwork = new SocialNetwork();
    socialNetwork.signup("lucious");
    socialNetwork.signup("tom");
    socialNetwork.signup("pulkit");

    socialNetwork.login("tom");
    socialNetwork.post("i am tom", "tom");
    try {
      Thread.sleep(1000);
    }
    catch (Exception e){

    }
    socialNetwork.login("pulkit");
    socialNetwork.post("i am pulkit", "pulkit");
    try {
      Thread.sleep(1000);
    }
    catch (Exception e){

    }

    socialNetwork.login("lucious");
    socialNetwork.post("I am going to be the darkest dark wizard of all time", "lucious");
    try {
      Thread.sleep(1000);
    }
    catch (Exception e){

    }
    socialNetwork.post("hello ", "lucious");
    try {
      Thread.sleep(1000);
    }
    catch (Exception e){

    }
    
    socialNetwork.follow("tom", "lucious");
    socialNetwork.follow("pulkit", "lucious");
    socialNetwork.follow("pulkit", "tom");

    for (Post post : socialNetwork.showNewsFeed("tom")) {
      System.out.println(post.getComments());
      System.out.println(post.getText());
      System.out.println(post.getUser());
      System.out.println(post.getId());
      System.out.println(post.getDate());

      System.out.println();
    }

  }
}
