package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Grafo {

    Scanner scanner = new Scanner(System.in);

    private String id;
    private ArrayList<Vertice> vertices;
    private ArrayList<Aresta> arestas;
    private boolean regular = false;
    
    String[][] matrizIncidencia;
    String[][] matrizaux;
    
    private boolean eOrientado;

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

    public Grafo(String id, boolean eOrientado) {
        this.id = id;
        this.eOrientado = eOrientado;
        this.vertices = new ArrayList<Vertice>();
        this.arestas = new ArrayList<Aresta>();
    }
    
    

    public void setRegular() {
        if (vertices.size() > 0) {
            int aux = vertices.get(0).relacionamento.size();
            for (Vertice vertice : vertices) {
                if (aux != vertice.relacionamento.size()) {
                    this.regular = false;
                    return;
                }
            }

            this.regular = true;
            System.out.println("É regular");

        } else {
            this.regular = false;
            System.out.println("Não é regular");

        }
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
                if (vertices.get(i).equals(arestas.get(j).getInicio())) {
                    matrizIncidencia[i][j] = "1";
                } else if (vertices.get(i).equals(arestas.get(j).getFim())) {
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
                if (vertices.get(i).equals(arestas.get(j).getInicio())) {
                    matrizIncidencia[i][j] = "1";
                } else if (vertices.get(i).equals(arestas.get(j).getFim())) {
                    matrizIncidencia[i][j] = "-1";
                } else {
                    matrizIncidencia[i][j] = "0";
                }

            }
        }

        return matrizIncidencia;
    }

    public void imprimir(Grafo g) {
        int i = 0;
        int j = 0;
        if(g.eOrientado == true){
            criaMatrizOrientada();
        }else{
            criaMatrizNaoOrientada();
        }
        String aresta = "\t";

        for (j = 0; j < arestas.size(); j++) {
            System.out.print("\tA" + (j + 1));
        }

        for (i = 0; i < vertices.size(); i++) {
            System.out.println("\n");
            System.out.print("V" + (i + 1) + "\t");
            for (j = 0; j < arestas.size(); j++) {
                /*System.out.print(getMatrizIncidencia() + "\t");*/
                System.out.print(getValorMatriz(i, j)+ "\t");
            }
        }

        System.out.println("\n\n");
        
        
        
    }
    
     public void imprimirNaoOrientado() {
        int i = 0;
        int j = 0;
        criaMatrizNaoOrientada();
        String aresta = "\t";

        for (j = 0; j < arestas.size(); j++) {
            System.out.print("\tA" + (j + 1));
        }

        for (i = 0; i < vertices.size(); i++) {
            System.out.println("\n");
            System.out.print("V" + (i + 1) + "\t");
            for (j = 0; j < arestas.size(); j++) {
                /*System.out.print(getMatrizIncidencia() + "\t");*/
                System.out.print(getValorMatriz(i, j)+ "\t");
            }
        }

        System.out.println("\n\n");
        
    }
     
      public void imprimirOrientado() {
        int i = 0;
        int j = 0;
        criaMatrizOrientada();
        String aresta = "\t";

        for (j = 0; j < arestas.size(); j++) {
            System.out.print("\tA" + (j + 1));
        }

        for (i = 0; i < vertices.size(); i++) {
            System.out.println("\n");
            System.out.print("V" + (i + 1) + "\t");
            for (j = 0; j < arestas.size(); j++) {
                /*System.out.print(getMatrizIncidencia() + "\t");*/
                System.out.print(getValorMatriz(i, j)+ "\t");
            }
        }

        System.out.println("\n\n");
        
    }

    public void removeAresta() {
        System.out.printf("Digite o número da aresta que deseja remover: ");
        int aresta = scanner.nextInt();
        int aux = 0;

        matrizaux = new String[vertices.size()][arestas.size()];

        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < arestas.size(); j++) {
                if (aux == 0) {
                    if (j != aresta - 1) {

                    } else {
                        aux = 1;
                        arestas.remove(j);
                    }
                }
            }
        }
    }

    public void removeVertice() {
        System.out.printf("Digite o número da aresta que deseja remover: ");
        int aresta = scanner.nextInt();
        int aux = 0;

        matrizaux = new String[vertices.size()][arestas.size()];

        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < arestas.size(); j++) {
                if (aux == 0) {
                    if (j != aresta - 1) {

                    } else {
                        aux = 1;
                        vertices.remove(i);
                        arestas.remove(j);
                    }
                }
            }

        }

    }

    public void adicionaAresta(Aresta a) {
        arestas.add(a);
    }

    public void adicionaVertice(Vertice v) {
        vertices.add(v);
    }

    public int ordem() {
        return vertices.size();
    }

    public int numOrdem() {
        System.out.println("Grafo de ordem: " + vertices.size());
        return vertices.size();
    }

    public void grau() {
        int aux = 0;
        for (Vertice vertice : vertices) {
            aux = 0;
            for (int i = 0; i < arestas.size(); i++) {
                if (arestas.get(i).getInicio() == vertice) {
                    aux++;
                }
                if (arestas.get(i).getFim() == vertice) {
                    aux++;
                }
            }
            System.out.println(vertice.getId() + " Grau: " + aux);
        }
    }

    public int grauVertice(Vertice vertice) {
        int aux = 0;
        for (int i = 0; i < arestas.size(); i++) {
            if (arestas.get(i).getInicio() == vertice) {
                aux++;
            }
            if (arestas.get(i).getFim() == vertice) {
                aux++;
            }
        }
        return aux;
    }

    /**
     *
     * @return grau da regularidade
     */
    public int isRegular() {
        int grau = -1;
        for (Vertice vertice : vertices) {
            if (grau == -1) {
                grau = grauVertice(vertice);

            } else if (grau != grauVertice(vertice)) {
                System.out.println("Não é regular");
                return 0;
            }

        }
        System.out.println("É regular");

        return grau;
    }

    /**
     *
     * @return ordem do grafo
     */
    public int isCompleto() {
        if (isRegular() == ordem() - 1) {
            System.out.println("É completo");
            return ordem();
        } else {
            System.out.println("Não é completo");
            return 0;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vertice getVertice(int v) {
            int i = 0;
            int j = 0;
            for (i = 0; i < vertices.size(); i++) {
            for (j = 0; j < arestas.size(); j++) {
                    if (i == v) {
                            return vertices.get(i);
                    } 

                }
            }

        return vertices.get(v);
        
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

    public String getValorMatriz(int i, int j) {
        return matrizIncidencia[i][j];
    }
    
    public int getTamanho(){
        return vertices.size();
    }

    public boolean iseOrientado() {
        return eOrientado;
    }

    public void seteOrientado(boolean eOrientado) {
        this.eOrientado = eOrientado;
    }

}
