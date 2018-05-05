/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author JORGE
 */
public class caminoCorto implements ActionListener {

    JLabel peso;
    JComboBox inicioCamino;
    JComboBox finCamino;
    Grafo grafo;
    JPanel camino;
    Lienzo pGraf;
    
    public caminoCorto(JLabel peso,JPanel camino, JComboBox inicioCamino, JComboBox finCamino,Grafo grafo,Lienzo pGraf) {
        this.finCamino=finCamino;
        this.inicioCamino=inicioCamino;
        this.peso=peso;
        this.grafo=grafo;
        this.camino=camino;
        this.pGraf=pGraf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if((this.inicioCamino.getSelectedItem()!=null) & (this.finCamino.getSelectedItem()!=null))
        {
            String[] info=this.grafo.caminoCorto(this.inicioCamino.getSelectedItem().toString(), this.finCamino.getSelectedItem().toString());
            String pes;
            String[] cami=info[1].split("-");
            this.camino.removeAll();
            if(info[0].equals("100000"))
            {
                pes="N/A";
            }
            else
            {
                pes=info[0];
                JPanel pAux=new JPanel();
                pAux.setLayout(null);
                pAux.setBackground(new Color(250,250, 250));
                this.pGraf.reestableserColor();
                for(int i=0;i<cami.length;i++)
                {
                    
                    JButton vert=(JButton)this.pGraf.getComponent(Integer.parseInt(cami[i])-1);
                    JButton vertice=new JButton(vert.getText());
                    vertice.setBounds(90,20+(pAux.getComponentCount()*20), 100, 20);
                    vertice.setBackground(vert.getBackground());
                    if(i<cami.length-1)
                    {
                        JLabel flecha = new JLabel(new ImageIcon(getClass().getResource("/imagenes/flecha.png")));
                        flecha.setBounds(120, 40 + (pAux.getComponentCount() * 20), 40, 20);
                        pAux.add(flecha);
                    }
                    pAux.add(vertice);
                   
                    if(i<cami.length-1)
                    {
                        this.pGraf.cambiarColor(Integer.parseInt(cami[i])-1, Integer.parseInt(cami[i+1])-1);
                    }
                    
                }
                if (cami.length > 4) 
                {
                    pAux.setPreferredSize(new Dimension(260, 21 * (cami.length*2)));
                    JScrollPane scroll = new JScrollPane();
                    scroll.setBounds(4,20,284,161);
                    scroll.setViewportView(pAux);
                    scroll.getViewport().setView(pAux);
                    scroll.setVisible(true);
                    this.camino.add(scroll);
                    this.camino.updateUI();
                } 
                else 
                {
                    pAux.setBounds(4,20,284,161);
                    this.camino.add(pAux);
                    this.camino.updateUI();
                }
                this.camino.updateUI();
            }
            
            this.peso.setText(pes);
        }
        
        
        
        
    }
    
}
