/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author luisg
 */

public class Dijkstra {
         private Grafo grafo;
    private HashMap<String, Float> distancias;

    public Dijkstra(Grafo grafo) {
        this.grafo = grafo;
        this.distancias = new HashMap();
    }

    public Dijkstra() {

    }

    private double calcularDistancia(String inicioId, String alvoId) {
        int i;
        for (i = 0; i < this.grafo.getArestas().size(); i++) {
            if (this.grafo.iseOrientado()) {
                if (this.grafo.getArestas().get(i).getInicio().getId().equals(inicioId) && this.grafo.getArestas().get(i).getFim().getId().equals(alvoId)) {
                    return this.grafo.getArestas().get(i).getPeso();
                }
            } else if ((this.grafo.getArestas().get(i).getInicio().getId().equals(inicioId) && this.grafo.getArestas().get(i).getFim().getId().equals(alvoId))
                    || (this.grafo.getArestas().get(i).getInicio().getId().equals(alvoId) && this.grafo.getArestas().get(i).getFim().getId().equals(inicioId))) {
                return this.grafo.getArestas().get(i).getPeso();
            }
        }
        return Float.MAX_VALUE;
    }

    public void buscarCaminhos(Vertice origem) {
        ArrayList<Vertice> nosJaVisitados = new ArrayList();
        int index = this.grafo.getVerticeIndice(origem.getId());

        for (int j = 0; j < this.grafo.getVertices().size(); j++) {
            this.distancias.put(grafo.getVertices().get(j).getId(), Float.MAX_VALUE);
        }
        System.out.println(index);
        if (index != -1) {
            this.distancias.put(this.grafo.getVertices().get(index).getId(), 0F);
            nosJaVisitados.add(this.grafo.getVertices().get(index));
            visitarTodosNos(this.grafo.getVertices().get(index).getId(), 0, nosJaVisitados);
        }
    }

    private void visitarTodosNos(String noId, float distanciaAnterior, ArrayList<Vertice> nosJaVisitados) {

        ArrayList<Vertice> alcancaveis;
        int indice, i;
        indice = this.grafo.getVerticeIndice(noId);
        alcancaveis = this.grafo.getVerticeAdjacentes(this.grafo.getVertices().get(indice));
        alcancaveis.removeAll(nosJaVisitados);

        for (i = 0; i < alcancaveis.size(); i++) {
            double distancia = calcularDistancia(noId, alcancaveis.get(i).getId());
                float dis = (float) distancia;
            if (distancia + distanciaAnterior < this.distancias.get(alcancaveis.get(i).getId())) {
                this.distancias.put(alcancaveis.get(i).getId(), dis + distanciaAnterior);
            }
        }

        for (i = 0; i < alcancaveis.size(); i++) {
            nosJaVisitados.add(alcancaveis.get(i));
            visitarTodosNos(alcancaveis.get(i).getId(), this.distancias.get(alcancaveis.get(i).getId()), nosJaVisitados);
            nosJaVisitados.remove(alcancaveis.get(i));
        }
    }

    public float menorDistancia(Vertice destino) {
        if (this.distancias.get(destino.getId()) != null) {
            return this.distancias.get(destino.getId());
        } else {
            return -1;
        }
    }

    public Grafo getGrafo() {
        return this.grafo;
    }

}
