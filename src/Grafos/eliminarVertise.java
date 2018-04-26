/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JORGE
 */
public class eliminarVertise implements ActionListener {

    Lienzo pGraf;
    JComboBox vertElimi;
    JComboBox[] boxs;
    Grafo grafo;
    JTable tabla;
    JButton btnCrearVert;
    JTable tabla2;
    
    public eliminarVertise(Lienzo pGraf, JComboBox vertElimi, JComboBox[] boxs,Grafo grafo,JTable tabla,JTable tabla2,JButton btnCrearVert) {
        this.vertElimi=vertElimi;
        this.pGraf=pGraf;
        this.boxs=boxs;
        this.grafo=grafo;
        this.tabla=tabla;
        this.btnCrearVert=btnCrearVert;
        this.tabla2=tabla2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.vertElimi.getSelectedItem() != null)
        {
        String nomVert=this.vertElimi.getSelectedItem().toString();
        for(int i=0;i<this.pGraf.getComponentCount();i++)
            {
                
                JButton vertExis=(JButton)this.pGraf.getComponent(i);
                if(vertExis.getToolTipText().equals(nomVert))
                {
                    this.pGraf.eliminarVertice(i);
                    this.grafo.eliminarVertice(nomVert);
                    for (JComboBox box : this.boxs) {
                        box.removeItem(nomVert);
                        box.updateUI();
                    }
                    
                    DefaultTableModel modelAnt = (DefaultTableModel) this.tabla.getModel();
                    DefaultTableModel modelAnt2 = (DefaultTableModel) this.tabla2.getModel();
                    DefaultTableModel model=new DefaultTableModel(modelAnt.getRowCount()-1,modelAnt.getColumnCount()-1);
                    DefaultTableModel model2=new DefaultTableModel(modelAnt2.getRowCount()-1,modelAnt2.getColumnCount()-1);
                    DefaultTableCellRenderer tcr2 = new DefaultTableCellRenderer();
                    tcr2.setHorizontalAlignment(SwingConstants.CENTER);
                    tcr2.setBackground(Color.lightGray);
                    DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                    tcr.setHorizontalAlignment(SwingConstants.CENTER);
                    int fil=0;
                    int colum=0;
                    for(int j=0;j<modelAnt.getRowCount();j++)
                    {
                        for (int k = 0; k < modelAnt.getColumnCount(); k++) 
                        {
                            if(colum==(modelAnt.getColumnCount()-1))
                            {
                                break;
                            }
                            else
                            {
                                if (k == (i + 1))
                                {
                                    k++;
                                }
                                model.setValueAt(modelAnt.getValueAt(j, k), fil, colum);
                                model2.setValueAt(modelAnt2.getValueAt(j, k), fil, colum);
                                colum++;
                            }
                        }
                        if (fil == (modelAnt.getColumnCount() - 1)) 
                        {
                            break;
                        }
                        else
                        {
                            if (j == i) 
                            {
                                j++;
                            }
                            fil++;
                            colum = 0;
                        }
                        
                    }
                    int largo = 16 * model.getRowCount();
                    int ancho = 52 * model.getRowCount();

                    this.tabla.setSize(ancho, largo);
                    this.tabla.setModel(model);
                    this.tabla2.setSize(ancho, largo);
                    this.tabla2.setModel(model2);
                    this.pGraf.remove(i);
                    this.pGraf.updateUI();
                    
                    for(int j=0;j<model.getColumnCount();j++)
                    {
                        if (i == 0)
                        {
                            this.tabla.getColumnModel().getColumn(i).setCellRenderer(tcr2);
                            this.tabla2.getColumnModel().getColumn(i).setCellRenderer(tcr2);
                        } 
                        else 
                        {
                            this.tabla.getColumnModel().getColumn(j).setCellRenderer(tcr);
                            this.tabla2.getColumnModel().getColumn(j).setCellRenderer(tcr);
                        }
                    }
                    
                    if (this.pGraf.getComponentCount() < 9)
                    {
                        this.btnCrearVert.setEnabled(true);
                    }
                    if(model.getColumnCount()==1)
                    {
                        this.tabla.setVisible(false);
                        this.tabla2.setVisible(false);
                    }
                    this.tabla.setRowSelectionInterval(0, 0);
                    this.tabla2.setRowSelectionInterval(0, 0);
                    this.pGraf.reestableserColor();
                    break;
                }
                
            }
        
            
        
        }
    }
    
}
