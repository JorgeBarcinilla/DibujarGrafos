/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

/**
 *
 * @author JORGE
 */
public class Linea {
    
    private String[] id;
    private String peso;
    private Color color;
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Linea(int x1, int y1, int x2, int y2,String[] id,String peso) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.id=id;
        this.peso=peso;
        this.color=Color.BLACK;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
   
    public String[] getId() {
        return id;
    }

    public void setId(String[] id) {
        this.id = id;
    }
    
    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
    
    public void Pintar(Graphics g)
    {
        BasicStroke stroke =new BasicStroke(2f);
        
        Graphics2D g2=(Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(stroke);
        g2.setColor(this.color);
        g2.drawLine(this.x1, this.y1, this.x2, this.y2);
        g2.setFont(new Font("Comic Sans MS", 1, 14));
        if(this.x1 > this.x2 && this.y1 > this.y2)
        {
            g2.drawString(this.peso,(x1 - Math.abs((x1-x2)/2))-5, (y1 - Math.abs((y1-y2)/2)-5));
        }
        if(this.x1 < this.x2 && this.y1 < this.y2)
        {
            g2.drawString(this.peso,(x2 - Math.abs((x1-x2)/2))+5, (y2 - Math.abs((y1-y2)/2))+5);
        }
        if(this.x1 > this.x2 && this.y1 < this.y2)
        {
            g2.drawString(this.peso,(x1 - Math.abs((x1-x2)/2))-10, (y2 - Math.abs((y1-y2)/2))+10);
        }
        if(this.x1 < this.x2 && this.y1 > this.y2)
        {
            g2.drawString(this.peso,(x2 - Math.abs((x1-x2)/2))+10, (y1 - Math.abs((y1-y2)/2))-10);
        }
        double ty=-(this.y1-this.y2)*1.0;
        double tx=(this.x1-this.x2)*1.0;
        double ang=Math.atan (ty/tx);
        if (tx < 0) 
        {
            ang += Math.PI;
        }
        
        Point p1=new Point();
        Point p2=new Point();
        double angSep=25.0;
        
        p1.x = (int) (this.x2 + 15 * Math.cos(ang - Math.toRadians(angSep)));
        p1.y = (int) (this.y2 - 15 * Math.sin(ang - Math.toRadians(angSep)));
        p2.x = (int) (this.x2 + 15 * Math.cos(ang + Math.toRadians(angSep)));
        p2.y = (int) (this.y2 - 15 * Math.sin(ang + Math.toRadians(angSep)));
        
        g2.drawLine(p1.x, p1.y, this.x2, this.y2);
        g2.drawLine(p2.x, p2.y,this.x2, this.y2);
        
    }

    
    
}
