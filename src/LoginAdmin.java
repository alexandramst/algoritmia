import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginAdmin {

    /**
     * Função que verifica se o nome de utilizador e a respetiva password existem no ficheiro
     * @param username Nome de utilizador a verificar
     * @param password Palavra-passe correspondente ao utilizador
     * @return  Se o utilizador e a password existirem no ficheiro return 'true' caso contrário return 'false'
     * @throws FileNotFoundException Se o ficheiro não for encontrado
     */
        public static boolean verificarAdmin(String username, String password) throws FileNotFoundException {
            File ficheiro = new File("IMDV_Ficheiros/IMDV_AdminLogin.csv");
            Scanner sc = new Scanner(ficheiro);

            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] partes = linha.split(";");

                if (partes[0].equals(username) && partes[1].equals(password)) {
                    return true; // encontrou o utilizador com password certa
                }
            }

            return false; // Quando não encontrou nenhum correspondente

        }

    }


