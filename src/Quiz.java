import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Quiz {
    /**
     * Função para fazer um Quiz com base no ficheiro CSV.
     *
     */
    public static void resolverQuiz() throws FileNotFoundException {

        File ficheiro = new File("IMDV_Ficheiros/Quiz.csv");
        Scanner ficheiroScanner = new Scanner(ficheiro);

        // Scanner para ler a resposta do utilizador
        Scanner input = new Scanner(System.in);

        int totalPerguntas = 0; //Criação do contador com o inicio a 0 para o total de Perguntas do ficheiro
        int totalCertas = 0; //Criação do contador com o inicio a 0 para o total de respostas certas

        ficheiroScanner.nextLine(); // Ignora o cabeçalho

        while (ficheiroScanner.hasNextLine()) {
            String linha = ficheiroScanner.nextLine();
            String[] coluna = linha.split(";");  // Divide a linha em colunas

            // Atribui cada coluna a sua variável
            String pergunta = coluna[0];
            String opcao1 = coluna[1];
            String opcao2 = coluna[2];
            String opcao3 = coluna[3];
            String opcao4 = coluna[4];
            int respostaCerta = Integer.parseInt(coluna[5]);

            System.out.println();
            System.out.println("> " + pergunta);
            System.out.println("1. " + opcao1);
            System.out.println("2. " + opcao2);
            System.out.println("3. " + opcao3);
            System.out.println("4. " + opcao4);
            System.out.print("Escolha uma resposta de 1 a 4: ");

            int respostaCliente = input.nextInt();

            // Verificação da resposta
            if (respostaCliente == respostaCerta) {
                System.out.println("Acertou!!!");
                totalCertas++; //Incrementa o número de respostas certas
            } else {
                System.out.println("Errou!!! A resposta certa é: " + respostaCerta);
            }

            totalPerguntas++; // Incrementa o número total de perguntas
        }

        System.out.println();

        // Mensagem com o resultado final do Quiz
        System.out.println("> Acertaste " + totalCertas + " em " + totalPerguntas + " perguntas.");
    }

}