package model;

import java.io.File;
import edu.ifet.grafos.graphview.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Iza Ribeiro
 */
public class Menu {

    static Scanner scanner = new Scanner(System.in);
    private static int opcao;
    private static int idv = 0;
    private static String nomeArquivo;
    static Grafo grafo = getCriaGrafo();
    static boolean salvo;

    static int criador = 0;

    /**
     * @param args the command line arguments
     */
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int continuar = 0;

        while (continuar == 0) {
            getGrafo();
            switch (opcao) {
                case 1:
                    getGrafo();
                    break;
                default:
                    //  System.err.println("Essa opção não existe");
                    break;
            }
            System.out.println("Deseja continuar?");
            System.out.println("Continuar - 0");
            System.err.print("Sair - 1");
            continuar = scanner.nextInt();
        }
        System.out.println("Volte sempre ! :)");
    }

    private static void getGrafo() {
        int continuarOp3 = 1;

        while (continuarOp3 == 1) {

            int opGrafoMatrizIncidencia = menuMatrizIncidencia();

            switch (opGrafoMatrizIncidencia) {
                case 1:

                    int origem;
                    int destino;
                    int id = 0;

                    System.out.println("Digite o vértice de origem");
                    origem = scanner.nextInt();

                    System.out.println("Digite o vértice de destino");
                    destino = scanner.nextInt();
                    id++;

                               int opcaoValorada;

                    System.out.println("Deseja tornar a aresta valorado? Sim[1] Nao[2]");
                    opcaoValorada = scanner.nextInt();
                     int valorAresta;

                  if (opcaoValorada == 1) {
                        idv++;
                      

                        System.out.println("Digite o valor da aresta ");
                        valorAresta = scanner.nextInt();
                        Aresta aresta = new Aresta(id + "", valorAresta, grafo.getVertice(origem), grafo.getVertice(destino));
                        grafo.adicionaAresta(aresta);

                    

                    } else if (opcaoValorada == 2) {
                        idv++;
                 Aresta aresta = new Aresta(id + "", grafo.getVertice(origem), grafo.getVertice(destino));
                        grafo.adicionaAresta(aresta);
                        
                     
                    }  
                    if(opcaoValorada != 1 && opcaoValorada != 2){
                        System.out.println("ERROU!!! HAUHSAU");
                    }
            
                    break;
                case 2:

                    

                    int opcaoValorado;

                    System.out.println("Deseja tornar o vértice valorado? Sim[1] Nao[2]");
                    opcaoValorado = scanner.nextInt();

                    if (opcaoValorado == 1) {
                        idv++;
                        int valorVertice;

                        System.out.println("Digite o valor do vértice: ");
                        valorVertice = scanner.nextInt();
                        Vertice vertice = new Vertice(Integer.toString(idv), valorVertice);
                        grafo.adicionaVertice(vertice);

                    } else if (opcaoValorado == 2) {
                        idv++;
                        Vertice vertice = new Vertice(idv + "");
                        grafo.adicionaVertice(vertice);
                        
                     
                    }  
                    if(opcaoValorado != 1 && opcaoValorado != 2){
                        System.out.println("ERROU!!! HAUHSAU");
                    }

                    break;
                case 3:
                    grafo.imprimirNaoOrientado();
                    break;
                case 4:
                    grafo.imprimirOrientado();
                    break;
                case 5:
                    grafo.removeAresta();
                    break;
                case 6:
                    grafo.removeVertice();
                    break;

                case 7:
                    grafo.grau();
                    grafo.getInfo();

                    break;
                case 8:
                    grafo.imprimir(grafo);
                    break;
                case 9:
                    String g = GrafoToDot.exportaGrafoDot(grafo);
                    // Criando um objeto da classe responsável por gerar a imagem do grafo
                    GraphView gv = new GraphView();
//Lendo a String 
                    gv.readString(g);
//Imprimindo a grafo em texto
                    System.out.println(gv.getDotSource());
//Gerando uma imagem com o nome out.png 
                    File out = new File("out.png");
                    gv.writeGraphToFile(out);
                    break;
                case 10:
                    Dijkstra dijkstra = new Dijkstra(grafo);
                    System.out.println("# Dijkstra. Busca de menor caminho #");
                    System.out.print("\nOrigem [0 até " + (grafo.ordem() - 1) + "]: ");
                    String noRaiz = teclado.next();

                    int i = dijkstra.getGrafo().getVerticeIndice(noRaiz);
                    dijkstra.buscarCaminhos(dijkstra.getGrafo().getVertice(i));

                    System.out.print("\nDestino [0 até " + (grafo.ordem() - 1) + "]: ");
                    String noMenor = teclado.next();
                    int j = dijkstra.getGrafo().getVerticeIndice("n" + noMenor);

                    double menor = dijkstra.menorDistancia(dijkstra.getGrafo().getVertices().get(j));
                    if (menor == Float.MAX_VALUE) {
                        System.out.println("infinito");
                    } else {
                        System.out.println("O menor caminho é: " + Double.toString(menor));
                    }
                    break;
                case 11:
                    JFileChooser chooser = new JFileChooser();
                    FileNameExtensionFilter dotFilter = new FileNameExtensionFilter(
                            "dot files (*.dot)", "dot");
                    chooser.setFileFilter(dotFilter);
                    int retrival = chooser.showSaveDialog(null);
                    if (retrival == JFileChooser.APPROVE_OPTION) {
                        try {
                            InputStream is = new FileInputStream(chooser.getSelectedFile().toString());
                            BufferedReader buf = new BufferedReader(new InputStreamReader(is));
                            String line = buf.readLine();
                            StringBuilder sb = new StringBuilder();

                            while (line != null) {
                                sb.append(line).append("\n");
                                line = buf.readLine();
                            }

                            String graphDot = sb.toString();
                            System.out.println(graphDot);
                            Grafo grafo1 = GrafoToDot.importaGrafoDot(graphDot);
                            Menu.setGrafo(grafo1);
                            salvo = true;
                            nomeArquivo = chooser.getSelectedFile().toString();
                            if (nomeArquivo.contains(".dot")) {
                                nomeArquivo = nomeArquivo.replace(".dot", "");
                            }
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case 0:
                    continuarOp3 = 0;
                    break;
                default:
                    System.err.println("Essa opção não existe");
                    break;
                //esta opção não existe
            }
        }
    }

    // Função MENU PRINCIPAL!!
    private static void getMenu() {

        System.out.println("Cria Grafo - 1");

        System.out.println("Informe opção:");

        opcao = scanner.nextInt();
    }

    // Fim MENU PRINCIPAL
    public static Grafo getCriaGrafo() {

        String nomeGrafo;
        boolean eOrientado;
        boolean escolheu = false;
        int escolha;
        System.out.println("Nome do Grafo: ");
        nomeGrafo = scanner.nextLine();
        Grafo grafo = new Grafo();

        while (!escolheu) {
            System.out.println("Grafo Orientado[0] -- Grafo Não Orientado[1]");
            escolha = scanner.nextInt();
            if (escolha == 1) {
                grafo = new Grafo(nomeGrafo, false);
                escolheu = true;
            } else if (escolha == 0) {
                grafo = new Grafo(nomeGrafo, true);
                escolheu = true;
            } else {
                System.out.println("Número invalido");
            }
        }
        return grafo;
    }

    private static int menuMatrizIncidencia() {
        int opGrafoMatrizIncidencia;
        System.out.println("MATRIZ DE INCIDÊNCIA");
        System.out.println("Adicionar aresta - 1");
        System.out.println("Adicionar vertice - 2");
        System.out.println("Imprimir matriz não orientada - 3");
        System.out.println("Imprimir matriz orientada - 4");
        System.out.println("Remover aresta - 5");
        System.out.println("Remover vértice - 6");
        System.out.println("Informações a respeito do grafo - 7");
        System.out.println("Imprime de acordo com o escolhido - 8");
        System.out.println("Salvar Grafo - 9");
        System.out.println("Algoritmo de Dijkstra - 10");
        System.out.println("Importar Grafo - 11");

        //System.out.println("Confere a existencia de uma aresta - 7");
        System.out.println("voltar menu principal - 0");
        opGrafoMatrizIncidencia = scanner.nextInt();
        return opGrafoMatrizIncidencia;
    }

    static public void setGrafo(Grafo grafo) {
        Menu.grafo = grafo;
    }

}
