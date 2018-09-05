


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