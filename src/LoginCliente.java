import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginCliente {

    /**
     *
     * Função que simula o registo do cliente
     *
     */
    public static void verificarCliente() {

        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        String nome, contacto, email;

        System.out.println("> Registar Utilizador");
        System.out.println(">");

        //Ler
        System.out.print("> Insira Nome: ");
        nome = input.nextLine();

        System.out.print("> Insira Contacto: ");
        contacto = input.nextLine();

        System.out.print("> Insira Email: ");

        email = input.nextLine();
        System.out.println(">");
        System.out.println("> Utilizador Inserido com Sucesso: " + nome + " | " + contacto + " | " + email);

    }
}
