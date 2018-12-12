package model;

public class Aresta {

    private String id;
    private Vertice inicio;
    private Vertice fim;
    private int peso;
    private boolean direcionado;

    public Aresta(String id, Vertice inicio, Vertice fim) {
        this.setArestaInicio(inicio);
        this.setArestaFim(fim);
        this.setId(id);
    }
    
        public Aresta(Vertice inicio, Vertice fim) {
        this.setArestaInicio(inicio);
        this.setArestaFim(fim);
    }

    public Aresta(int peso, Vertice inicio, Vertice fim) {
        this.setPeso(peso);
        this.setArestaInicio(inicio);
        this.setArestaFim(fim);
    }

    public Aresta(String id, int peso, Vertice inicio, Vertice fim) {
        this.setId(id);
        this.setPeso(peso);
        this.setArestaInicio(inicio);
        this.setArestaFim(fim);
        
    }

    public Aresta() {
    }
    
    
 
    public void setArestaInicio(Vertice inicio) {
        this.inicio = inicio;
    }

    public Vertice getFim() {
        return fim;
    }

    public void setArestaFim(Vertice fim) {
        this.fim = fim;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vertice getInicio() {
        return inicio;
    }

    public void setInicio(Vertice inicio) {
        this.inicio = inicio;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Boolean getDirecionado() {
        return direcionado;
    }

    public void setDirecionado(Boolean direcionado) {
        this.direcionado = direcionado;
    }

}
