package slidingwindow;



/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:
Input: [A, B, C]
       [A, C, D]
      word: CD -> true
      word: ABCAD -> false
      word: ABA -> false

      [ A B C]
      [ X Y  Z]
      [ M N  p]
      {p Q  R}

c  i=0 j=2
matri

   boolean ans= findNextMatch(c,s,i-1,j,row,col,x+1) | findNextMatch(c,s,i+1,j,row,col,x+1)|
    findNextMatch(c,s,i,j-1,row,col,x+1)|
        findNextMatch(c,s,i,j+1,row,col,x+1);
i=0<
j=0
 */

class MinimumWindowSubstring76 {
  public static void main(String[] args) {
    MinimumWindowSubstring76 sol= new MinimumWindowSubstring76();
    char c[][]={{'A','B','C'},{'A', 'C', 'D'}};
    System.out.println(sol.checkWordExists(c, "CD"));
  }

  public boolean checkWordExists(char c[][],String s){

    int row= c.length;
    int col=c[0].length;

    for(int i=0;i<row;i++){
      for(int j=0;j<col;j++){
        if(c[i][j]==s.charAt(0)){
          if(findNextMatch(c,s,i,j,row,col,0))
            return true;
        }

      }

    }
    return false;
  }
  public boolean findNextMatch(char c[][],String s,int i,int j,int row,int col,int x){
    int len=s.length();

    if(len==x)
    {
      return true;
    }

    if(i<0 || j<0|| i>=row||j>=col){
      return false;

    }
    if(c[i][j]== s.charAt(x)){

      char dummy=c[i][j];

      c[i][j]='#';


      if(findNextMatch(c,s,i-1,j,row,col,x+1)){
        c[i][j]=dummy;
        return true;
      }
      if(findNextMatch(c,s,i+1,j,row,col,x+1)){
        c[i][j]=dummy;
        return true;
      }

      if( findNextMatch(c,s,i,j-1,row,col,x+1)){
        c[i][j]=dummy;
        return true;
      }
      if( findNextMatch(c,s,i,j+1,row,col,x+1)){
        c[i][j]=dummy;
        return true;
      }

    }
    return false;

  }


}
