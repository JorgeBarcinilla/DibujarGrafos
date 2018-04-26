/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

/**
 *
 * @author usuario
 */
public class Arista {
    
    private final int peso;
    private final Vertice llegada;

    public Arista(Vertice llegada,int peso) {
        this.peso = peso;
        this.llegada = llegada;
    }

    public int getPeso() {
        return peso;
    }

    public Vertice getLlegada() {
        return llegada;
    }

    
    
    
    
}
