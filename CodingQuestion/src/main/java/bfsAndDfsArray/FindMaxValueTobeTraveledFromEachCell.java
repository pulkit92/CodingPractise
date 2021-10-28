package bfsAndDfsArray;

public class FindMaxValueTobeTraveledFromEachCell {
    int max=Integer.MIN_VALUE;
    public int findMaxValue(int [][]grid){

        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    find(grid,i,j,0);
                }
            }
        }
        return max;

    }
    private void find(int [][]grid,int i,int j,int sum){
        if(i>=0 && i<=grid.length-1&& j>=0 && j<=grid[0].length-1 && grid[i][j]!=0){
            int sum1=grid[i][j]+sum;
            int temp= grid[i][j];
            grid[i][j]=0;
            find( grid, i+1, j, sum1);
            find( grid, i, j+1, sum1);
            find( grid, i-1, j, sum1);
            find( grid, i, j-1, sum1);
            grid[i][j]=temp;
        }
        else {
            max=Math.max(max,sum);
        }
    }
    public static void main(String args[]){
        int grid[][]={{1,1,1,5,0},{1,1,0,1,0},{1,1,0,6,0},{0,0,0,1,0}};


        FindMaxValueTobeTraveledFromEachCell findMaxValueTobeTraveledFromEachCell=new FindMaxValueTobeTraveledFromEachCell();
        System.out.println(findMaxValueTobeTraveledFromEachCell.findMaxValue(grid));
    }
}
