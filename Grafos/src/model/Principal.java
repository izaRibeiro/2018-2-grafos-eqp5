package model;


import java.util.Scanner;

public class Principal {

    	

	    static Scanner scanner = new Scanner(System.in);
	    private static int opcao;

	    public static void main(String[] args) {
	        int continuar = 0;

	        while (continuar == 0) {
	            getMenu();
	            switch (opcao) {
	                case 1:
	                    getGrafoMatrizIncidencia();
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

	    private static void getGrafoMatrizIncidencia() {
	        int continuarOp3 = 1;
	        Grafo grafo = new Grafo();
	        while (continuarOp3 == 1) {
	            int opGrafoMatrizIncidencia = menuMatrizIncidencia();
	            switch (opGrafoMatrizIncidencia) {
	                case 1:
	                    System.out.println("Você selecionou 'Matriz Não Orientada'");
                            // grafoMatrizIncidencia.matrizNaoOrientada();
                            grafo.criaMatrizNaoOrientada();
	                    break;
	                case 2:
                        System.out.println("Você selecionou 'Matriz Orientada'");
                            // grafoMatrizIncidencia.matrizOrientada();
                            grafo.criaMatrizOrientada();
	                    break;
	                case 3:
                            System.out.println("Impressão");
                            // grafoMatrizIncidencia.imprimirMatriz();
	                    break;
	                case 4:
	                    //grafoMatrizIncidencia.info();
	                    break;
	                case 5:
	                    //grafoMatrizIncidencia.removeAresta();
	                    break;
	                case 6:
	                    //grafoMatrizIncidencia.removeVertice();
	                    break;
	                case 7:
                            //grafoMatrizIncidencia.Completo();
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
	        System.out.println("Matriz não orientada - 1");
	        System.out.println("Matriz orientada - 2");
	        System.out.println("Imprimir matriz - 3");
	        System.out.println("Informações que o grafo pode dar - 4");
	        System.out.println("Remover aresta - 5");
	        System.out.println("Remover vértice - 6");
	        System.out.println("Verificar se é completo - 7");
	        //System.out.println("Confere a existencia de uma aresta - 7");
	        System.out.println("voltar menu principal - 0");
	        opGrafoMatrizIncidencia = scanner.nextInt();
	        return opGrafoMatrizIncidencia;
	    }

	    
}
