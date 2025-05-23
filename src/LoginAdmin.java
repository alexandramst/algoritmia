import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginAdmin {


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


