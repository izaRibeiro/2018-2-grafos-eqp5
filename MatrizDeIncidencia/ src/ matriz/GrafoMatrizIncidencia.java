package matriz;

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
}
