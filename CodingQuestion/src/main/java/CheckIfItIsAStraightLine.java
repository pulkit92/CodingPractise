public class CheckIfItIsAStraightLine {
  public boolean checkStraightLine(int[][] coordinates) {
    if (coordinates.length <= 2) {
      return true;
    }
    float intialSlope = findSlope(coordinates[0][0], coordinates[0][1], coordinates[1][0], coordinates[1][1]);
    for (int i = 1; i < coordinates.length - 1; i++) {
      float slope = findSlope(coordinates[i][0], coordinates[i][1], coordinates[i + 1][0], coordinates[i + 1][1]);
      if (intialSlope != slope) {
        return false;
      }
    }
    return true;
  }

  private float findSlope(int x1, int y1, int x2, int y2) {
    if (x1 - x2 == 0) {
      return 0;
    }
    return (float) (y2 - y1) / (x2 - x1);

  }

  public static void main(String args[]) {
    CheckIfItIsAStraightLine checkIfItIsAStraightLine = new CheckIfItIsAStraightLine();
    int a[][] = {{-4, -3}, {1, 0}, {3, -1}, {0, -1}, {-5, 2}};
    System.out.println(checkIfItIsAStraightLine.checkStraightLine(a));
  }
}
