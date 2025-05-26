import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MenuPrincipal {

    public class LoginAdmin {

        public static boolean verificarAdmin(String username, String password) throws FileNotFoundException {
            File ficheiro = new File("IMDV_Ficheiros/IMDV_AdminLogin.csv");
            Scanner sc = new Scanner(ficheiro);

            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] partes = linha.split(";");

                if (partes.length == 2) {
                    if (partes[0].equals(username) && partes[1].equals(password)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }


    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        String tipoUtilizador;

        System.out.println("_*_*_*_*_*_*_*_*_*_ IMDV© _*_*_*_*_*_*_*_*_*_\n");

        // Perguntar o tipo de utilizador
        System.out.print("> Tipo de Utilizador (ADMIN || CLIENTE): ");
        tipoUtilizador = input.nextLine();

        // ADMIN
        if (tipoUtilizador.equals("ADMIN")) {

            System.out.print("> USERNAME: ");
            String username = input.nextLine();

            System.out.print("> PASSWORD: ");
            String password = input.nextLine();

            if (LoginAdmin.verificarAdmin(username, password)) {
                String[][] matriz = MenuAdmin.ficheiroParaMatriz("IMDV_Ficheiros/IMDV.csv");
                MenuAdmin.menu(matriz);
            } else {
                System.out.println("> Password Incorreta");
            }

        }
        // CLIENTE
        else {
            // CLIENTE entra sempre
            LoginCliente.verificarCliente();
            String[][] matriz = MenuAdmin.ficheiroParaMatriz("IMDV_Ficheiros/IMDV.csv");
            MenuCliente.menu(matriz);
        }
    }
}