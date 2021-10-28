
class GFGBooleanSortedMatrix {
     
    static final int N = 4;
 
    // function for finding row with maximum 1
    static void findMax(int arr[][]) {
         
        int row = 0, i, j;
 j=N-1;
 int max=0;
        for (i = 0; i < N; i++) {
             int count=0;
            // find left most position of 1 in
            // a row find 1st zero in a row
            while (j>=0 &&arr[i][j] == 1) {
                 row=i;
                j--;
            }
            
        }
         
        System.out.print("Row number = "
                                + (row + 1));
        System.out.print(", MaxCount = "
                               + (N-j-1));
    }
     
    // Driver code
    public static void main(String[] args) {
        int arr[][] = {{0, 0, 0, 0}, 
                       {0, 0, 0, 0}, 
                       {0, 0, 0, 0}, 
                       {0, 0, 0, 0}};
        findMax(arr);
    }
}