package binarysearch;

public class PealElement2 {
    public int[] findPeakGrid(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int low=0;
        int high=m-1;

        while(low<=high){

            int max=0;
            int mid=low+(high-low)/2;
            for(int i=0;i<m;i++){
                if(mat[max][mid]<mat[i][mid]){
                    max=i;
                }}
                if(mid==0|| mat[max][mid-1]<mat[max][mid] && mid==m-1 || mat[max][mid]>mat[max][mid+1]){
                    return new int[]{mid,max};
                }
                else if(mat[max][mid-1]>mat[max][mid]){
                    high=mid-1;
                }
                else {
                    low = mid + 1;
                }
        }
        return new int[]{-1,-1};

    }
    public  static void main(String args[]){
        int mat[][]={{1,4},{3,2}};
        PealElement2 pealElement2=new PealElement2();
        pealElement2.findPeakGrid(mat);
    }
}
