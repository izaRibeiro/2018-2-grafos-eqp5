package model;


import model.Grafo;
import model.Vertice;
import model.Aresta;


import java.util.Scanner;

/**
 *
 * @author Iza Ribeiro
 */
public class Menu {
    
	    static Scanner scanner = new Scanner(System.in);
	    private static int opcao;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                int continuar = 0;

	        while (continuar == 0) {
	            getMenu();
	            switch (opcao) {
	                case 1:
	                    getGrafo();
	                    break;
	                default:
	                    System.err.println("Essa opção não existe");
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
	        Grafo grafo= new Grafo("Grafo");
                           Aresta aresta = new Aresta();
                             Vertice vertice = new Vertice();
	        while (continuarOp3 == 1) {
                    
	            int opGrafoMatrizIncidencia = menuMatrizIncidencia();
                    
	            switch (opGrafoMatrizIncidencia) {
	                case 1:
	                    System.out.println("Adicionar aresta");
                                       grafo.adicionaAresta(aresta);
	                    break;
	                case 2:
                                      System.out.println("Adicionar vértice");
	                    grafo.adicionaVertice(vertice);
	                    break;
	                case 3:
                                     System.out.println("Impressão");
	                    grafo.imprimir();
	                    break;
	                case 4:
                                    grafo.removeAresta();
	                    break;
	                case 5:
	                   grafo.removeVertice();
	                    break;
	                case 6:
	                    grafo.criaMatrizNaoOrientada();
	                    break;
	                case 7:
                                     grafo.criaMatrizOrientada();
	                	break;
	                case 0:
	                    continuarOp3 = 0;
	                    break;
	                default:
	                    System.err.println("Essa opção não existe");
	                    break;
	            }
	        }
	    }

            
            // Função MENU PRINCIPAL!!
	   
	    private static void getMenu() {
	        System.out.println("Start - 1");
	       
	        System.out.println("Informe opção:");
	        
	        opcao = scanner.nextInt();
	    }

	    // Fim MENU PRINCIPAL
            
            
            

	    private static int menuMatrizIncidencia() {
	        int opGrafoMatrizIncidencia;
	        System.out.println("MATRIZ DE INCIDÊNCIA");
	        System.out.println("Adicionar aresta - 1");
	        System.out.println("Adicionar vertice - 2");
	        System.out.println("Imprimir matriz - 3");
	        System.out.println("Remover aresta - 4");
	        System.out.println("Remover vértice - 5");
	        System.out.println("Cria matriz não orientada - 6");
	        System.out.println("Cria matriz orientada - 7");
	        //System.out.println("Confere a existencia de uma aresta - 7");
	        System.out.println("voltar menu principal - 0");
	        opGrafoMatrizIncidencia = scanner.nextInt();
	        return opGrafoMatrizIncidencia;
	    }
        
    }
    

