/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.util.Random;

/**
 *
 * @author EslamEbrahim
 */
public class Maze {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RandomMaze rm = new RandomMaze(7,7);
        rm.print();
        rm.generate();
        System.out.println("*********************************************************************");
        rm.print();
    }
    
}
