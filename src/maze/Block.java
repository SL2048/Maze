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
public class Block {
    
    /*  block structure
        *************************************
        * upleft   * up          * upright  *
        *************************************
        * left     * block space * right    *
        *************************************
        * downleft * down        * downright*
        *************************************
    */
    
    private String up;
    private String upleft;
    private String upright;
    private String down;
    private String downleft;
    private String downright;
    private String left;
    private String right;
    private String b;

    public Block() {
        up = "b";
        upleft = "b";
        upright = "b";
        down = "b";
        downleft = "b";
        downright = "b";
        left = "b";
        right = "b";
        b = " ";
    }

    public String getUp() {
        return up;
    }
    
    public void breakUp(){
        up = " ";
    }

    public String getDown() {
        return down;
    }
    
    public void breakDown(){
        down = " ";
    }

    public String getLeft() {
        return left;
    }
    
    public void breakLeft(){
        left = " ";
    }

    public String getRight() {
        return right;
    }
    
    public void breakRight(){
        right = " ";
    }

    public String getUpleft() {
        return upleft;
    }

    public String getUpright() {
        return upright;
    }

    public String getDownleft() {
        return downleft;
    }

    public String getDownright() {
        return downright;
    }

    public String getB() {
        return b;
    }
    
}
