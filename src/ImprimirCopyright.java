import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImprimirCopyright {

    /**
     * Função que imprime o conteúdo do ficheiro de copyright.
     * @throws FileNotFoundException Se o ficheiro não for encontrado.
     */
    public static void imprimirCopyright() throws FileNotFoundException {
        File ficheiro = new File("IMDV_Ficheiros/IMDV_Copyright.txt");
        Scanner sc = new Scanner(ficheiro);

        System.out.println();

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }

        System.out.println();
    }
}