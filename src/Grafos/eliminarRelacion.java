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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jpalacio20
 */
class eliminarRelacion implements ActionListener {

    Grafo grafo;
    JTable tabla; 
    JComboBox inicioElimi;
    JComboBox finElimi; 
    Lienzo pGraf;
    JTable tabla2;
    
    public eliminarRelacion(Grafo grafo, JTable tabla,JTable tabla2, JComboBox inicioElimi, JComboBox finElimi,Lienzo pGraf) {
        this.grafo = grafo;
        this.tabla = tabla;
        this.inicioElimi = inicioElimi;
        this.finElimi = finElimi;
        this.pGraf=pGraf;
        this.tabla2=tabla2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if((this.inicioElimi.getSelectedItem()!=null) & (this.finElimi.getSelectedItem()!=null))
        {
            String ini = this.inicioElimi.getSelectedItem().toString();
            String fn = this.finElimi.getSelectedItem().toString();
            
            this.grafo.eliminarArista(ini, fn);
            
            DefaultTableModel model = (DefaultTableModel) this.tabla.getModel();
            DefaultTableModel model2 = (DefaultTableModel) this.tabla2.getModel();
            for (int i = 1; i < model.getRowCount(); i++) {
                if (model.getValueAt(i, 0).toString().equals(ini)) {
                    for (int j = 1; j < model.getColumnCount(); j++) {
                        if (model.getValueAt(0, j).toString().equals(fn)) {
                            model.setValueAt("N/A", i, j);
                            model2.setValueAt("0", i, j);
                            for(int k=0;k<this.pGraf.getComponentCount();k++)
                            {
                                JButton vert=(JButton)this.pGraf.getComponent(k);
                                if(vert.getToolTipText().equals(this.inicioElimi.getSelectedItem().toString()))
                                {
                                    for (int l = 0; l < this.pGraf.getComponentCount(); l++) 
                                    {
                                        JButton vert2 = (JButton) this.pGraf.getComponent(l);
                                        if (vert2.getToolTipText().equals(this.finElimi.getSelectedItem().toString())) 
                                        {
                                            this.pGraf.eliminarRelacion(k, l);
                                            this.pGraf.reestableserColor();
                                            break;
                                        }
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
            
            }
        }
        
    }
    
}
