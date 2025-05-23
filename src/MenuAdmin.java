import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MenuAdmin {

    /**
     * Função que imprime o conteúdo de um ficheiro na consola
     * @param caminhoFicheiro Caminho para o ficheiro
     * @throws FileNotFoundException Caso o ficheiro não exista
     */
    public static void consultaFicheiro(String caminhoFicheiro) throws FileNotFoundException {
        File ficheiro = new File(caminhoFicheiro);
        Scanner sc =new Scanner(ficheiro);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            System.out.println(linha);
        }
    }

    /**
     * A função conta o número de linhas que existe no ficheiro
     *
     * @param caminho Caminho para o ficheiro
     * @return A contagem de linhas
     * @throws FileNotFoundException Caso o ficheiro não exista
     */
    public static int contarLinhas(String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        // Avançar o cabeçalho
        sc.nextLine();

        int contagemLinhas = 0;

        while (sc.hasNextLine()) {
            sc.nextLine();
            contagemLinhas++;
        }

        return contagemLinhas;

    }

    /**
     * A função conta o número de Rantings no ficheiro
     *
     * @param caminho Caminho para o ficheiro
     * @return A matriz completa
     * @throws FileNotFoundException Caso o ficheiro não exista
     */
    public static String[][] ficheiroParaMatriz(String caminho) throws FileNotFoundException {

        // Saber quantos Ratings tem o ficheiro (atenção ao cabeçalho (-1))
        int numeroRatings = contarLinhas(caminho);

        // Criar uma matriz com o tamanho certo
        String[][] matrizCompleta = new String[numeroRatings][8];

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        // Avançar o cabeçalho
        sc.nextLine();

        // Controlar o numero de Ratings
        int numRatingAtual = 0;

        // Enquanto houver ratings
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] linhaSeparada = linha.split(";");

            for (int i = 0; i < matrizCompleta[0].length; i++) {
                matrizCompleta[numRatingAtual][i] = linhaSeparada[i];
            }

            numRatingAtual++;

        }

        return matrizCompleta;
    }

    /**
     * Imprime todos os estúdios encontrados na matriz, sem repetições.
     *
     * @param matriz Matriz com os dados dos filmes.
     */
    public static void imprimirTodosEstudios(String[][] matriz) {
        String[] estudiosNaoRepetidos = new String[matriz.length];
        int totalNaoRepetidos = 0;

        for (int i = 0; i < matriz.length; i++) {
            String estudioAtual = matriz[i][5]; // Na coluna 5 é onde está o estúdio
            boolean estudioExiste = false;

            // Verificar se o estúdio já foi adicionado
            for (int iInterno = 0; iInterno < totalNaoRepetidos; iInterno++) {
                if (estudiosNaoRepetidos[iInterno].equalsIgnoreCase(estudioAtual)) {
                    estudioExiste = true;
                    break;

                }
            }

            //Se o estúdio ainda não estiver na lista
            if (!estudioExiste){
                estudiosNaoRepetidos[totalNaoRepetidos] = estudioAtual;
                totalNaoRepetidos++;

            }

        }

        // Mostrar os estúdios não repetidos
        System.out.println("\n\nOs Estúdios encontrados foram:\n");
        for (int i = 0; i < totalNaoRepetidos; i++) {
            System.out.println(" > " + estudiosNaoRepetidos[i]);
        }
    }


    /**
     * Mostra o menu de opções.
     *
     * @param matriz Matriz com os dados lidos do ficheiro.
     * @throws FileNotFoundException Caso o ficheiro necessário não seja encontrado.
     */
    public static void menu(String[][] matriz) throws FileNotFoundException{

        Scanner input = new Scanner(System.in);

        int opcao;

        // Loop principal do menu - continua até o utilizador escolher sair (opção 0)
        do {

            //Opções do menu
            System.out.println("\n\n_*_*_*_*_*_*_*_*_*_ Menu Admin _*_*_*_*_*_*_*_*_*_");
            System.out.println("1. Consulta de Ficheiros");
            System.out.println("2. Total de Ratings");
            System.out.println("3. Imprimir todos os Estúdios");
            System.out.println("0. Sair");

            System.out.print("Escolhe uma opção: ");
            opcao = input.nextInt();

            System.out.println();

            // Processa a opção selecionada
            switch (opcao) {
                case 1: // Consulta de Ficheiros
                    System.out.println("_*_*_*_*_*_ Consulta de Ficheiro _*_*_*_*_*_ ");
                    consultaFicheiro("IMDV_Ficheiros/IMDV.csv");
                    break;

                case 2: //Total de Ratings
                    System.out.println("_*_*_*_*_*_ Total de Ratings _*_*_*_*_*_ ");
                    // Exibe o número total de Ratings (número de linhas na matriz)
                    System.out.println("O total de Ratings é de: " +matriz.length);
                    break;

                case 3:// Imprimir todos os Estúdios
                    System.out.println("_*_*_*_*_*_ Imprimir todos os Estúdios _*_*_*_*_*_ ");
                    imprimirTodosEstudios(matriz);

                    break;


                case 0: // Sair do Programa
                    System.out.println("_*_*_*_*_*_ Encerrar o Programa _*_*_*_*_*_ ");
                    break;

                default: //Opção Inválida
                    System.out.println("!!!!!!!!!!! Opção Inválida !!!!!!!!!!!");
                    break;

            }

        } while (opcao != 0); // Continua até o utilizador escolher sair
    }

    /**
     * Função principal que inicia o programa.
     *
     * @param args Argumentos da linha de comandos.
     * @throws FileNotFoundException Caso o ficheiro não seja encontrado.
     */
    public static void main(String[] args) throws FileNotFoundException {

        // Carrega o arquivo CSV para uma matriz
        String[][] matriz = ficheiroParaMatriz("IMDV_Ficheiros/IMDV.csv");

        // Inicia o menu interativo
        menu(matriz);

    }


}
