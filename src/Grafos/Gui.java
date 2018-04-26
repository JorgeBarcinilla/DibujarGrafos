/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import static javax.swing.BorderFactory.createLineBorder;
import static javax.swing.BorderFactory.createTitledBorder;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JORGE
 */
public class Gui extends JFrame{
    
    public Gui() {
        
        super.setSize(1406, 829);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        
        Grafo grafo=new Grafo();
        DefaultListCellRenderer a=new DefaultListCellRenderer();
        a.setHorizontalAlignment(SwingConstants.CENTER);
        
        Container c = super.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(250, 250, 250));

        JPanel pCrear = new JPanel();
        pCrear.setBounds(0, 0, 300, 110);
        pCrear.setLayout(null);
        pCrear.setBackground(new Color(250, 250, 250));
        pCrear.setBorder(createTitledBorder(createLineBorder(new Color(0, 0, 0)), "CREAR VERTICE", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Comic Sans MS", 1, 14)));

        Textos txt1 = new Textos("Nombre", 30);
        JTextField nomVertise = new JTextField();
        nomVertise.setBounds(150, 30, 100, 25);
        nomVertise.addKeyListener(new Correccion(nomVertise, 15, "todos"));
        nomVertise.setHorizontalAlignment(JTextField.CENTER);
        nomVertise.setFont(new Font("Comic Sans MS", 4, 14));
        JButton btnCrearVert = new JButton("Crear vertice");
        btnCrearVert.setBounds(90, 70, 120, 25);
        btnCrearVert.setFont(new Font ("Comic Sans MS", 4, 13));
        btnCrearVert.setCursor(new Cursor(Cursor.HAND_CURSOR));

        pCrear.add(txt1);
        pCrear.add(nomVertise);
        pCrear.add(btnCrearVert);

        JPanel pEliminar = new JPanel();
        pEliminar.setBounds(0, 110, 300, 110);
        pEliminar.setLayout(null);
        pEliminar.setBackground(new Color(240, 240, 240));
        pEliminar.setBorder(createTitledBorder(createLineBorder(new Color(0, 0, 0)), "ELIMINAR VERTICE", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Comic Sans MS", 1, 14)));

        Textos txt4 = new Textos("Nombre", 30);
        JComboBox vertElimi = new JComboBox();
        vertElimi.setBounds(150, 30, 100, 25);
        vertElimi.setFont(new Font("Comic Sans MS", 4, 14));
        vertElimi.setRenderer(a);
        JButton btnEliminarVert = new JButton("Eliminar vertice");
        btnEliminarVert.setBounds(85, 70, 130, 25);
        btnEliminarVert.setFont(new Font ("Comic Sans MS", 4, 13));
        btnEliminarVert.setCursor(new Cursor(Cursor.HAND_CURSOR));

        pEliminar.add(txt4);
        pEliminar.add(vertElimi);
        pEliminar.add(btnEliminarVert);

        JPanel pRela = new JPanel();
        pRela.setBounds(0, 220, 300, 110);
        pRela.setLayout(null);
        pRela.setBackground(new Color(250, 250, 250));
        pRela.setBorder(createTitledBorder(createLineBorder(new Color(0, 0, 0)), "CREAR RELACION", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Comic Sans MS", 1, 14)));

        Textos txt2 = new Textos("De", 0, 30, 40);
        JComboBox inicio = new JComboBox();
        inicio.setBounds(40, 30, 100, 25);
        inicio.setFont(new Font("Comic Sans MS", 4, 14));
        inicio.setRenderer(a);
        inicio.setName("inicio");
        Textos txt3 = new Textos("A", 130, 30, 50);
        JComboBox fin = new JComboBox();
        fin.setBounds(170, 30, 100, 25);
        fin.setFont(new Font("Comic Sans MS", 4, 14));
        fin.setRenderer(a);
        Textos txt9 = new Textos("Peso", 5, 70, 40);
        JTextField peso = new JTextField();
        peso.setBounds(50, 75, 50, 25);
        peso.addKeyListener(new Correccion(peso, 2, "numeros"));
        peso.setHorizontalAlignment(JTextField.CENTER);
        peso.setFont(new Font("Comic Sans MS", 4, 14));
        JButton btnCrearRela = new JButton("Crear relacion");
        btnCrearRela.setBounds(145, 70, 130, 25);
        btnCrearRela.setFont(new Font ("Comic Sans MS", 4, 13));
        btnCrearRela.setCursor(new Cursor(Cursor.HAND_CURSOR));

        pRela.add(peso);
        pRela.add(txt9);
        pRela.add(txt2);
        pRela.add(inicio);
        pRela.add(txt3);
        pRela.add(fin);
        pRela.add(btnCrearRela);

        JPanel pRelaElimi = new JPanel();
        pRelaElimi.setBounds(0, 330, 300, 110);
        pRelaElimi.setLayout(null);
        pRelaElimi.setBackground(new Color(240, 240, 240));
        pRelaElimi.setBorder(createTitledBorder(createLineBorder(new Color(0, 0, 0)), "ELIMINAR RELACION", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Comic Sans MS", 1, 14)));

        Textos txt5 = new Textos("De", 0, 30, 40);
        JComboBox inicioElimi = new JComboBox();
        inicioElimi.setBounds(40, 30, 100, 25);
        inicioElimi.setFont(new Font("Comic Sans MS", 4, 14));
        inicioElimi.setRenderer(a);
        inicioElimi.setName("inicioElimi");
        Textos txt6 = new Textos("A", 130, 30, 50);
        JComboBox finElimi = new JComboBox();
        finElimi.setBounds(170, 30, 100, 25);
        finElimi.setFont(new Font("Comic Sans MS", 4, 14));
        finElimi.setRenderer(a);
        JButton btnEliminarRela = new JButton("Eliminar relacion");
        btnEliminarRela.setBounds(85, 70, 140, 25);
        btnEliminarRela.setFont(new Font ("Comic Sans MS", 4, 13));
        btnEliminarRela.setCursor(new Cursor(Cursor.HAND_CURSOR));

        pRelaElimi.add(txt5);
        pRelaElimi.add(inicioElimi);
        pRelaElimi.add(txt6);
        pRelaElimi.add(finElimi);
        pRelaElimi.add(btnEliminarRela);

        JPanel pCaminoCorto = new JPanel();
        pCaminoCorto.setBounds(0, 440, 300, 360);
        pCaminoCorto.setLayout(null);
        pCaminoCorto.setBackground(new Color(250, 250, 250));
        pCaminoCorto.setBorder(createTitledBorder(createLineBorder(new Color(0, 0, 0)), "CAMINO MAS CORTO", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Comic Sans MS", 1, 14)));

        Textos txt7 = new Textos("De", 0, 30, 40);
        JComboBox inicioCamino = new JComboBox();
        inicioCamino.setBounds(40, 30, 100, 25);
        inicioCamino.setFont(new Font("Comic Sans MS", 4, 14));
        inicioCamino.setRenderer(a);
        inicioCamino.setName("inicioCamino");
        Textos txt8 = new Textos("A", 130, 30, 50);
        JComboBox finCamino = new JComboBox();
        finCamino.setBounds(170, 30, 100, 25);
        finCamino.setRenderer(a);
        finCamino.setFont(new Font("Comic Sans MS", 4, 14));
        JButton btnBuscarCamino = new JButton("Calcular");
        btnBuscarCamino.setBounds(90, 70, 120, 25);
        btnBuscarCamino.setFont(new Font ("Comic Sans MS", 4, 13));
        btnBuscarCamino.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JPanel pPeso = new JPanel();
        pPeso.setBounds(4, 110, 292, 60);
        pPeso.setLayout(null);
        pPeso.setBackground(new Color(250, 250, 250));
        pPeso.setBorder(createTitledBorder(createLineBorder(new Color(0, 0, 0)), "PESO DEL CAMINO", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Comic Sans MS", 1, 14)));

        JLabel pes = new JLabel("0");
        pes.setBounds(0, 20, 292, 30);
        pes.setFont(new Font("Comic Sans MS", 1, 16));
        pes.setHorizontalAlignment(JLabel.CENTER);

        pPeso.add(pes);

        JPanel pCamino = new JPanel();
        pCamino.setBounds(4, 170, 292, 185);
        pCamino.setLayout(null);
        pCamino.setBackground(new Color(250, 250, 250));
        pCamino.setBorder(createTitledBorder(createLineBorder(new Color(0, 0, 0)), "CAMINO", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Comic Sans MS", 1, 14)));

        pCaminoCorto.add(pPeso);
        pCaminoCorto.add(pCamino);
        pCaminoCorto.add(txt7);
        pCaminoCorto.add(inicioCamino);
        pCaminoCorto.add(txt8);
        pCaminoCorto.add(finCamino);
        pCaminoCorto.add(btnBuscarCamino);

        Lienzo pGraf = new Lienzo();

        JPanel pInfo = new JPanel();
        pInfo.setBounds(300, 550, 550, 250);
        pInfo.setLayout(null);
        pInfo.setBackground(new Color(240, 240, 240));
        pInfo.setBorder(createTitledBorder(createLineBorder(new Color(0, 0, 0)), "MATRIZ DE PESOS", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Comic Sans MS", 1, 14)));

        JTable tabla = new JTable();
        tabla.setLocation(10, 50);
        tabla.setEnabled(false);
        tabla.setFont(new Font("Comic Sans MS", 4, 12));
        tabla.setSelectionBackground(Color.lightGray);
        DefaultTableModel model = new DefaultTableModel(1, 1);
        tabla.setModel(model);

        pInfo.add(tabla);

        JPanel pInfo2 = new JPanel();
        pInfo2.setBounds(850, 550, 550, 250);
        pInfo2.setLayout(null);
        pInfo2.setBackground(new Color(240, 240, 240));
        pInfo2.setBorder(createTitledBorder(createLineBorder(new Color(0, 0, 0)), "MATRIZ DE ACCESO", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Comic Sans MS", 1, 14)));

        JTable tabla2 = new JTable();
        tabla2.setLocation(10, 50);
        tabla2.setEnabled(false);
        tabla2.setFont(new Font("Comic Sans MS", 4, 12));
        tabla2.setSelectionBackground(Color.lightGray);
        DefaultTableModel model2 = new DefaultTableModel(1, 1);
        tabla2.setModel(model2);

        pInfo2.add(tabla2);

        super.add(pInfo2);
        super.add(pInfo);
        super.add(pGraf);
        super.add(pCrear);
        super.add(pRela);
        super.add(pEliminar);
        super.add(pRelaElimi);
        super.add(pCaminoCorto);

        //=========================== ACCIONES ===============================================
        JComboBox[] boxs = {inicio, inicioCamino, inicioElimi, vertElimi, fin, finCamino, finElimi};
        JComboBox[] boxs2 = {inicio, inicioCamino, inicioElimi, vertElimi};

        btnCrearVert.addActionListener(new crearVertise(pGraf, nomVertise, boxs2, grafo, tabla, tabla2, btnCrearVert));
        btnEliminarVert.addActionListener(new eliminarVertise(pGraf, vertElimi, boxs, grafo, tabla, tabla2, btnCrearVert));
        inicio.addActionListener(new Completar(pGraf, inicio, fin, grafo));
        inicioCamino.addActionListener(new Completar(pGraf, inicioCamino, finCamino, grafo));
        inicioElimi.addActionListener(new Completar(pGraf, inicioElimi, finElimi, grafo));
        btnCrearRela.addActionListener(new crearRelacion(grafo, tabla, tabla2, inicio, fin, peso, pGraf));
        btnEliminarRela.addActionListener(new eliminarRelacion(grafo, tabla, tabla2, inicioElimi, finElimi, pGraf));
        btnBuscarCamino.addActionListener(new caminoCorto(pes, pCamino, inicioCamino, finCamino, grafo, pGraf));
    }
    
}
