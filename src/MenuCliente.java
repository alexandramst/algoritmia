import java.io.FileNotFoundException;
import java.util.Scanner;

public class MenuCliente {

    /**
     * Mostra o menu de opções.
     *
     * @param matriz Matriz com os dados lidos do ficheiro.
     * @throws FileNotFoundException Caso o ficheiro necessário não seja encontrado.
     */
    public static void menu(String[][] matriz) throws FileNotFoundException{

        Scanner input = new Scanner(System.in);

        int opcao;


        do {

            //Opções do menu
            System.out.println("\n\n_*_*_*_*_*_*_*_*_*_ Menu Cliente _*_*_*_*_*_*_*_*_*_");
            System.out.println("1. Catálogo com Filmes");
            System.out.println("2. Catálogo com Gráficos");
            System.out.println("3. Melhor Estúdio");
            System.out.println("4. Pior Estúdio");
            System.out.println("5. Melhor Estúdio");
            System.out.println("6. Quiz");
            System.out.println("7. Catálogo Estudio");
            System.out.println("8. Catálogo Categoria");
            System.out.println("0. Sair");

            System.out.print("Escolhe uma opção: ");
            opcao = input.nextInt();

            System.out.println();

            // Processa a opção selecionada
            switch (opcao) {
                case 1: // Imprimir Catálogo Filmes
                    System.out.println("_*_*_*_*_*_ Consulta de Ficheiro _*_*_*_*_*_ \n");
                    MenuAdmin.consultaFicheiro("IMDV_Ficheiros/IMDV.csv");
                    break;

                case 2: //Imprimir Catálogo Gráficos

                    break;

                case 3: // Imprimir Melhor Estúdio com Média


                    break;

                case 4: // Imprimir Pior Estúdio com Média


                    break;

                case 5: // Imprimir Crítica Mais Recente


                    break;

                case 6:


                    break;

                case 7:


                    break;

                case 8:


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

    public static void main(String[] args) throws FileNotFoundException {

        // Carrega o arquivo CSV para uma matriz
        String[][] matriz = MenuAdmin.ficheiroParaMatriz("IMDV_Ficheiros/IMDV.csv");

        // Inicia o menu interativo
        menu(matriz);

    }

}
