public class EstudioPiorMedia {

    /**
     * Função que calcula e imprime o estúdio com a pior média.
     *
     * @param matriz Matriz com os dados dos filmes.
     */
    public static void imprimirPiorEstudio(String[][] matriz) {

        // Arrays para guardar estúdios únicos, a soma dos ratings e o total de filmes por estúdio
        String[] estudios = new String[matriz.length];
        double[] somaRatings = new double[matriz.length];
        int[] totalFilmes = new int[matriz.length];
        int totalEstudios = 0;

        // Percorre a matriz dos filmes
        for (int i = 0; i < matriz.length; i++) {
            String estudioAtual = matriz[i][5]; // Estúdio na coluna 5
            double ratingAtual = Double.parseDouble(matriz[i][2]); // Rating na coluna 2

            boolean existe = false;

            // Verifica se o estúdio já está no array de estúdios
            for (int posicaoEstudio = 0; posicaoEstudio < totalEstudios; posicaoEstudio++) {
                if (estudios[posicaoEstudio].equals(estudioAtual)) {
                    // Se já existe, soma o rating ao total e acrecenta o número de filmes
                    somaRatings[posicaoEstudio] = somaRatings[posicaoEstudio] + ratingAtual;
                    totalFilmes[posicaoEstudio]++;
                    existe = true;
                    break;
                }
            }

            // Se o estúdio ainda não foi encontrado - adiciona novo
            if (!existe) {
                estudios[totalEstudios] = estudioAtual;
                somaRatings[totalEstudios] = ratingAtual;
                totalFilmes[totalEstudios] = 1;
                totalEstudios++;
            }
        }

        // Variáveis para encontrar a pior média
        double piorMedia = 10; // Ranting máximo =10 -> Começo com este valor até encontrar a menos média
        String piorEstudio = "";

        // Calcula a média de cada estúdio e verifica qual é a menor
        for (int i = 0; i < totalEstudios; i++) {
            double media = somaRatings[i] / totalFilmes[i];

            if (media < piorMedia) {
                piorMedia = media;
                piorEstudio = estudios[i];
            }
        }

        // Mensagem do estúdio com a pior média
        System.out.println("> O Estúdio com a pior média é " + piorEstudio + ". A sua média é de: " + piorMedia + ".");
    }
}