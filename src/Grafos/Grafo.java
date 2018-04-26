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
public class Grafo {
    
   private final List<Vertice> Vertices;
   private int[][] matriz;
   
   public Grafo()
   {
       this.Vertices=new ArrayList();
   }
   
   public int ObtenerTamaño()
   {
       return this.Vertices.size();
   }

    public Vertice obtenerVertice(int index) {
        
        return this.Vertices.get(index);
    }
   
   public Object ObtenerDato(String nombre)
   {
       Object dato=null;
       for(int i=0;i<this.Vertices.size();i++)
        {
            if(this.Vertices.get(i).obtenerNombre().equals(nombre))
            {
                dato=this.Vertices.get(i).ObtenerDatos();
            }
        }
       return dato;
   }
   
   public void eliminarVertice(String nombre)
   {
       for(int i=0;i<this.Vertices.size();i++)
        {
            this.Vertices.get(i).eliminarAcceso(nombre);
            if(this.Vertices.get(i).obtenerNombre().equals(nombre))
            {
                this.Vertices.remove(i);
                
            }
            
        }
       int[][] mat = new int[this.Vertices.size()][this.Vertices.size()];

        for (int i = 0; i < this.Vertices.size(); i++) {
            for (int j = 0; j < this.Vertices.size(); j++) 
            {
                mat[i][j] = Integer.parseInt(this.Vertices.get(i).obtenerAcceso().get(j)[1]);
            }
        }
        this.matriz=mat;
       
   }
   public void añadirVertice(String nombre)
   {
       Vertice vert=new Vertice(nombre);
       this.Vertices.add(vert);
       for(int i=0;i<this.Vertices.size();i++)
        {
            int num=999;
            if(this.Vertices.get(i).obtenerNombre().equals(vert.obtenerNombre()))
            {
                num=0;
            }
            if(!this.Vertices.get(i).obtenerNombre().equals(vert.obtenerNombre()))
            {
                vert.crearAcceso(this.Vertices.get(i).obtenerNombre(), "" + 999);
            }
            this.Vertices.get(i).crearAcceso(vert.obtenerNombre(), "" + num);
            
        }
       int[][] mat = new int[this.Vertices.size()][this.Vertices.size()];

        for (int i = 0; i < this.Vertices.size(); i++) {
            for (int j = 0; j < this.Vertices.size(); j++) 
            {
                mat[i][j] = Integer.parseInt(this.Vertices.get(i).obtenerAcceso().get(j)[1]);
            }
        }
        this.matriz=mat;
       
   }
   
   public void crearArista(String inicio,String llegada,int peso)
    {
        
        for(int i=0;i<this.Vertices.size();i++)
        {
            if(this.Vertices.get(i).obtenerNombre().equals(llegada))
            {
                for (int j = 0; j < this.Vertices.size(); j++) 
                {
                    if (this.Vertices.get(j).obtenerNombre().equals(inicio)) 
                    {
                        this.Vertices.get(j).actualizarAcceso(this.Vertices.get(i).obtenerNombre(),""+peso);
                    }
                }
            }
        }
        
        int[][] mat = new int[this.Vertices.size()][this.Vertices.size()];

        for (int i = 0; i < this.Vertices.size(); i++) {
            for (int j = 0; j < this.Vertices.size(); j++) 
            {
                mat[i][j] = Integer.parseInt(this.Vertices.get(i).obtenerAcceso().get(j)[1]);
            }
        }
        this.matriz=mat;
    }
   
   public void matrizAcceso()
   {
      for(int i=0;i<this.Vertices.size();i++)
        {
            System.out.print(this.Vertices.get(i).obtenerNombre()+" = ");this.Vertices.get(i).verAccesos();
            System.out.println();
        } 
   }
  
   public void eliminarArista(String inicio,String llegada)
   {
       for(int i=0;i<this.Vertices.size();i++)
        {
            if(this.Vertices.get(i).obtenerNombre().equals(llegada))
            {
                for (int j = 0; j < this.Vertices.size(); j++) 
                {
                    if (this.Vertices.get(j).obtenerNombre().equals(inicio)) 
                    {
                        this.Vertices.get(j).actualizarAcceso(this.Vertices.get(i).obtenerNombre(),""+999);
                    }
                }
            }
        }
       int[][] mat = new int[this.Vertices.size()][this.Vertices.size()];

        for (int i = 0; i < this.Vertices.size(); i++) {
            for (int j = 0; j < this.Vertices.size(); j++) 
            {
                mat[i][j] = Integer.parseInt(this.Vertices.get(i).obtenerAcceso().get(j)[1]);
            }
        }
        this.matriz=mat;
   }
   
   public void insertarDatos(String nombre,Object datos)
   {
       for (int i = 0; i < this.Vertices.size(); i++) 
       {
           if(this.Vertices.get(i).obtenerNombre().equals(nombre))
           {
               this.Vertices.get(i).insertarDatos(datos);
           }
       }
   }
   
   public String[] caminoCorto(String inicio,String fin)
   {
       String[] camin={};
       
       for(int i=0;i<this.Vertices.size();i++)
        {
            if(this.Vertices.get(i).obtenerNombre().equals(fin))
            {
                for (int j = 0; j < this.Vertices.size(); j++) 
                {
                    if (this.Vertices.get(j).obtenerNombre().equals(inicio)) 
                    {
                        Dijkstra camino=new Dijkstra(this.matriz);
                        camino.calcular(j);
                        camin=camino.getDistancia(i);
                    }
                    
                }
            }
            
        }
       return camin;
   }
  
   
}
