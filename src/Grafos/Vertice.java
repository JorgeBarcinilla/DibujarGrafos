/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class Vertice {
    
    private Object datos;
    private String nombre;
    private final List<String[]> acceso;

    public Vertice(String nombre) {
        this.datos = null;
        this.nombre=nombre;
        this.acceso=new ArrayList();
    }
    
    public Vertice(String nombre,Object dato) {
        this.datos = dato;
        this.nombre=nombre;
        this.acceso=new ArrayList();
    }

    public List<String[]> obtenerAcceso() {
        return acceso;
    }

    
    public void cambiarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public void insertarDatos(Object datos) {
        this.datos = datos;
    }

   

    public void crearAcceso(String nombre,String peso )
    {
        String [] dato=new String [2];
        dato[0]=nombre;
        dato[1]=peso;
        this.acceso.add(dato);
    }
    public void eliminarAcceso(String nombre)
    {
        for(int i=0;i<this.acceso.size();i++)
        {
            if(nombre.equals(this.acceso.get(i)[0]))
            {
                this.acceso.remove(i);
            }
        }
    }
    public void actualizarAcceso(String nombre,String peso)
    {
        for(int i=0;i<this.acceso.size();i++)
        {
            if(nombre.equals(this.acceso.get(i)[0]))
            {
                this.acceso.get(i)[1]=peso;
            }
        }
        
    }
    
    public void verAccesos()
    {
        for(int i=0;i<this.acceso.size();i++)
        {
            System.out.print("["+this.acceso.get(i)[0]+"-"+this.acceso.get(i)[1]+"]");
        }
    }
    
   
    public Object ObtenerDatos()
    {
        return datos;
    }
    
   
}
