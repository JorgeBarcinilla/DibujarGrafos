/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Grafos;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author jpalacio20
 */
public class movimientoVert implements MouseListener  {
    
    JButton vertise;
    Lienzo panel;
    boolean estado=false;
    int w;
    int z;
    Point ubicacionDefaut;
    Grafo grafo;

    public movimientoVert(JButton vertise,Lienzo panel,Grafo grafo) {
        this.vertise=vertise;
        this.panel=panel;
        this.grafo=grafo;
    }

   
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(this.vertise.isFocusable())
        {
        this.estado=true;
        this.w=(int)this.vertise.getMousePosition().getX();
        this.z=(int)this.vertise.getMousePosition().getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
        if (this.vertise.isFocusable()) 
        {
            this.estado = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(this.vertise.isFocusable())
        {
        if(estado)
        {
            if(this.panel.getMousePosition().getX() > 50 & this.panel.getMousePosition().getX() < 1000 )
            {
                if((this.panel.getMousePosition().getY() > 20 & this.panel.getMousePosition().getY() < 540))
                {
                    int x = (int) this.panel.getMousePosition().getX() - this.w;
                    int y = (int) this.panel.getMousePosition().getY() - this.z;
                    this.vertise.setBounds(x, y, (int) this.vertise.getSize().getWidth(), (int) this.vertise.getSize().getHeight());
                    for (int i = 0; i < this.panel.getComponentCount(); i++) 
                    {
                        JButton vertice = (JButton)this.panel.getComponent(i);
                        if(vertice.getToolTipText().equals(this.vertise.getToolTipText()))
                        {
                            this.panel.modificarLinea(i);
                            break;
                        }
                    }
                }
            }
        }
        }
    }
    
}
