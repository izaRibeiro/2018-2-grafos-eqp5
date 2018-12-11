/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import model.Grafo;
import model.Vertice;
import model.Aresta;

/**
 *
 * @author Iza Ribeiro
 */
public class MatrizDeIncidencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /* Grafo G1*/
        
        Vertice v1 = new Vertice("v1");
        Vertice v2 = new Vertice("v2");
        Vertice v3 = new Vertice("v3");
        Aresta a1 = new Aresta("a1",v1, v2);
        Aresta a2 = new Aresta("a2",v2, v3);
        Aresta a3 = new Aresta("a3",v1, v2);
        
        
        Grafo g1 = new Grafo("g1");
        g1.adicionarAresta(a1);
        g1.adicionarAresta(a2);
        g1.adicionarAresta(a3);
        g1.adicionarVertice(v1);
        g1.adicionarVertice(v2);
        g1.adicionarVertice(v3);       
        g1.criaMatrizOrientada();
         g1.grau();
        g1.numOrdem();
        g1.isCompleto();
  
      
       
        
        /* Grafo G2*/
       
        Vertice v6 = new Vertice("v6");
        Vertice v7 = new Vertice("v7");
        Vertice v8 = new Vertice("v8");
        Aresta a6 = new Aresta("a6",20,v6, v7);
        Aresta a7 = new Aresta("a7",10,v7, v8);
        Aresta a8 = new Aresta("a8",7,v6, v8);
        
        
        Grafo g2 = new Grafo("g2");
        g2.adicionarAresta(a6);
        g2.adicionarAresta(a7);
        g2.adicionarAresta(a8);
        g2.adicionarVertice(v6);
        g2.adicionarVertice(v7);
        g2.adicionarVertice(v8);       
     
        g2.criaMatrizNaoOrientada();
        g2.grau();
        g2.numOrdem(); /* Ordem do grau */
        g2.isCompleto();
        
        System.out.println("Valor da aresta 6: "+a6.getPeso());
        System.out.println("Valor da aresta 7: "+a7.getPeso());
        System.out.println("Valor da aresta 8: "+a8.getPeso());
    }
    
}
