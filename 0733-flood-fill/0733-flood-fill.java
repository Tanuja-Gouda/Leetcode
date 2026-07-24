class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor=image[sr][sc];
        int m=image.length;
        int n=image[0].length;

        if (initialColor == color)
            return image;

        dfs(sr,sc,initialColor,color,image);

        return image;
    }

    private void dfs(int r,int c,int initialColor, int color,int[][] image){
        if(c<0 || r<0 || r>image.length-1 || c>image[0].length-1 || image[r][c] != initialColor){
            return;
        }

        image[r][c]=color;

        dfs(r,c-1,initialColor,color,image);
        dfs(r+1,c,initialColor,color,image);
        dfs(r,c+1,initialColor,color,image);
        dfs(r-1,c,initialColor,color,image);

        return;
    }


}