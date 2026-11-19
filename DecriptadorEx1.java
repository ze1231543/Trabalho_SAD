import java.util.Arrays;
import java.util.List;

/**
 * SAD - 1º Sprint - Exercício 1
 * Desencripta hashes cifradas com a Cifra de César (deslocamento desconhecido).
 */
public class DecriptadorEx1 {

    // Decifra o texto recuando cada letra 'deslocamento' posições (espaços ficam iguais)
    public static String decifrarCaesar(String texto, int deslocamento) {
        StringBuilder sb = new StringBuilder();
        for (char c : texto.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                int pos = Math.floorMod((c - 'A') - deslocamento, 26);
                sb.append((char) ('A' + pos));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // Conta quantas palavras do texto decifrado aparecem no nome do aluno
    public static int pontuacao(String texto, String nome) {
        List<String> palavrasNome = Arrays.asList(nome.split(" "));
        int pontos = 0;
        for (String palavra : texto.split(" ")) {
            if (palavrasNome.contains(palavra)) {
                pontos++;
            }
        }
        return pontos;
    }

    public static void main(String[] args) {
        // {nome do aluno, hash da coluna "SPRINT 1 - 1"}
        String[][] hashesGrupo = {
                {"JOSE HENRIQUE CORREIA LEITE", "NSWI PIMXI"},
                {"ARTUR CARDOSO BERNARDES", "DUWXU EHUQDUGHV"},
                {"GUILLERMO ENRIQUE FERREIRA RENDON", "CQEHDANIK NAJZKJ"}
        };

        for (String[] entrada : hashesGrupo) {
            String nome = entrada[0];
            String hash = entrada[1];

            // Força bruta: testa os 26 deslocamentos e fica com o melhor
            int melhorPontos = -1;
            int melhorK = 0;
            String melhorTexto = "";

            for (int k = 0; k < 26; k++) {
                String texto = decifrarCaesar(hash, k);
                int pontos = pontuacao(texto, nome);
                if (pontos > melhorPontos) {
                    melhorPontos = pontos;
                    melhorK = k;
                    melhorTexto = texto;
                }
            }

            System.out.println("Aluno: " + nome);
            System.out.println("Hash:  " + hash);
            System.out.println("  Mensagem: " + melhorTexto + " (K = " + melhorK + ")");
            System.out.println();
        }
    }
}