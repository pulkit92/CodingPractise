package bfsAndDfsArray;

public class FloodFill {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    if (image == null || image.length == 0) {
      return null;
    }
    Integer[][] newArray = new Integer[image.length][image[0].length];
    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[0].length; j++) {
        newArray[i][j] = image[i][j];
      }
    }
    filling(newArray, sr, sc, newColor, image[sr][sc]);
    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[0].length; j++) {
        image[i][j] = newArray[i][j];
      }
    }
    return image;
  }

  public void filling(Integer[][] image, int sr, int sc, int newColor, int oldColor) {
    if (sr >= 0 && sc >= 0 && sr < image.length && sc < image[0].length) {
      if (image[sr][sc] != null && image[sr][sc] == oldColor) {
        image[sr][sc] = null;
        filling(image, sr + 1, sc, newColor, oldColor);
        filling(image, sr - 1, sc, newColor, oldColor);
        filling(image, sr, sc + 1, newColor, oldColor);
        filling(image, sr, sc - 1, newColor, oldColor);
        image[sr][sc] = newColor;

      }
    }
  }

  public static void main(String args[]) {
    int x[][] = {{0, 0, 0}, {0, 1, 1}};
    FloodFill floodFill = new FloodFill();
    floodFill.floodFill(x, 1, 1, 1);
  }
}
