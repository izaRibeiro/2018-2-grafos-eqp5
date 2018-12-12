package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Grafo {

    Scanner scanner = new Scanner(System.in);

    private String id;
    private ArrayList<Vertice> vertices;
    private ArrayList<Aresta> arestas;
    private boolean regular = false;
    private boolean valorado = false;
    
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
        System.out.printf("Digite o número do vértice que deseja remover: ");
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
                    }
                }
            }

        }
        
        

    }
    
    
    public void verificaAresta(){
        int aux = 0;
                for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < arestas.size(); j++) {
                if (j != 0) {
                        aux++;
                }
                
  
            }
                 if(aux < 2){
                    arestas.remove(i);
                }
        }
  
    }

    public void adicionaAresta(Aresta a) {
        arestas.add(a);
    }
public Vertice adicionaVertice(String nome) {
        Vertice vertice = new Vertice(nome);
        vertices.add(vertice);
        return vertice;
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
            System.out.println("Vertice: "+ vertice.getId() + " Grau: " + aux);
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
                return 0;
            }

        }

        return grau;
    }

 
    
    public int isCompleto() {
        if (isRegular() == ordem() - 1) {
            return ordem();
        } else {
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
    
    public  void getInfo() {
        
        System.out.println("Nome: "+getId() );

        System.out.println("Grafo de ordem: " + ordem());

        
        System.out.printf("Quantidade de Vertices: %d\n", vertices.size());
        System.out.printf("Quantidade de arestas: %d\n", arestas.size());

           if (isRegular() > 0) {
            System.out.println("Grafo Regular");
        } else {
            System.out.println("Grafo não é regular");
        }
           
        int ordemGrafo = isCompleto();
        if (ordemGrafo > 0) {
            System.out.println("Grafo Completo K" + ordemGrafo);
        } else {
            System.out.println("Grafo não é completo");
        }
        
        System.out.println("------------------------\n");
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
 public int getVerticeIndice(String id) {
        for (int i = 0; i < this.vertices.size(); i++) {
            if (id.equals(this.vertices.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }
 public boolean isAdjacente(Vertice no1, Vertice no2) {
        for (int i = 0; i < this.arestas.size(); i++) {
                if (this.arestas.get(i).getInicio().getId().equals(no1.getId()) && this.arestas.get(i).getFim().getId().equals(no2.getId())
                        || this.arestas.get(i).getInicio().getId().equals(no2.getId()) && this.arestas.get(i).getFim().getId().equals(no1.getId())) {
                    return true;
                }
        }
        return false;
    }
  public ArrayList<Vertice> getVerticeAdjacentes(Vertice no1) {
        ArrayList<Vertice> adjacentes = new ArrayList<>();
        for (int i = 0; i < this.getVertices().size(); i++) {
            if (this.isAdjacente(no1, this.getVertices().get(i))) {
                adjacentes.add(this.getVertices().get(i));
            }
        }
        return adjacentes;
    }
  public void verificaTudo() {
        setValorado();
        setRegular();
    }
  public void setValorado() {
        if (arestas.size() > 0) {
            for (int i = 0; i < arestas.size(); i++) {
                if (arestas.get(i).getPeso() == 0) {
                    this.valorado = false;
                    return;
                }
            }
            this.valorado = true;
        } else {
            this.valorado = false;
        }

    }
}
