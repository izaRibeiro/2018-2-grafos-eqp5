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

	        while (continuarOp3 == 1) {
                        
                             
                             
	            int opGrafoMatrizIncidencia = menuMatrizIncidencia();
                    
	            switch (opGrafoMatrizIncidencia) {
	                case 1:
                                        
                                        int origem;
                                        int destino;
                                      
                                        System.out.println("Digite o vértice de origem");
                                        origem = scanner.nextInt();
                                        
                                        System.out.println("Digite o vértice de destino");
                                        destino = scanner.nextInt();

                                        Aresta aresta = new Aresta(grafo.getVertice(origem),grafo.getVertice(destino));
                                        
                                        grafo.adicionaAresta(aresta);
	                    break;
	                case 2:
                            Vertice vertice = new Vertice();
                                      System.out.println("Adicionar vértice");
	                    grafo.adicionaVertice(vertice);
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
                                
                                     case 7 :
                                    int i;
                                    System.out.println("-------------------------------");
                                     System.out.println("Ordem: "+grafo.ordem());
                                     System.out.println("-------------------------------");
                                     grafo.grau();
                                     System.out.println("-------------------------------");
                                     grafo.isCompleto();
                                     System.out.println("-------------------------------");
                                     System.out.println("Matriz de Incidência: ");
                                     grafo.imprimir();
                           
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
	        System.out.println("Imprimir matriz não orientada - 3");
                          System.out.println("Imprimir matriz orientada - 4");
	        System.out.println("Remover aresta - 5");
	        System.out.println("Remover vértice - 6");
                          System.out.println("Informações a respeito do grafo - 7");
                          
                          
	        //System.out.println("Confere a existencia de uma aresta - 7");
	        System.out.println("voltar menu principal - 0");
	        opGrafoMatrizIncidencia = scanner.nextInt();
	        return opGrafoMatrizIncidencia;
	    }
        
    }
    

