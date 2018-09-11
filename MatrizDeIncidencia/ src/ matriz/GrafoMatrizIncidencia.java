

import java.util.Scanner;

public class GrafoMatrizIncidencia {
    Scanner scanner = new Scanner(System.in);

    private int qtdeVertice;
    private int qtdeArestas;
    private int[][] matrizIncidencia;

    public void matrizNaoOrientada() {
        pegarInformacao();
        matrizIncidencia = new int[qtdeVertice][qtdeArestas];// vertice | aresta
        for (int i = 0; i < qtdeVertice; i++) {
        	
            for (int j = 0; j < qtdeArestas; j++) {
                System.out.printf("Vertice %d se liga com a aresta %d\n", i + 1, j + 1);
                System.out.println("s - sim | n - não");
                char op = scanner.next().charAt(0);
                switch (op) {
                    case 's' :
                        matrizIncidencia[i][j] = 1;
                      
                        break;
                    case 'S' :
                        matrizIncidencia[i][j] = 1;
                        break;
                    case 'n':
                        matrizIncidencia[i][j] = 0;
                        break;
                    case 'N':
                        matrizIncidencia[i][j] = 0;
                        break;
                            }

            }
        }
    }

    public void matrizOrientada() {
        pegarInformacao();
        matrizIncidencia = new int[qtdeVertice][qtdeArestas];// vertice | aresta
        for (int i = 0; i < qtdeVertice; i++) {
            for (int j = 0; j < qtdeArestas; j++) {
                if (matrizIncidencia[i][j] == 0) {
                    System.out.printf("Vertice %d parte para outro vertice com  a aresta %d?\n", i + 1, j + 1);
                    System.out.println("s - sim | n - não");
                    char op = scanner.next().charAt(0);
                    switch (op) {
                        case 's':
                            matrizIncidencia[i][j] = 1;
                            System.out.println("Informe o vertice?");
                            int vertices = scanner.nextInt();
                            matrizIncidencia[vertices - 1][j] = -1;
                            break;
                        case 'S':
                            matrizIncidencia[i][j] = 1;
                            System.out.println("Informe o vertice?");
                            int verticeS = scanner.nextInt();
                            matrizIncidencia[verticeS - 1][j] = -1;
                            break;
                        case 'n':
                            matrizIncidencia[i][j] = 0;
                            break;
                        case 'N':
                            matrizIncidencia[i][j] = 0;
                            break;
                            
                    }
                }
            }
        }
    }

    private void pegarInformacao() {
        System.out.println("Informe qtde de vertices: ");
        qtdeVertice = scanner.nextInt();
        System.out.println("Informe qtde de arestas: ");
        qtdeArestas = scanner.nextInt();
    }

    public void imprimirMatriz() {
        if (matrizIncidencia != null) {
            for (int i = 0; i < qtdeVertice; i++) {
                  System.out.printf("Vértice %d: \t", (i+1));
                for (int j = 0; j < qtdeArestas; j++) {
                    System.out.print(matrizIncidencia[i][j]+ "\t");
                }
                System.out.println();
            }
        } else {
            System.err.println("Matriz ainda não existe, crie uma.");
        }
    }

    public void info() {
        System.out.printf("Grafo de ordem %d\n", getQtdeVertice());
        System.out.printf("Qtde de arestas %d\n", getQtdeArestas());
        eOrientado();
        eGrafoSimples();
    }

    private void eGrafoSimples() {
        int contLacos = 0;

        for (int i = 0; i < qtdeVertice; i++) {
            for (int j = 0; j < qtdeArestas; j++) {
                if (i == j && matrizIncidencia[i][j] == 1) {
                    contLacos++;
                }
                //grau dos vertices
                System.out.printf("V: %d\tG: %d\n", i + 1, contLacos);
            }
        }

        if (contLacos == 0) {
            System.out.println("Grafo Simples");
        } else {
            System.out.printf("Grafo Não Simples, possui %d laços", contLacos);
        }
    }

    private void eOrientado() {
        for (int i = 0; i < qtdeVertice; i++) {
            for (int j = 0; j < qtdeArestas; j++) {
                if (matrizIncidencia[i][j] == -1) {
                    System.out.println("Grafo Orientado");
                    arcosOrientado();
                    return;
                }
            }
        }
        System.out.println("Grafo Não Orientado");
        arcosNaoOrientado();
        qtdeFontessumidouros();
        eEuleriano();
    }

    private void eEuleriano() {
        int contQtdeVertice = 0;

        for (int i = 0; i < qtdeVertice; i++) {
            int cont = 0;
            for (int j = 0; j < qtdeArestas; j++) {
                if (matrizIncidencia[i][j] == 1) {
                    cont++;
                }
            }
            if (cont % 2 == 0) {
                contQtdeVertice++;
            }
        }

        if (contQtdeVertice == qtdeVertice) {
            System.out.println("Euleriano");
        } else {
            System.out.println("Não é Euleriano");
        }
    }

    private void arcosNaoOrientado() {
        for (int i = 0; i < qtdeVertice; i++) {
            int par1 = Integer.MIN_VALUE;
            int par2 = Integer.MIN_VALUE;
            int cont = 0;
            for (int j = 0; j < qtdeArestas; j++) {
                if (matrizIncidencia[i][j] == 1) {
                    cont++;
                    par1 = i + 1;
                } else if (matrizIncidencia[i][j] == 1 && cont > 0) {
                    par2 = i + 1;
                }
            }
            if (par1 != Integer.MIN_VALUE && par2 != Integer.MIN_VALUE) {
                System.out.printf("(%d, %d)\n", par1, par2);
            }
        }
    }

    private void arcosOrientado() {
        for (int i = 0; i < qtdeVertice; i++) {
            int parPositivo = Integer.MIN_VALUE;
            int parNegativo = Integer.MIN_VALUE;
            for (int j = 0; j < qtdeArestas; j++) {
                if (matrizIncidencia[i][j] == 1) {
                    parPositivo = i + 1;
                } else if (matrizIncidencia[i][j] == -1) {
                    parNegativo = i + 1;
                }
            }
            if (parPositivo != Integer.MIN_VALUE && parNegativo != Integer.MIN_VALUE) {
                System.out.printf("(%d -> %d)\n", parPositivo, parNegativo);
            }
        }
    }

    private void qtdeFontessumidouros() {
        for (int i = 0; i < qtdeVertice; i++) {
            int qtdeFontes = 0;
            int qtdeSumidouro = 0;
            for (int j = 0; j < qtdeArestas; j++) {
                if (matrizIncidencia[i][j] == 1) {
                    qtdeFontes++;
                } else if (matrizIncidencia[i][j] == -1) {
                    qtdeSumidouro++;
                }
            }
            if (qtdeFontes == 0 && qtdeSumidouro > 0) {
                System.out.printf("%d - sumidouro\t", i + 1);
            }
            if (qtdeFontes > 0 && qtdeSumidouro == 0) {
                System.out.printf("%d - fonte\t", i + 1);
            }
        }
    } 

    public int getQtdeVertice() {
        return qtdeVertice;
    }

    public void setQtdeVertice(int qtdeVertice) {
        this.qtdeVertice = qtdeVertice;
    }

    public int getQtdeArestas() {
        return qtdeArestas;
    }

    public void setQtdeArestas(int qtdeArestas) {
        this.qtdeArestas = qtdeArestas;
    }
    
	public void removeAresta() {
		System.out.printf("Digite o número da aresta que deseja remover: ");
        int aresta = scanner.nextInt();
        
		for (int i = 0; i < qtdeVertice; i++) {
            for (int j = 0; j < aresta; j++) {
            	if(j == aresta - 1) {
            		matrizIncidencia[i][j] = 0;
            	}  
            }
        }
	}
	
	public void removeVertice() {
		System.out.printf("Digite o número dao vértice que deseja remover: ");
        int vertice = scanner.nextInt();
        
		for (int i = 0; i < vertice; i++) {
            for (int j = 0; j < qtdeArestas; j++) {
            	if(i == vertice - 1) {
            		matrizIncidencia[i][j] = 0;
            	}
                 
            }
        }
	}
}