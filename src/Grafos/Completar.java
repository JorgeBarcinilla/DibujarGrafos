/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author JORGE
 */
public class Completar implements ActionListener {

    JPanel pGraf;
    JComboBox inicio;
    JComboBox fin;
    Grafo grafo;
    
    public Completar(JPanel pGraf, JComboBox inicio, JComboBox fin,Grafo grafo) {
        this.fin=fin;
        this.inicio=inicio;
        this.pGraf=pGraf;
        this.grafo=grafo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.inicio.getSelectedItem()!=null)
        {
        this.fin.removeAllItems();
        if(this.inicio.getName().equals("inicioElimi"))
        {
            String nomVert = this.inicio.getSelectedItem().toString();
            for(int i = 0; i < this.grafo.ObtenerTamaño(); i++)
            {
                if(this.grafo.obtenerVertice(i).obtenerNombre().equals(nomVert))
                {
                    for (int j = 0; j < this.grafo.obtenerVertice(i).obtenerAcceso().size(); j++) 
                    {
                        if(Integer.parseInt(this.grafo.obtenerVertice(i).obtenerAcceso().get(j)[1])!=999 & !this.grafo.obtenerVertice(i).obtenerAcceso().get(j)[0].equals(nomVert))
                        {
                            this.fin.addItem(this.grafo.obtenerVertice(i).obtenerAcceso().get(j)[0]);
                        }
                        
                    }
                    break;
                }
            }
        }
        else
        {
            String nomVert = this.inicio.getSelectedItem().toString();
            for (int i = 0; i < this.pGraf.getComponentCount(); i++) 
            {
                JButton vertExis = (JButton) this.pGraf.getComponent(i);
                if (!vertExis.getToolTipText().equals(nomVert)) 
                {
                    this.fin.addItem(vertExis.getToolTipText());
                }

            }
        }
        }
    }
    
}
