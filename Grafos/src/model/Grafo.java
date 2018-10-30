package model;

import java.util.ArrayList;

public class Grafo {

    private String id;
    private ArrayList<Vertice> vertices;
    private ArrayList<Aresta> arestas;
    String[][] matrizIncidencia;

    public Grafo(ArrayList<Vertice> vertices, ArrayList<Aresta> arestas) {
        this.vertices = vertices;
        this.arestas = arestas;
    }

    public Grafo(String id) {
        this.id = id;
        vertices = new ArrayList<Vertice>();
        arestas = new ArrayList<Aresta>();
    }

    public Grafo(String id, ArrayList<Vertice> vertices, ArrayList<Aresta> arestas) {
        this.id = id;
        this.vertices = vertices;
        this.arestas = arestas;
    }

    public Grafo() {
    }

    
    public void adicionarVertice(Vertice v) {
        vertices.add(v);
    }

    public void adicionarAresta(Aresta a) {
        arestas.add(a);
    }

    public String[][] criaMatrizNaoOrientada() {
        int i = 0;
        int j = 0;
        
        matrizIncidencia = new String[vertices.size()][arestas.size()];

        for (i = 0; i < vertices.size(); i++) {
            for (j = 0; j < arestas.size(); j++) {
                    if (vertices.get(i).getId().equals(arestas.get(j).getInicio().getId())) {
                        matrizIncidencia[i][j] = "1";
                    } else if (vertices.get(i).getId().equals(arestas.get(j).getFim().getId())) {
                        matrizIncidencia[i][j] = "1";
                    } else {
                        matrizIncidencia[i][j] = "0";
                    }

                }
            }
           

        return matrizIncidencia;
    }
    
    public String[][] criaMatrizOrientada() {
        int i = 0;
        int j = 0;
        
        matrizIncidencia = new String[vertices.size()][arestas.size()];

        for (i = 0; i < vertices.size(); i++) {
            for (j = 0; j < arestas.size(); j++) {
                    if (vertices.get(i).getId().equals(arestas.get(j).getInicio().getId())) {
                        matrizIncidencia[i][j] = "1";
                    } else if (vertices.get(i).getId().equals(arestas.get(j).getFim().getId())) {
                        matrizIncidencia[i][j] = "-1";
                    } else {
                        matrizIncidencia[i][j] = "0";
                    }

                }
            }
           

        return matrizIncidencia;
    }

    public void imprimir() {
        int i = 0;
        int j = 0;
        String aresta = "\t";
        
        for (j = 0; j < arestas.size(); j++) {
            System.out.print("\tA"+ (j+1));
        }
       
        for (i = 0; i < vertices.size(); i++) {
            System.out.println("\n");
            System.out.print("V"+ (i+1) +"\t");
            for (j = 0; j < arestas.size(); j++) {
                System.out.print(getValorMatriz(i, j)+"\t");
            }
        }     
        
        System.out.println("\n\n");
    }
    
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(ArrayList<Aresta> arestas) {
        this.arestas = arestas;
    }

    public String[][] getMatrizIncidencia() {
        return matrizIncidencia;
    }

    public void setMatrizIncidencia(String[][] matrizIncidencia) {
        this.matrizIncidencia = matrizIncidencia;
    }

    public String getValorMatriz(int i, int j){
        return matrizIncidencia[i][j];
    }
}
