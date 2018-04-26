/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

/**
 *
 * @author JORGE
 */
public class Dijkstra {
    
    public Object[] distancia;
    public int[][] matrizPesos;

    public Dijkstra(int[][] matrizPesos) {
        this.matrizPesos=matrizPesos;
        this.distancia=new Object[matrizPesos.length+1];
        String [] prr=new String[2];
        prr[0]=""+0;
        prr[1]="prr";
        this.distancia[this.distancia.length-1]=prr;
    }

    public String[] getDistancia(int a) {
        String [] dato=(String [])this.distancia[a];
        return dato;
    }
    public void calcular(int origen)
    {
        int cantNodos=this.matrizPesos.length;
        int[] flag=new int[cantNodos+1];
        int i;
        int k;
        int c;
        int minimo;
        int minPos=1;
        
        for(i=0;i<cantNodos;i++)
        {
            flag[i]=0;
            String [] dato=new String[2];
            dato[0]=""+this.matrizPesos[origen][i];
            dato[1]=(origen+1)+"-"+(i+1);
            this.distancia[i]=dato;
        }
        c=2;
        while(c<=cantNodos)
        {
            minimo=99;
            for (k = 0; k < cantNodos; k++) 
            {
                String [] dato;
                dato=(String [])this.distancia[k];
                if((Integer.parseInt(dato[0])<minimo) & (flag[k]!=1))
                {
                    dato=(String [])this.distancia[k];
                    minimo=Integer.parseInt(dato[0]);
                    minPos=k;
                    
                }
            }
            flag[minPos]=1;
            c++;
            for (k = 0; k < cantNodos; k++) 
            {
                String [] dato=(String [])this.distancia[minPos];
                String [] dato2=(String [])this.distancia[k];
                if(Integer.parseInt(dato[0])+this.matrizPesos[minPos][k] < Integer.parseInt(dato2[0]) & flag[k]!=1)
                {
                    String [] nDato=new String[2];
                    nDato[0]=""+(Integer.parseInt(dato[0])+this.matrizPesos[minPos][k]);
                    nDato[1]=(dato[1])+"-"+(k+1);
                    this.distancia[k]=nDato;
                }
            }
           
        }
        
        
    }
    
}
