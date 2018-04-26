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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JORGE
 */
public class crearRelacion implements ActionListener {

    Grafo grafo;
    JTable tabla;
    JComboBox inicio;
    JComboBox fin;
    JTextField peso;
    Lienzo pGraf;
    JTable tabla2;
    
    public crearRelacion(Grafo grafo, JTable tabla,JTable tabla2,JComboBox inicio,JComboBox fin,JTextField peso,Lienzo pGraf) {
        this.grafo=grafo;
        this.tabla=tabla;
        this.fin=fin;
        this.inicio=inicio;
        this.peso=peso;
        this.pGraf=pGraf;
        this.tabla2=tabla2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if((this.fin.getSelectedItem()!=null) & (this.inicio.getSelectedItem()!=null) & (!this.peso.getText().equals("")))
        {
            
            String ini = this.inicio.getSelectedItem().toString();
            String fn = this.fin.getSelectedItem().toString();
            int pes = Integer.parseInt(this.peso.getText());
            
            this.grafo.crearArista(ini, fn, pes);
            
            DefaultTableModel model = (DefaultTableModel) this.tabla.getModel();
            DefaultTableModel model2 = (DefaultTableModel) this.tabla2.getModel();
            for (int i = 1; i < model.getRowCount(); i++) {
                if (model.getValueAt(i, 0).toString().equals(ini)) {
                    for (int j = 1; j < model.getColumnCount(); j++) {
                        if (model.getValueAt(0, j).toString().equals(fn)) {
                            model.setValueAt("" + pes, i, j);
                            model2.setValueAt("1", i, j);
                            for(int k=0;k<this.pGraf.getComponentCount();k++)
                            {
                                JButton vert=(JButton)this.pGraf.getComponent(k);
                                if(vert.getToolTipText().equals(this.inicio.getSelectedItem().toString()))
                                {
                                    for (int l = 0; l < this.pGraf.getComponentCount(); l++) 
                                    {
                                        JButton vert2 = (JButton) this.pGraf.getComponent(l);
                                        if (vert2.getToolTipText().equals(this.fin.getSelectedItem().toString())) 
                                        {
                                            this.pGraf.pintarRelacion(k, l,this.peso.getText());
                                            this.pGraf.reestableserColor();
                                            break;
                                        }
                                    }
                                }
                            }
                            
                            this.peso.setText("");
                            break;
                        }
                    }
                }
            
            }
        }
        
    }
    
   
}
