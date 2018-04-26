/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import java.util.Arrays;

/**
 *
 * @author JORGE
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[][] matrizPesos={{0,15,5,6},{0,0,0,0},{0,8,0,0},{0,7,0,0}};
        
        Dijkstra a=new Dijkstra(matrizPesos);
        a.calcular(0);
        //System.out.println(Arrays.toString(a.getDistancia(2)));
        
    }
    
}
