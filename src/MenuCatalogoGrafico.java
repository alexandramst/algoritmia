import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MenuCatalogoGrafico {

    /**
     * Função que imprime o conteúdo dos ficheiros gráfico.
     *
     * @param caminhoFicheiro Caminho para o ficheiro
     * @throws FileNotFoundException Caso o ficheiro não seja encontrado.
     */

    public static void imprimirGrafico(String caminhoFicheiro) throws FileNotFoundException {
        File ficheiro = new File(caminhoFicheiro);
        Scanner sc = new Scanner(ficheiro);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            System.out.println(linha);
        }
    }

    /**
     * Mostras as opções do submenue mostra as opções de gráficos disponíveis.
     *
     *
     * @throws FileNotFoundException Caso algum dos ficheiros de não seja encontrado.
     */
    public static void submenuGraficos() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n_*_*_*_*_*_ Catálogo de Gráficos _*_*_*_*_*_");
            System.out.println("1. Harry Potter");
            System.out.println("2. Interstellar");
            System.out.println("3. Lord Of Rings ");
            System.out.println("4. Star Wars");
            System.out.println("0. Voltar ao Menu Cliente");
            System.out.print("Escolhe uma opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n > Harry Potter:");
                    imprimirGrafico("IMDV_Ficheiros/CatalogoGrafico/HarryPotter.txt");
                    break;
                case 2:
                    System.out.println("\n > Interstellar:");
                    imprimirGrafico("IMDV_Ficheiros/CatalogoGrafico/Interstellar.txt");
                    break;
                case 3:
                    System.out.println("\n > Lord Of Rings:");
                    imprimirGrafico("IMDV_Ficheiros/CatalogoGrafico/LordOfTheRings.txt");
                    break;
                case 4:
                    System.out.println("\n > Star Wars:");
                    imprimirGrafico("IMDV_Ficheiros/CatalogoGrafico/StarWars.txt");
                    break;
                case 0:
                    System.out.println("> A regressar ao Menu Cliente...");
                    break;
                default:
                    System.out.println("> Opção inválida !!!");
            }
        } while (opcao != 0);
    }
}
