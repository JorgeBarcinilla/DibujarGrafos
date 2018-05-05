/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Grafos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jpalacio20
 */
class crearVertise implements ActionListener {

    Lienzo pGraf;
    JTextField nomVertise;
    JComboBox[] boxs;
    Grafo grafo;
    JTable tabla;
    JButton btnCrearVert;
    JTable tabla2;
    
    public crearVertise(Lienzo pGraf, JTextField nomVertise,JComboBox[] boxs,Grafo grafo,JTable tabla,JTable tabla2,JButton btnCrearVert) {
        this.nomVertise=nomVertise;
        this.pGraf=pGraf;
        this.boxs=boxs;
        this.grafo=grafo;
        this.tabla=tabla;
        this.btnCrearVert=btnCrearVert;
        this.tabla2=tabla2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(!this.nomVertise.getText().equals(""))
        {
            int cont=0;
            for(int i=0;i<this.pGraf.getComponentCount();i++)
            {
                
                JButton vertExis=(JButton)this.pGraf.getComponent(i);
                if(vertExis.getToolTipText().equals(this.nomVertise.getText()))
                {
                    cont++;
                    break;
                }
                
            }
            
            if(cont==0)
            {
                this.grafo.añadirVertice(this.nomVertise.getText());
                Random alt = new Random();
                JButton vert = new JButton(this.nomVertise.getText());
                vert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                vert.setBounds(alt.nextInt(1000) + 20, alt.nextInt(520)+20, 100, 20);
                vert.setToolTipText(this.nomVertise.getText());
                vert.addMouseListener(new movimientoVert(vert,this.pGraf,this.grafo));
                vert.addMouseListener(new crearRelacion2(vert,this.grafo,this.tabla,this.tabla2,this.pGraf));
                vert.setBackground(Color.LIGHT_GRAY);
                vert.setFont(new Font("Comic Sans MS", 4, 14));
                vert.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null ,new Color(0, 0, 0), new Color(0, 0, 0), Color.DARK_GRAY));

                for (JComboBox box : this.boxs) {
                    box.addItem(this.nomVertise.getText());
                }
                
                this.pGraf.add(vert);
                this.pGraf.updateUI();
                
                DefaultTableModel modelAnt=(DefaultTableModel)this.tabla.getModel();
                DefaultTableModel modelAnt2=(DefaultTableModel)this.tabla2.getModel();
                modelAnt.setNumRows(modelAnt.getRowCount()+1);
                modelAnt.setColumnCount(modelAnt.getColumnCount()+1);
                modelAnt2.setNumRows(modelAnt2.getRowCount()+1);
                modelAnt2.setColumnCount(modelAnt2.getColumnCount()+1);
                DefaultTableCellRenderer tcr2 = new DefaultTableCellRenderer();
                tcr2.setHorizontalAlignment(SwingConstants.CENTER);
                tcr2.setBackground(Color.lightGray);
                DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                tcr.setHorizontalAlignment(SwingConstants.CENTER);
                for(int i=0;i<modelAnt.getRowCount();i++)
                {
                    for (int j = 0; j < modelAnt.getColumnCount(); j++) 
                    {
                        if(j==i)
                        {
                            if(j!=0 & i!=0)
                            {
                                modelAnt.setValueAt("0", i, j);
                                modelAnt2.setValueAt("1", i, j);
                            }
                        }
                        else
                        {
                            if (modelAnt.getValueAt(i, j)==null) 
                            {
                                modelAnt.setValueAt("N/A", i, j);
                                modelAnt2.setValueAt("0", i, j);
                            }
                        }
                        
                    }
                }
                for(int i=0;i<this.grafo.ObtenerTamaño();i++)
                {
                    modelAnt2.setValueAt(this.grafo.obtenerVertice(i).obtenerNombre(), (i+1), 0);
                    modelAnt2.setValueAt(this.grafo.obtenerVertice(i).obtenerNombre(), 0, (i+1));
                    modelAnt.setValueAt(this.grafo.obtenerVertice(i).obtenerNombre(), (i+1), 0);
                    modelAnt.setValueAt(this.grafo.obtenerVertice(i).obtenerNombre(), 0, (i+1));
                    if(i==0)
                    {
                        this.tabla.getColumnModel().getColumn(i).setCellRenderer(tcr2);
                        this.tabla2.getColumnModel().getColumn(i).setCellRenderer(tcr2);
                    }
                    else
                    {
                        this.tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
                        this.tabla.getColumnModel().getColumn(i + 1).setCellRenderer(tcr);
                        this.tabla2.getColumnModel().getColumn(i).setCellRenderer(tcr);
                        this.tabla2.getColumnModel().getColumn(i + 1).setCellRenderer(tcr);
                    }
                    
                }
                
                int largo=16*modelAnt.getRowCount();
                int ancho=52*modelAnt.getColumnCount();
                
                this.tabla.setSize(ancho,largo);
                this.tabla2.setSize(ancho,largo);
                
                if(this.pGraf.getComponentCount()>8)
                {
                    this.btnCrearVert.setEnabled(false);
                }
                this.tabla.setVisible(true);
                this.tabla2.setVisible(true);
                this.tabla.setRowSelectionInterval(0, 0);
                this.tabla2.setRowSelectionInterval(0, 0);
            }
            
        }
        this.nomVertise.setText("");
    }
    
}
