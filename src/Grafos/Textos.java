/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author ESCEC010507
 */
public class Textos extends JLabel {

    public Textos(String texto,int posY) {
        
        Font tipo=new Font("Comic Sans MS",4,18);
        
        super.setText(texto);
        super.setBounds(0, posY, 150, 30);
        super.setFont(tipo);
        super.setHorizontalAlignment(JLabel.CENTER);
        super.setForeground(Color.black);
        
    }
    public Textos(String texto,int posX,int posY,int anch) {
        
        Font tipo=new Font("Comic Sans MS",4,18);
        
        super.setText(texto);
        super.setBounds(posX, posY, anch, 30);
        super.setFont(tipo);
        super.setHorizontalAlignment(JLabel.CENTER);
        super.setForeground(Color.black);
        
    }
    
}
