/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author luisg
 */
public class GrafoToDot {
    public static String exportaGrafoDot(Grafo grafo) {
        String graphDot="";
        String aux = "";
        double peso=0;
        
       if(grafo.iseOrientado()){
           graphDot = "Digraph ";
           
       }else{
           graphDot = "Graph ";
       }
       
       graphDot +=grafo.getId() + "{";
        
       for(Vertice vertice: grafo.getVertices() ){
           graphDot += "" + vertice.getNome() + ";\n";
       }
       for(Aresta aresta: grafo.getArestas()){
            peso = aresta.getPeso();
                    if (peso != 0) {
                        aux = " [label = \"" + peso + "\", name = \"" + aresta.getId() + "\" ];";

                    } else {
                        aux = " [name = \"" + aresta.getId() + "\" ];";
                    }
                    if (aresta.getDirecionado()) {
                        graphDot += " " + aresta.getInicio().getId() + " -> " + aresta.getFim().getId() + aux;
                    } else {
                        graphDot += " " + aresta.getInicio().getId() + " -- " + aresta.getFim().getId() + aux;
                    }
                    graphDot += "\n\n";
                }
       
       graphDot += " }";
          return graphDot;
    } 
  
}
