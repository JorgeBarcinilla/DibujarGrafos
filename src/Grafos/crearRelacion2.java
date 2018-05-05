/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JORGE LUIS
 */
public class crearRelacion2 implements MouseListener{
    Lienzo pGraf;
    Grafo grafo;
    JTable tabla;
    JTable tabla2;
    JButton vertise;

    public crearRelacion2(JButton vertise,Grafo grafo, JTable tabla,JTable tabla2,Lienzo pGraf) {
        this.pGraf=pGraf;
        this.grafo=grafo;
        this.tabla=tabla;
        this.tabla2=tabla2;
        this.vertise=vertise;
    }

   
    @Override
    public void mouseClicked(MouseEvent e) {
        
        boolean est = false;
        JButton vertIni = null;
        for (int i = 0; i < this.pGraf.getComponentCount(); i++) {
            
            if((this.pGraf.getComponent(i).getBackground()==Color.yellow) && (this.vertise != (JButton)this.pGraf.getComponent(i)))
            {
                vertIni = (JButton)this.pGraf.getComponent(i);
                est=true;
                break;
            }
            
        }
        
        if(est & vertIni != null)
        {
            this.vertise.setBackground(Color.yellow);
            int pes = 0;
            boolean bandera = false;
            String res = null;
            do 
            {
                try 
                {
                    res = javax.swing.JOptionPane.showInputDialog("Introduce el peso de la arista");
                    if(res == null)
                    {
                        break;
                    }
                    pes = Integer.parseInt(res);
                    if(pes < 100000)
                    {
                        bandera = true;
                    }
                    else
                    {
                        javax.swing.JOptionPane.showMessageDialog(null, "Solo numeros maximo de 5 cifras");
                    }
                } 
                catch (NumberFormatException i) 
                {
                    javax.swing.JOptionPane.showMessageDialog(null, "Solo se permiten numeros");
                    bandera = false;
                }
            } 
            while (!bandera);

            if(res != null)
            {
                String ini = vertIni.getText();
                String fn = this.vertise.getText();
                this.grafo.crearArista(ini, fn, pes);

                DefaultTableModel model = (DefaultTableModel) this.tabla.getModel();
                DefaultTableModel model2 = (DefaultTableModel) this.tabla2.getModel();
                for (int i = 1; i < model.getRowCount(); i++) {
                    if (model.getValueAt(i, 0).toString().equals(ini)) {
                        for (int j = 1; j < model.getColumnCount(); j++) {
                            if (model.getValueAt(0, j).toString().equals(fn)) {
                                model.setValueAt("" + pes, i, j);
                                model2.setValueAt("1", i, j);
                                for (int k = 0; k < this.pGraf.getComponentCount(); k++) {
                                    JButton vert = (JButton) this.pGraf.getComponent(k);
                                    if (vert.getToolTipText().equals(ini)) {
                                        for (int l = 0; l < this.pGraf.getComponentCount(); l++) {
                                            JButton vert2 = (JButton) this.pGraf.getComponent(l);
                                            if (vert2.getToolTipText().equals(fn)) {
                                                this.pGraf.pintarRelacion(k, l,""+pes);
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
            vertIni.setBackground(Color.LIGHT_GRAY);
            this.vertise.setBackground(Color.LIGHT_GRAY);
        }
        else
        {
            if (this.vertise.getBackground() == Color.LIGHT_GRAY) 
            {
                this.vertise.setBackground(Color.yellow);
            } 
            else 
            {
                if (this.vertise.getBackground() == Color.yellow) 
                {
                    this.vertise.setBackground(Color.LIGHT_GRAY);
                }
            }
        
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
