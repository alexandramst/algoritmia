public class EstudioMelhorMedia {


    /**
     * Função que calcula e imprime o estúdio com a melhor média.
     *
     * @param matriz Matriz com os dados dos filmes.
     */
    public static void imprimirMelhorEstudio(String[][] matriz) {

        // Arrays para guardar estúdios únicos, a soma dos ratings e o total de filmes por estúdio
        String[] estudios = new String[matriz.length];
        double[] somaRatings = new double[matriz.length];
        int[] totalFilmes = new int[matriz.length];
        int totalEstudios = 0;

        // Percorre a matriz dos filmes
        for (int i = 0; i < matriz.length; i++) {
            String estudioAtual = matriz[i][5]; // // O estúdio está na coluna 5
            double ratingAtual = Double.parseDouble(matriz[i][2]); // O Rating está na coluna 2

            boolean existe = false; //Verifica se o estúdio já foi adicionado

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

        // Variáveis para encontrar a melhor média
        double melhorMedia = 0;
        String melhorEstudio = "";

        // Calcula a média de cada estúdio e verifica qual é a maior
        for (int i = 0; i < totalEstudios; i++) {
            double media = (double) somaRatings[i] / totalFilmes[i];

            if (media > melhorMedia) {
                melhorMedia = media;
                melhorEstudio = estudios[i];
            }
        }

        // Mostrar mensagem do estúdio com a melhor média
        System.out.println("> O Estúdio com a melhor média é " + melhorEstudio + ". A sua média é de: " + melhorMedia + ".");
    }
}