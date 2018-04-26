/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import static javax.swing.BorderFactory.createLineBorder;
import static javax.swing.BorderFactory.createTitledBorder;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author JORGE
 */
public class Lienzo extends JPanel{

    private ArrayList<Linea> listaLineas;
    
    public ArrayList<Linea> getListaLineas() {
        return this.listaLineas;
    }

    public void setListaLineas(ArrayList<Linea> listaLineas) {
        this.listaLineas = listaLineas;
    }
    
    public Lienzo() 
    {
        super.setBounds(300, 0, 1100, 550);
        super.setLayout(null);
        super.setBackground(new Color(255, 255, 255));
        super.setBorder(createTitledBorder(createLineBorder(new Color(0, 0, 0)), "GRAFO", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Comic Sans MS", 1, 14)));
        this.listaLineas=new ArrayList();
    }
    
    public void pintarRelacion(int inicio,int fin,String peso)
    {
        if(this.getComponentCount()>1)
        {
            JButton ini = (JButton) this.getComponent(inicio);
            JButton fn = (JButton) this.getComponent(fin);
            boolean estado=true; 
            for (int i = 0; i < this.listaLineas.size(); i++) 
            {
                if (this.listaLineas.size() > 0) 
                {
                    if (this.listaLineas.get(i).getId()[0].equals(ini.getToolTipText()) & this.listaLineas.get(i).getId()[1].equals(fn.getToolTipText())) 
                    {
                        this.listaLineas.get(i).setPeso(peso);
                        estado=false;
                        repaint();
                        break;
                    }
                }
            }
            
            if(estado)
            {
                String [] id={ini.getToolTipText(),fn.getToolTipText()};
                int x1=(int)ini.getLocation().getX();
                int y1=(int)ini.getLocation().getY();
                int x2=(int)fn.getLocation().getX();
                int y2=(int)fn.getLocation().getY();
                if(x1>x2 & y1>y2)
                {
                    this.listaLineas.add(new Linea( x1,y1,x2+100,y2+20,id,peso));
                }
                if(x1>x2 & y1<y2)
                {
                    this.listaLineas.add(new Linea( x1,y1+20,x2+100,y2,id,peso));
                }
                if(x1<x2 & y1<y2)
                {
                    this.listaLineas.add(new Linea( x1+100,y1+20,x2,y2,id,peso));
                }
                if(x1<x2 & y1>y2)
                {
                    this.listaLineas.add(new Linea( x1+100,y1,x2,y2+20,id,peso));
                }
                repaint();
            }
            
        }
    }
    
    
    public void cambiarColor(int inicio,int fin)
    {
        if(this.getComponentCount()>1)
        {
                JButton ini = (JButton)this.getComponent(inicio);
                JButton fn=(JButton)this.getComponent(fin);
                for(int i=0;i<this.listaLineas.size();i++)
                {
                    if(this.listaLineas.size()>0)
                    {
                        if (this.listaLineas.get(i).getId()[0].equals(ini.getToolTipText()) & this.listaLineas.get(i).getId()[1].equals(fn.getToolTipText())) 
                        {
                            this.listaLineas.get(i).setColor(Color.red);
                            break;
                        }
                        
                    }
                }
                repaint();
        }
    }
    
    public void reestableserColor()
    {
        if(this.getComponentCount()>1)
        {
                for(int i=0;i<this.listaLineas.size();i++)
                {
                    this.listaLineas.get(i).setColor(Color.black);
                }
                repaint();
        }
    }
    
    public void modificarLinea(int vert)
    {
        if(this.getComponentCount()>1)
        {
                JButton vertice = (JButton)this.getComponent(vert);
                JButton vert2=null;
                for(int i=0;i<this.listaLineas.size();i++)
                {
                    if(this.listaLineas.get(i).getId()[0].equals(vertice.getToolTipText()))
                    {
                        for (int j = 0; j < this.getComponentCount(); j++) {
                            vert2=(JButton)this.getComponent(j);
                            if(vert2.getToolTipText().equals(this.listaLineas.get(i).getId()[1]))
                            {
                                break;
                            }
                        }
                        
                        int x1 = (int) vertice.getLocation().getX();
                        int y1 = (int) vertice.getLocation().getY();
                        int x2 = (int) vert2.getLocation().getX();
                        int y2 = (int) vert2.getLocation().getY();
                        if (x1 > x2 & y1 > y2) {
                            this.listaLineas.get(i).setX1(x1);
                            this.listaLineas.get(i).setY1(y1);
                            this.listaLineas.get(i).setX2(x2+100);
                            this.listaLineas.get(i).setY2(y2+20);
                        }
                        if (x1 > x2 & y1 < y2) {
                            this.listaLineas.get(i).setX1(x1);
                            this.listaLineas.get(i).setY1(y1+20);
                            this.listaLineas.get(i).setX2(x2+100);
                            this.listaLineas.get(i).setY2(y2);
                        }
                        if (x1 < x2 & y1 < y2) {
                            this.listaLineas.get(i).setX1(x1+100);
                            this.listaLineas.get(i).setY1(y1+20);
                            this.listaLineas.get(i).setX2(x2);
                            this.listaLineas.get(i).setY2(y2);
                        }
                        if (x1 < x2 & y1 > y2) {
                            this.listaLineas.get(i).setX1(x1+100);
                            this.listaLineas.get(i).setY1(y1);
                            this.listaLineas.get(i).setX2(x2);
                            this.listaLineas.get(i).setY2(y2+20);
                        }
                      
                        /*System.out.println(this.listaLineas.get(i).getId()[0]+"--"+this.listaLineas.get(i).getId()[1]);
                        
                        this.listaLineas.get(i).setX1((int)vertice.getLocation().getX());
                        this.listaLineas.get(i).setY1((int)vertice.getLocation().getY());*/
                    }
                    if(this.listaLineas.get(i).getId()[1].equals(vertice.getToolTipText()))
                    {
                        for (int j = 0; j < this.getComponentCount(); j++) {
                            vert2=(JButton)this.getComponent(j);
                            if(vert2.getToolTipText().equals(this.listaLineas.get(i).getId()[0]))
                            {
                                break;
                            }
                        }
                        
                        int x2 = (int) vertice.getLocation().getX();
                        int y2 = (int) vertice.getLocation().getY();
                        int x1 = (int) vert2.getLocation().getX();
                        int y1 = (int) vert2.getLocation().getY();
                        if (x1 > x2 & y1 > y2) {
                            this.listaLineas.get(i).setX1(x1);
                            this.listaLineas.get(i).setY1(y1);
                            this.listaLineas.get(i).setX2(x2+100);
                            this.listaLineas.get(i).setY2(y2+20);
                        }
                        if (x1 > x2 & y1 < y2) {
                            this.listaLineas.get(i).setX1(x1);
                            this.listaLineas.get(i).setY1(y1+20);
                            this.listaLineas.get(i).setX2(x2+100);
                            this.listaLineas.get(i).setY2(y2);
                        }
                        if (x1 < x2 & y1 < y2) {
                            this.listaLineas.get(i).setX1(x1+100);
                            this.listaLineas.get(i).setY1(y1+20);
                            this.listaLineas.get(i).setX2(x2);
                            this.listaLineas.get(i).setY2(y2);
                        }
                        if (x1 < x2 & y1 > y2) {
                            this.listaLineas.get(i).setX1(x1+100);
                            this.listaLineas.get(i).setY1(y1);
                            this.listaLineas.get(i).setX2(x2);
                            this.listaLineas.get(i).setY2(y2+20);
                        }
                       
                        /*this.listaLineas.get(i).setX2((int)vertice.getLocation().getX()+100);
                       this.listaLineas.get(i).setY2((int)vertice.getLocation().getY());*/
                    }
                }
                repaint();
        }
    }
    
    public void eliminarVertice(int vert)
    {
        if(this.getComponentCount()>1)
        {
                JButton vertice = (JButton)this.getComponent(vert);
                for(int j=0;j<=this.listaLineas.size();j++)
                {
                    for (int i = 0; i < this.listaLineas.size(); i++) 
                    {
                        if (this.listaLineas.size() > 0) 
                        {
                            if (this.listaLineas.get(i).getId()[0].equals(vertice.getToolTipText())) 
                            {
                                this.listaLineas.remove(i);
                                j=0;
                                repaint();
                                break;
                            }
                        }
                        if (this.listaLineas.size() > 0)
                        {
                            if (this.listaLineas.get(i).getId()[1].equals(vertice.getToolTipText())) 
                            {
                                this.listaLineas.remove(i);
                                j=0;
                                repaint();
                                break;
                            }
                        }
                    }
                }
                
        }
    }

    public void eliminarRelacion(int inicio,int fin)
    {
        if(this.getComponentCount()>1)
        {
                JButton ini = (JButton)this.getComponent(inicio);
                JButton fn=(JButton)this.getComponent(fin);
                for(int i=0;i<this.listaLineas.size();i++)
                {
                    if(this.listaLineas.size()>0)
                    {
                        if (this.listaLineas.get(i).getId()[0].equals(ini.getToolTipText()) & this.listaLineas.get(i).getId()[1].equals(fn.getToolTipText())) 
                        {
                            this.listaLineas.remove(i);
                        }
                    }
                }
                repaint();
        }
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);  // llamar al método paint de la superclase
        listaLineas.forEach((listaLinea) ->  {
            listaLinea.Pintar(g);
        });
    }

    
}
