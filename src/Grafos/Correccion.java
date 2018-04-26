/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *
 * @author Jorge
 */
public class Correccion implements KeyListener {

    private final JTextField nombre;
    private final int tamaño;
    private final String tipo;
        
    public Correccion(JTextField nombre,int tamaño,String tipo) {
        this.nombre=nombre;
        this.tamaño=tamaño;
        this.tipo=tipo;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        this.nombre.setBackground(Color.white);
        char letra=e.getKeyChar();
        
        if(this.nombre.getText().length()<=this.tamaño-1)
        {
            if (this.tipo.equals("letras")) {
                if (!Character.isLetter(letra))
                {
                    e.consume();
                }
            } 
            else 
            {
                if (this.tipo.equals("numeros"))
                {
                    if (!Character.isDigit(letra))
                    {
                        e.consume();
                    }
                    
                }
                else
                {
                    if (this.tipo.equals("todos")) 
                    {
                        if (Character.isSpaceChar(letra))
                        {
                            e.consume();
                        }
                        
                        if (!Character.isLetter(letra) & !Character.isDigit(letra)) 
                        {
                            e.consume();
                        }
                        
                    }
                    else
                    {
                        if (this.tipo.equals("busqueda"))
                        {
                            if(!Character.isLetter(letra) & !Character.isSpaceChar(letra))
                            {
                                e.consume();
                            }
                        }
                    }
                }
            }
        }
        else
        {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
               
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        
        
    }
    
}

