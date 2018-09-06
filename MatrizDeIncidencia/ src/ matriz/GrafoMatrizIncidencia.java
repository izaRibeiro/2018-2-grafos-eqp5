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
				case 's':
					matrizIncidencia[i][j] = 1;
					break;
				case 'n':
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
						int vertice = scanner.nextInt();
						matrizIncidencia[vertice - 1][j] = -1;
						break;
					case 'n':
						matrizIncidencia[i][j] = 0;
						break;
					}
				}
			}
		}
	}
	
	private void pegarInformacao() {
		System.out.println("Informe quantidade de vertices: ");
		qtdeVertice = scanner.nextInt();
		System.out.println("Informe quantidade de arestas: ");
		qtdeArestas = scanner.nextInt();
	}

	public void imprimirMatriz() {
		if (matrizIncidencia != null) {
			for (int i = 0; i < qtdeVertice; i++) {
				for (int j = 0; j < qtdeArestas; j++) {
					System.out.print(matrizIncidencia[i][j] + "\t");
				}
				System.out.println();
			}
		} else {
			System.err.println("Matriz ainda não existe, criar uma.");
		}
	}

	public void info() {
		System.out.println("------------------------");
		System.out.printf("Quantidade de Vértices: %d\n", getQtdeVertice());
		System.out.printf("Quantidade de Arestas: %d\n", getQtdeArestas());
		eOrientado();
	}

	private void eOrientado() {
		for (int i = 0; i < qtdeVertice; i++) {
			for (int j = 0; j < qtdeArestas; j++) {
				if (matrizIncidencia[i][j] == -1) {
					System.out.println("Grafo Orientado");
					System.out.println("------------------------\n");
					return;
				}
			}
		}
		System.out.println("Grafo Não Orientado");
		System.out.println("------------------------\n");
		arcosNaoOrientado();
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
}
