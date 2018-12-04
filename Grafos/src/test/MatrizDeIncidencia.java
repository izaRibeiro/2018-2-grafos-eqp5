/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import model.Grafo;
import model.Vertice;
import model.Aresta;
import edu.ifet.grafos.graphview.GraphView;
import java.io.File;

import java.util.ArrayList;

/**
 *
 * @author Iza Ribeiro
 */
public class MatrizDeIncidencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vertice v1 = new Vertice("v1");
        Vertice v2 = new Vertice("v2");
        Vertice v3 = new Vertice("v3");
        Aresta a1 = new Aresta("a1",v1, v2);
        Aresta a2 = new Aresta("a2",v2, v3);
        Aresta a3 = new Aresta("a3",v1, v3);
        
        Grafo g1 = new Grafo("g1");
        g1.adicionarAresta(a1);
        g1.adicionarAresta(a2);
        g1.adicionarAresta(a3);
        g1.adicionarVertice(v1);
        g1.adicionarVertice(v2);
        g1.adicionarVertice(v3);       
        g1.criaMatrizOrientada();
        g1.imprimir();
        
        g1.criaMatrizNaoOrientada();
        g1.imprimir();
        /*
        g1.removeAresta();
        g1.imprimir();
        */
        
        /*
        g1.removeVertice();
        g1.imprimir();
        */
        
        
        Aresta a4 = new Aresta("a4",v2, v1);
        g1.adicionaAresta(a4);
        g1.imprimir();
        g1.ordem();
        
        /*
        Vertice v4 = new Vertice("v4");
        g1.adicionaVertice(v4);
        g1.imprimir();
        */
        
    }
    
}
