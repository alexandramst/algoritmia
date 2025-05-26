import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class MenuCliente {

    /**
     * Função que imprime o conteúdo de um ficheiro na consola com o | a separar.
     *
     * @param caminhoFicheiro Caminho para o ficheiro
     * @throws FileNotFoundException Caso o ficheiro não exista
     */
    public static void consultaFicheiroComSeparador(String caminhoFicheiro) throws FileNotFoundException {
        File ficheiro = new File(caminhoFicheiro);
        Scanner sc = new Scanner(ficheiro);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] partes = linha.split(";");

            // Percorre todas as colunas da linha atual
            for (int i = 0; i < partes.length; i++) {
                // Imprime o conteúdo da coluna
                System.out.print(partes[i] + " | ");
            }
            System.out.println(); // Nova linha no fim de cada registo
        }
    }

    /**
     * Imprime a crítica mais recente (último filme do ficheiro)
     *
     * @param matriz Matriz com os dados dos filmes.
     */
    public static void imprimirCriticaMaisRecente(String[][] matriz) {
        int ultimaLinha = matriz.length - 1; // Guarda a última linha da matriz
        String titulo = matriz[ultimaLinha][1]; // Coluna 1 = título
        String rating = matriz[ultimaLinha][2]; // Coluna 2 = rating

        System.out.println("> A crítica mais recente foi ao filme - " + titulo + "  - com o rating de: " + rating);
    }

    /**
     * Mostra o menu de opções.
     *
     * @param matriz Matriz com os dados lidos do ficheiro.
     * @throws FileNotFoundException Caso o ficheiro necessário não seja encontrado.
     */
    public static void menu(String[][] matriz) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n\n_*_*_*_*_*_*_*_*_*_ Menu Cliente _*_*_*_*_*_*_*_*_*_");
            System.out.println("1. Catálogo com Filmes");
            System.out.println("2. Catálogo com Gráficos");
            System.out.println("3. Melhor Estúdio");
            System.out.println("4. Pior Estúdio");
            System.out.println("5. Crítica Mais Recente");
            System.out.println("6. Quiz");
            System.out.println("7. Catálogo Estúdio");
            System.out.println("8. Catálogo Categoria");
            System.out.println("0. Sair");

            System.out.print("Escolhe uma opção: ");
            opcao = input.nextInt();

            System.out.println();

            switch (opcao) {
                case 1: //Imprimir Catálogo Filmes

                    System.out.println("_*_*_*_*_*_ Catálogo de Filmes _*_*_*_*_*_ \n");
                    consultaFicheiroComSeparador("IMDV_Ficheiros/IMDV.csv");
                    break;


                case 2: //Imprimir Catálogos Gráficos - Submenu

                    MenuCatalogoGrafico.submenuGraficos();
                    break;


                case 3: //Imprimir Estudio com Melhor Média

                    EstudioMelhorMedia.imprimirMelhorEstudio(matriz);
                    break;


                case 4: //Imprimir estúdio com Pior Média

                    EstudioPiorMedia.imprimirPiorEstudio(matriz);
                    break;


                case 5: //Imprimir Crítica mais recente - Avaliação do último filme do Ficheiro

                    imprimirCriticaMaisRecente(matriz);
                    break;

                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;

                case 0: //Encerrar o Programa - Imprimir Copyright

                    System.out.println("_*_*_*_*_*_ Encerrar o Programa _*_*_*_*_*_ ");
                    ImprimirCopyright.imprimirCopyright();
                    break;

                default:
                    System.out.println("> Opção Inválida !!!");
                    break;
            }

        } while (opcao != 0);
    }

    public static void main(String[] args) throws FileNotFoundException {
        String[][] matriz = MenuAdmin.ficheiroParaMatriz("IMDV_Ficheiros/IMDV.csv");
        menu(matriz);
    }
}