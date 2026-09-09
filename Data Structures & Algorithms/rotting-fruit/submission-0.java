class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rotten = new LinkedList<>();
        int row=grid.length;
        int col=grid[0].length;
        int freshFruit= 0; 
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    rotten.offer(new int []{i,j});
                }
                if(grid[i][j]==1){
                    freshFruit++;
                }
            }
        }
        
        int minutes=0;
        int [] []directions = {
        {-1,0}, //up
            {1,0},//down
            {0,-1},//left
            {0,1}//right
            };
        //BFS 
        while(!rotten.isEmpty()&&freshFruit>0){
            int size = rotten.size();
            for(int i = 0;i<size;i++ ){
                int [] element=rotten.poll();
                for(int[] direction:directions){
                int newrow=element[0]+direction[0];
                int newcol=element[1]+direction[1];
                if(newrow >= 0 && newrow < row && newcol >= 0&&newcol<col && grid[newrow][newcol]==1 ){
                    rotten.offer(new int[]{newrow,newcol});
                    freshFruit--;
                    grid[newrow][newcol]=2;
                }
            }
            }
            
            minutes++;
        }
        if(freshFruit>0)return -1;
        
        return minutes;
    }
}
