package model;


import java.util.ArrayList;

public class Vertice {

    private String id;
    private int valor;
    ArrayList<Aresta> relacionamento;


    public Vertice(String id, int valor) {
        this.setNome(id);
        this.setValor(valor);
    }
    
     public Vertice(String id) {
        this.setNome(id);
        this.relacionamento = new ArrayList<Aresta>();
       
    }

    public Vertice() {
    }
    

    public String getNome() {
        return id;
    }

    public void setNome(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public ArrayList<Aresta> getRelacionamento() {
        return relacionamento;
    }

    public void setRelacionamento(ArrayList<Aresta> relacionamento) {
        this.relacionamento = relacionamento;
    }
    
      public void adicionaRelacionamento(Aresta aresta){
        this.relacionamento.add(aresta);
    }
    
    
    
}