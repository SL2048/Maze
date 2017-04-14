/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

/**
 *
 * @author EslamEbrahim
 */
public class RandomMaze {
    private int height;
    private int width;
    private int [][] maze;
    private int [][] len;
    private Block [][] blocks;
    
    public RandomMaze(int h, int w){
        this.height = h;
        this.width = w;
        maze = new int[h][w];
        len = new int[h][w];
        blocks = new Block[h][w];
        
        for(int i = 0 ; i < h ; i++){
            for(int j = 0 ; j < w ; j++){
                maze[i][j] = i * w + j;
                len[i][j] = 1;
                blocks[i][j] = new Block();
            }
        }
        blocks[0][0].breakLeft();
        blocks[h-1][w-1].breakRight();
        
    }
    
    private int find(int i, int j){
        return (i < this.height && j < this.width) ? maze[i][j] : -1;
    }
    
    private int getLen(int i, int j){
        return (i < this.height && j < this.width) ? len[i][j] : Integer.MAX_VALUE;
    }
    
    private void union(int i1, int j1, int i2, int j2){
        int sum = this.len[i1][j1] + this.len[i2][j2];
        
        if(this.getLen(i1, j1) >= this.getLen(i2, j2)){
            int s = this.maze[i2][j2];
            int t = this.maze[i1][j1];
            
            
            for(int i = 0 ; i < this.height ; i++){
                for(int j = 0 ; j < this.width ; j++){
                    
                    if(this.maze[i][j] == s){
                        
                        this.maze[i][j] = this.maze[i1][j1];
                        this.len[i][j] = sum;
                    }
                    else if(this.maze[i][j] == t){
                        this.len[i][j] = sum;
                    }
                    
                }
            }
        }
        else{
            int s = this.maze[i1][j1];
            int t = this.maze[i2][j2];
            
            
            for(int i = 0 ; i < this.height ; i++){
                for(int j = 0 ; j < this.width ; j++){
                    
                    if(this.maze[i][j] == s){
                        
                        this.maze[i][j] = this.maze[i2][j2];
                        this.len[i][j] = sum;
                        
                    }
                    else if(this.maze[i][j] == t){
                        this.len[i][j] = sum;
                    }
                    
                }
            }
        }
        
    }
    
    public void generate(){
        while(maze[0][0] != maze[height-1][width-1]){
            
            int Ri1 , Rj1, Ri2, Rj2, random;
            random = (int)(Math.random() * (height * width));
            Ri1 = random / width;
            Rj1 = random % width;
            
            while(true){
                int r = (int)(Math.random() * 100);
                if(r <= 25){ // left
                    if(Rj1 != 0){
                        Ri2 = Ri1;
                        Rj2 = Rj1 - 1;
                        break;
                    }
                }
                else if(r <= 50){//up
                    if(Ri1 != 0){
                        Ri2 = Ri1 - 1;
                        Rj2 = Rj1;
                        break;
                    }
                }
                else if(r <= 75){//right
                    if(this.width > (Rj1 + 1)){
                        Ri2 = Ri1;
                        Rj2 = Rj1 + 1;
                        break;
                    }
                }
                else if(r <= 100){//down
                    if(this.height > (Ri1 + 1)){
                        Ri2 = Ri1 + 1;
                        Rj2 = Rj1;
                        break;
                    }
                }
            }
            
            //System.out.println(Ri1 + "," + Rj1 + "    "  + Ri2 + "," + Rj2);
            //System.out.println(this.maze[Ri1][Rj1] + " " + this.maze[Ri2][Rj2]);
            
            if(this.find(Ri2, Rj2) != this.find(Ri1, Rj1)){
                if(Ri1 + 1 == Ri2){//down
                    blocks[Ri1][Rj1].breakDown();
                    blocks[Ri2][Rj2].breakUp();
                }
                else if(Ri1 - 1 == Ri2){//up
                    blocks[Ri1][Rj1].breakUp();
                    blocks[Ri2][Rj2].breakDown();
                }
                else if(Rj1 + 1 == Rj2){//right
                    blocks[Ri1][Rj1].breakRight();
                    blocks[Ri2][Rj2].breakLeft();
                }
                else if(Rj1 - 1 == Rj2){
                    blocks[Ri1][Rj1].breakLeft();
                    blocks[Ri2][Rj2].breakRight();
                }
                this.union(Ri1, Rj1, Ri2, Rj2);
            }
        }
    }
    
    public void print(){
        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                System.out.print(blocks[i][j].getUpleft() + blocks[i][j].getUp() + blocks[i][j].getUpright());
            }
            System.out.println("");
            for(int j = 0; j < width ; j++){
                System.out.print(blocks[i][j].getLeft() + blocks[i][j].getB() + blocks[i][j].getRight());
            }
            System.out.println("");
        }
        
        for(int j = 0 ; j < width ; j++){
            System.out.print(blocks[height-1][j].getDownleft()+blocks[height-1][j].getDown()+blocks[height-1][j].getDownright());
        }
        System.out.println("");
    }
}
