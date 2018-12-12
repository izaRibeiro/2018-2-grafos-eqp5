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
  
    public static Grafo importaGrafoDot(String graphDot){
        Grafo grafo = new Grafo();
        Aresta aresta;
     if (graphDot.contains("digraph")) {
            grafo.seteOrientado(true);
        } else {
            grafo.seteOrientado(false);
        }
      int i;
        String aux, aux2;
        String[] arrayAux;
        String[] arrayGrafo = graphDot.split("\\{\n");

        //pegando o nome do grafo pelo espaço entre o tipo do grafo e o nome
        grafo.setId(arrayGrafo[0].split(" ")[1]);

        //filtrando os vértices
        arrayAux = arrayGrafo[1].split(";\n ")[0].split(";\n");

        for (i = 0; i < arrayAux.length; i++) {
            grafo.adicionaVertice(arrayAux[i]);
        }

        arrayGrafo = arrayGrafo[1].split(";\n ");

        arrayAux = arrayGrafo[1].split("];\n\n ");

        if (grafo.iseOrientado()) {
            aux = "->";
        } else {
            aux = "--";
        }

        for (i = 0; i < arrayAux.length - 1; i++) {
            Vertice origem = new Vertice(arrayAux[i].split(aux)[0].trim());
            Vertice destino = new Vertice(arrayAux[i].split(aux)[1].split("\\[")[0].trim());

            aresta = new Aresta(origem, destino);
            aresta.setId(arrayAux[i].split("name = \"")[1].split("\"")[0]);
            if (arrayAux[i].contains("label")) {
                aresta.setPeso(Double.parseDouble(arrayAux[i].split("label = \"")[1].split("\"")[0]));
            }
            aresta.setDirecionado(grafo.iseOrientado());
            grafo.adicionaAresta(aresta);
        }
        grafo.verificaTudo();
        return grafo;
    }
}
